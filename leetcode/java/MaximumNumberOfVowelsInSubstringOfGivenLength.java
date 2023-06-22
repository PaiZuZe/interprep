public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int nVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                nVowels++;
            }
        }
        int maxVowels = nVowels;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                nVowels--;
            }
            if (isVowel(s.charAt(i))) {
                nVowels++;
            }
            maxVowels = Math.max(maxVowels, nVowels);
        }
        return maxVowels;
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }
}
