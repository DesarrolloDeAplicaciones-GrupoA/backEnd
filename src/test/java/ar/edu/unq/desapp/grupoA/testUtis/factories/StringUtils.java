package ar.edu.unq.desapp.grupoA.testUtis.factories;


import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {

    public static String getEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@example.com";
    }

    public static String getName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
