package fr.bouvier.marc.helloworld.plugin;

/**
 * Interface for HelloWorld plugin.
 * <p>This plugin can be loaded using {@link fr.bouvier.marc.configuration.PluginFactory}.</p>
 */
public interface HelloWorld {

    /** Says Hello world. */
    void helloWorld();
}
