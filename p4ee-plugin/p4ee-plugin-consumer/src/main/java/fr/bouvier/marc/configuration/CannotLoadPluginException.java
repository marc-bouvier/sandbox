package fr.bouvier.marc.configuration;

/**
 * Exception to be thrown when a plugin cannot be loaded from configuration.
 */
class CannotLoadPluginException extends RuntimeException {
    CannotLoadPluginException(final String message) {
        super(message);
    }
}
