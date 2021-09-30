import java.util.*;

/** Similar to mine but uses strings instead of chars.*/
public class CountingDuplicates4 {
    public static int duplicateCount(String text) {
        Set<String> count = new HashSet<>();

        for (String string : text.toLowerCase().split("")) {
            if (text.toLowerCase().indexOf(string) != text.toLowerCase().lastIndexOf(string)) count.add(string);
        }

        return count.size();
    }
}
