package br.lablink.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String hashPasswordWithMD5(String password) {
        return DigestUtils.md5Hex(password).toUpperCase();
    }

    public static boolean validatePassword(String hashedPassword, String password) {
        return hashPasswordWithMD5(password).equalsIgnoreCase(hashedPassword);
    }
}