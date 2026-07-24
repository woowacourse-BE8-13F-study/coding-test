import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] current = new int[2];
        int[] next = new int[2];

        Set<String> visitedLines = new HashSet<>();

        current[0] = 0;
        current[1] = 0;

        for(int i = 0; i < dirs.length(); i++){
            String line = "";

            line+=current[0];
            line+=", " + current[1];

            next[0] = current[0];
            next[1] = current[1];

            char dir = dirs.charAt(i);

            if(dir == 'U' && isInside(current[1], current[1] + 1)) {
                next[1] += 1;
            } else if(dir == 'D' && isInside(current[0], current[1] - 1)) {
                next[1] -= 1;
            } else if(dir == 'R' && isInside(current[0] + 1, current[1])) {
                next[0] += 1;
            } else if(dir == 'L' && isInside(current[0] - 1, current[1])) {
                next[0] -= 1;
            } else {
                continue;
            }

            line += ", " + next[0];
            line += ", " + next[1];
            visitedLines.add(line);

            String reversedVisitedLine = reversePositionOrder(current, next);
            visitedLines.add(reversedVisitedLine);

            current[0] = next[0];
            current[1] = next[1];
        }
        return visitedLines.size() / 2;
    }

    private String reversePositionOrder(int[] cur, int[] next) {
        String line = "";
        line += next[0];
        line += ", " + next[1];
        line += ", " + cur[0];
        line += ", " + cur[1];
        return line;
    }

    private boolean isInside(int x,  int y) {
        if(x < -5 || x > 5) return false;
        if(y < -5 || y > 5) return false;
        return true;
    }
}
