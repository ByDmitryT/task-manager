package ru.titov.taskmanagerserver.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;
import ru.titov.taskmanagerserver.error.user.InvalidUserTokenException;
import ru.titov.taskmanagerserver.error.user.UserTokenTimeOutException;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

@Component
public class TokenUtil {

    private SecretKeySpec secretKey;

    @Value("${token.secret}")
    private String secret;

    @Value("${token.timeout}")
    private long timeout;

    @PostConstruct
    public void setSecretKey() {
        MessageDigest sha;
        try {
            byte[] key = secret.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NotNull
    public String encrypt(@Nullable final TokenData tokenData) throws AbstractUserException {
        if (tokenData == null) throw new InvalidUserInputException();
        try {
            final ObjectWriter objectWriter = new ObjectMapper().writer();
            final String tokenDataJson = objectWriter.writeValueAsString(tokenData);
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(tokenDataJson.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new InvalidUserInputException();
        }
    }

    @NotNull
    public TokenData decrypt(@Nullable final String token) throws AbstractUserException {
        if (token == null) throw new InvalidUserTokenException();
        final TokenData tokenData;
        try {
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final String tokenDataJson = new String(cipher.doFinal(Base64.getDecoder().decode(token)));
            final ObjectMapper objectMapper = new ObjectMapper();
            tokenData = objectMapper.readValue(tokenDataJson, TokenData.class);
        } catch (Exception e) {
            throw new InvalidUserTokenException();
        }
        if (tokenData.getCreated() / 1000 + timeout < new Date().getTime() / 1000)
            throw new UserTokenTimeOutException();
        return tokenData;
    }

}
