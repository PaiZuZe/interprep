import java.util.Stack;

public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        Stack<Character> vowels = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowels.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                sb.append(vowels.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return switch (Character.toLowerCase(c)) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}
