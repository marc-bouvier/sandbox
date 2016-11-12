package fr.bouvier.marc;

import fr.bouvier.marc.configuration.PluginFactory;
import fr.bouvier.marc.helloworld.plugin.HelloWorld;

/**
 * Runnable application
 */
public class MainApp {

    public static  void  main(final String[] args) {

        // Plugin implementation is loaded from external configuration
        // It is possible to choose implementation at runtime since it is added to classpath
        final HelloWorld plugin = PluginFactory.loadPlugin(HelloWorld.class);

        plugin.helloWorld();

    }
}
