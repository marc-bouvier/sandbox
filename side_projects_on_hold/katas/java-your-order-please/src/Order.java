import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;

/**
 * My solutions.
 */
class Order {
    /**
     * First intuitive version.
     */
    static String order(String words) {
        if (words == null || "".equals(words)) {
            return "";
        }
        final String[] actualWords = words.split(" ");
        Map<Integer, String> groupedWords = new TreeMap<>();
        for (String word : actualWords) {

            final Pattern pattern = Pattern.compile("^(.*)([0-9]+)(.*)");
            final Matcher matcher = pattern.matcher(word);
            matcher.find();
            final String number = matcher.group(2);
            groupedWords.put(Integer.valueOf(number), word);
        }

        return groupedWords.values().stream().collect(joining(" "));
    }

    /** Final version with use of lambda.*/
    static String orderLambda(String words) {
        if (words == null || "".equals(words)) {
            return "";
        }
        return Stream.of(words.split(" "))
                .sorted(comparingInt(Order::extractNumberFromWord))
                .collect(joining(" "));
    }

    private static Integer extractNumberFromWord(final String o1) {
        final Pattern compile = Pattern.compile("^(.*)([0-9]+)(.*)");
        final Matcher matcher1 = compile.matcher(o1);
        matcher1.find();
        final String number1 = matcher1.group(2);
        return Integer.valueOf(number1);
    }
}