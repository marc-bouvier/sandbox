package fr.bouvier.marc.util;

import static fr.bouvier.marc.util.FileUtils.fileExists;
import static fr.bouvier.marc.util.FileUtils.isDirectory;
import static fr.bouvier.marc.util.StringUtils.isBlank;

/**
 * Assertions to simplify argument validation.
 */
public class Assert {

    public static void assertValidPropertiesFile(final String path, final String validationErrorMessage) {
        if(isBlank(path)||!path.endsWith(".properties")||!fileExists(path)){
            throw new IllegalArgumentException(validationErrorMessage);
        }
    }

}
