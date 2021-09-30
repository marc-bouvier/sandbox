import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountingDuplicates3 {
    public static int duplicateCount(String text) {
        return (int) text.toLowerCase()
                .chars()
                .boxed()
                .collect(groupingBy(k -> k, counting()))
                .values()
                .stream()
                .filter(e -> e > 1)
                .count();
    }
}
