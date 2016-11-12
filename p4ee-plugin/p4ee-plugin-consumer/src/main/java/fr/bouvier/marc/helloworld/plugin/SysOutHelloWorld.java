package fr.bouvier.marc.helloworld.plugin;

/** Simple implementation of plugin HelloWorld. */
public class SysOutHelloWorld implements HelloWorld {
    @Override
    public void helloWorld() {
        System.out.println("Hello World !" +
                "\n Simple implementation. You can change impelmentation by configuration.");
    }
}
