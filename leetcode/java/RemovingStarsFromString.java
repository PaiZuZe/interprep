public class RemovingStarsFromString {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        char[] stringAsCharArray = s.toCharArray();

        for (char c : stringAsCharArray) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
