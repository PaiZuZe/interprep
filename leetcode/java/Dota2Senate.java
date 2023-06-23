import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new ArrayDeque<>();
        char[] senateCharArray = senate.toCharArray();
        int direBans = 0;
        int radiantBans = 0;

        for (char c: senateCharArray) {
            if (c == 'D') {
                if (direBans == 0) {
                    radiantBans++;
                    queue.add(c);
                } else {
                    direBans--;
                }
            } else {
                if (radiantBans == 0) {
                    direBans++;
                    queue.add(c);
                } else {
                    radiantBans--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean direPresent = false;
        boolean radiantPresent = false;

        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == 'D') {
                if (direBans == 0) {
                    direPresent = true;
                    sb.append(c);
                } else {
                    direBans--;
                }
            } else {
                if (radiantBans == 0) {
                    radiantPresent = true;
                    sb.append(c);
                } else {
                    radiantBans--;
                }
            }
        }

        if (radiantPresent && direPresent) {
            return predictPartyVictory(sb.toString());
        }
        if (radiantPresent) {
            return "Radiant";
        }
        return "Dire";
    }
}
