package fr.bouvier.marc.configuration;

/**
 * Exception to be thrown when plugin instantiation fails.
 */
class PluginInstantiationException extends RuntimeException {
    PluginInstantiationException(final Throwable e) {
        super(e);
    }
}
