package fr.bouvier.marc.configuration;


/**
 * Exception to be thrown when configuration file for plugins cannot be loaded.
 */
class CannotLoadPluginsConfigurationFileException extends RuntimeException {
    CannotLoadPluginsConfigurationFileException(final Throwable e) {
        super(e);
    }
}
