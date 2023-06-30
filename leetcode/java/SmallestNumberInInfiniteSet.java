import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
    boolean[] set;
    int smallest;

    public SmallestNumberInInfiniteSet() {
        set = new boolean[1000];
        smallest = 0;
    }

    public int popSmallest() {
        set[smallest] = true;
        int temp = smallest;
        for (int i = smallest + 1; i < set.length; i++) {
            if (!set[i]) {
                smallest = i;
                break;
            }
        }
        return temp + 1;
    }

    public void addBack(int num) {
        set[num - 1] = false;
        if (num - 1 < smallest) {
            smallest = num - 1;
        }
    }
}
