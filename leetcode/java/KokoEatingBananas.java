import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) {
            return (int) Math.ceil(piles[0] / (double) h);
        }
        int right = getMax(piles) + 1;
        int left = 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            int amountOfTime = getAmountOfTime(piles, middle);
            if (amountOfTime <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private int getAmountOfTime(int[] piles, int rate) {
        int amountOfTime = 0;
        for (int pile: piles) {
            amountOfTime += Math.ceil(pile / (double) rate);
        }
        return amountOfTime;
    }

    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x: arr) {
            max = Math.max(x, max);
        }
        return max;
    }
}
