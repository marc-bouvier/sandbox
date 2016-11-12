package fr.bouvier.marc.util;

import java.io.File;

/**
 * Utils for file checking.
 */
class FileUtils {
    /**
     * @param path path
     * @return true if the file is a directory
     */
    static boolean isDirectory(final String path) {
        File file = new File(path);
        return file.isDirectory();
    }

    /**
     * @param path path
     * @return true if the file exists
     */
    static boolean fileExists(final String path) {
        File file = new File(path);
        return file.exists();
    }
}
