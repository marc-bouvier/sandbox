import java.util.HashSet;
import java.util.Set;

public class CountingDuplicates {
    public static int duplicateCount(String text) {

        if (text == null)
            return 0;
        //Set contains no duplicate element
        Set<Character> duplicateLetters = new HashSet<>();
        String lowerCaseText = text.toLowerCase();
        char[] charArray = lowerCaseText.toCharArray();
        for (Character letter : charArray) {
            if (isDuplicate(lowerCaseText, letter)) {
                duplicateLetters.add(letter);
            }
        }
        return duplicateLetters.size();


    }

    private static boolean isDuplicate(String text, Character letter) {
        return text.indexOf(letter) != text.lastIndexOf(letter);
    }
}
