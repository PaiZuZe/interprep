public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] freqs = new int[2001];
        boolean[] uniqueFreqs = new boolean[1001];

        for (int x : arr) {
            int OFFSET = 1000;
            freqs[x + OFFSET]++;
        }

        for (int freq : freqs) {
            if (freq == 0) {
                continue;
            }
            if (uniqueFreqs[freq]) {
                return false;
            }
            uniqueFreqs[freq] = true;
        }
        return true;
    }
}

