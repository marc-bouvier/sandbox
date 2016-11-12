package fr.bouvier.marc.util;

/**
 * Utils on Strings
 */
class StringUtils {
    /**
     * @param argument string
     * @return true if a String is null or only whitespaces
     */
    static boolean isBlank(final String argument) {
        return argument == null || argument.trim().equals("");
    }
}
