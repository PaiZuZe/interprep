public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        return guessNumber(1, n + 1);
    }

    private int guessNumber(int start, int end) {
        int middle = ((end - start) / 2) + start;
        if (guess(middle) == 0) {
            return middle;
        } else if (guess(middle) == -1) {
            return guessNumber(start, middle);
        }
        return guessNumber(middle + 1, end);
    }

    private int guess(int a) {
        return -1;
    }
}
