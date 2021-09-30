import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

/**
 * Solution qui me semble élégante combinant le meilleur des différents mondes.
 */
public class Order4 {
    public static String order(String words) {
        return Pattern.compile("\\s")
                .splitAsStream(words)
                .sorted(comparingInt(Order4::numberFromWord))
                .collect(Collectors.joining(" "));
    }

    private static int numberFromWord(String s) {
        return Integer.parseInt(s.replaceAll("[^\\d]+", ""));
    }
}
