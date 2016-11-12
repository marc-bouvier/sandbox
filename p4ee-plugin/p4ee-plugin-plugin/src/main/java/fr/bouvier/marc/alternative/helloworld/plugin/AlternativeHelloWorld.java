package fr.bouvier.marc.alternative.helloworld.plugin;

import fr.bouvier.marc.helloworld.plugin.HelloWorld;

/**
 * Alternative implementation for HelloWorld plugin.
 */
public class AlternativeHelloWorld implements HelloWorld {

    @Override
    public void helloWorld() {
        System.out.println("Hello World ! Alternative implementation. " +
                "\nConsumer does not know about the implementation " +
                "detail of this plugin before runtime!");

    }
}
