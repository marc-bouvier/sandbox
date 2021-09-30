import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Utilisation de splitAsStream.
 */
public class Order3 {
    public static String order(String words) {
        return Pattern.compile("\\s").splitAsStream(words).sorted((a, b) -> {
            Matcher am = Pattern.compile("\\d").matcher(a), bm = Pattern.compile("\\d").matcher(b);
            am.find(); bm.find();
            return Integer.parseInt(am.group(0)) - Integer.parseInt(bm.group(0));
        }).collect(Collectors.joining(" "));
    }
}
