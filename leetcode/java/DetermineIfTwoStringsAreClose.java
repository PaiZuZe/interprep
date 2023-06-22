import java.util.HashMap;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] word1CharArr = word1.toCharArray();
        int[] word1CharFreq = new int[256];
        for (char c : word1CharArr) {
            word1CharFreq[c]++;
        }

        char[] word2CharArr = word2.toCharArray();
        int[] word2CharFreq = new int[256];
        for (char c : word2CharArr) {
            word2CharFreq[c]++;
        }

        Map<Integer, Integer> word1FreqFreq = new HashMap<Integer, Integer>();
        Map<Integer, Integer> word2FreqFreq = new HashMap<Integer, Integer>();

        boolean hasToTransform = false;
        for (int i = 0; i < word1CharFreq.length; i++) {
            word1FreqFreq.merge(word1CharFreq[i], 1, Integer::sum);
            word2FreqFreq.merge(word2CharFreq[i], 1, Integer::sum);

            if (word1CharFreq[i] != word2CharFreq[i]) {
                hasToTransform = true;
            }
            if ((word1CharFreq[i] == 0 && word2CharFreq[i] != 0) || (word2CharFreq[i] == 0 && word1CharFreq[i] != 0)) {
                return false;
            }
        }
        if (!hasToTransform) {
            return true;
        }

        return word1FreqFreq.entrySet().equals(word2FreqFreq.entrySet());
    }
}

