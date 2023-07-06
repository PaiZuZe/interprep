import java.util.Arrays;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] tribSequence = new int[] {0, 1, 1};
        if (n < 3) {
            return tribSequence[n];
        }
        for (int i = 3; i <= n; i++) {
            int[] temp = Arrays.copyOf(tribSequence, 3);
            tribSequence[2] = temp[2] + temp[1] + temp[0];
            tribSequence[1] = temp[2];
            tribSequence[0] = temp[1];
        }
        return tribSequence[2];
    }
}
