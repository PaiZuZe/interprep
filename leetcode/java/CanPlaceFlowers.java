public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int planted = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (ableToPlant(flowerbed, i)) {
                flowerbed[i] = 1;
                planted++;
            }
        }
        return planted >= n;
    }

    private boolean ableToPlant(int[] flowerbed, int i) {
        if (flowerbed[i] == 1) {
            return false;
        }
        if (i == 0 && i == flowerbed.length - 1) {
            return true;
        }
        if (i == 0) {
            return flowerbed[i + 1] == 0;
        } else if (i == flowerbed.length - 1) {
            return flowerbed[i - 1] == 0;
        } else {
            return flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0;
        }
    }
}
