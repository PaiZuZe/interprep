import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] successfulSpells = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int smallest = (int) Math.ceil(((double) success) / spells[i]);
            int k = binarySearch(potions, smallest);
            successfulSpells[i] = potions.length - k;
        }
        return successfulSpells;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int middle = left + ((right - left) / 2);
            if (arr[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }
}
