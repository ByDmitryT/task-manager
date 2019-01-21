package ru.titov.taskmanagerserver.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ru.titov.taskmanagerserver.config.AppConfig;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;
import ru.titov.taskmanagerserver.error.user.InvalidUserTokenException;
import ru.titov.taskmanagerserver.error.user.UserTokenTimeOutException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

public enum TokenUtil {
    ;

    private static final String SECRET = AppConfig.TOKEN_SECRET;

    private static final long TIMEOUT = AppConfig.TOKEN_TIMEOUT;

    private static SecretKeySpec secretKey;

    static {
        MessageDigest sha;
        try {
            byte[] key = SECRET.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(final TokenData tokenData) throws AbstractUserException {
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

    public static TokenData decrypt(final String token) throws AbstractUserException {
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
        if (tokenData.getCreated() / 1000 + TIMEOUT < new Date().getTime() / 1000)
            throw new UserTokenTimeOutException();
        return tokenData;
    }

}
