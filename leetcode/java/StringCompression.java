public class StringCompression {
    public int compress(char[] chars) {
        char currentChar = chars[0];
        int count = 1;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (currentChar == chars[i]) {
                count++;
            } else {
                j = writeCompression(currentChar, count, chars, j);
                currentChar = chars[i];
                count = 1;
            }
        }
        return writeCompression(currentChar, count, chars, j);
    }

    private int writeCompression(char c, int count, char[] target, int start) {
        target[start++] = c;
        if (count > 1) {
            String strCount = String.valueOf(count);
            for (int k = 0; k < strCount.length(); k++) {
                target[start++] = strCount.charAt(k);
            }
        }
        return start;
    }
}
