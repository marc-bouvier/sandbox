package fr.baldir.samples.hello;

public class Hello {
    /**
     * Greets someone.
     * <p>Usage</p>
     * {@snippet class="snippets.SnippetTest" region="test-region"}
     *
     * @param name target of greetings
     * @return full greeting sentence
     */
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
