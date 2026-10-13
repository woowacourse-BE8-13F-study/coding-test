import java.util.*;

class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                land[i][j] += findMaxValue(land, i, j);
            }
        }

        return Arrays.stream(land[land.length - 1])
                .max()
                .getAsInt();
    }

    public int findMaxValue(int[][] land, int curRow, int curCol) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            if (i == curCol) {
                continue;
            }

            max = Math.max(max, land[curRow - 1][i]);
        }

        return max;
    }
}
