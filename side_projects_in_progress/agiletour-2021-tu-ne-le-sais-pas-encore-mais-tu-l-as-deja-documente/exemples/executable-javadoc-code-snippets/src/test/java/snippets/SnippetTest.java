package snippets;

import fr.baldir.samples.hello.Hello;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SnippetTest {

    @Test
    public void someTest() {
        // @start region="test-region"
        Hello hello = new Hello();
        var greetings = hello.sayHello("JEP 413");
        // @end
        Assertions.assertThat(greetings).isEqualTo("Hello JEP 413");
    }
}
