import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        List<Boolean> resp = new ArrayList<>(candies.length);
        for (int candy : candies) {
            resp.add((candy + extraCandies) >= max);
        }
        return resp;
    }
}
