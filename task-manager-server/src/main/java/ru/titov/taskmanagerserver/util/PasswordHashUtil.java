package ru.titov.taskmanagerserver.util;

import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;

public enum PasswordHashUtil {
    ;

    public static String md5(String password) throws InvalidUserInputException {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new InvalidUserInputException();
        }
    }
}
