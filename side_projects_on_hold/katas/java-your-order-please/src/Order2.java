import java.util.Comparator;
/** Une autre solution.*/
public class Order2 {
    public static String order(String w) {
        String[] words = w.split(" ");
        java.util.Arrays.sort(words, Comparator.comparingInt(Order2::getWordNum));
        return String.join(" ", words);
    }

    private static int getWordNum(String s) {
        return Integer.parseInt(s.replaceAll("[^\\d]+", ""));
    }
}
