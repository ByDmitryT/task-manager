package ru.titov.taskmanagerserver.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;

import java.security.MessageDigest;

@Component
public class PasswordHashUtil {

    @NotNull
    public String md5(@Nullable String password) throws InvalidUserInputException {
        if (password == null || password.isEmpty()) throw new InvalidUserInputException();
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            final byte[] array = md.digest(password.getBytes());
            final StringBuilder sb = new StringBuilder();
            for (final byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new InvalidUserInputException();
        }
    }
}
