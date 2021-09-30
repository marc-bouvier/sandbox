import java.util.Map;


import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/** Solution using lambdas. */
public class CountingDuplicates2 {
    private static Map<Character, Long> charFrequenciesMap(final String text) {
        return text.codePoints()
                .map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));
    }

    static int duplicateCount(final String text) {
        return (int) charFrequenciesMap(text).values().stream()
                .filter(i -> i > 1)
                .count();
    }
}
