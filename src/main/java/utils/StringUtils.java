package utils;

public class StringUtils {
    // Remove Special Character form the String
    public static String removeSpecialCharacter(String specialCharacter, String value)
    {
        if (value != null) {
            value = value.replaceAll(specialCharacter, "");
        }
        return value;
    }
}