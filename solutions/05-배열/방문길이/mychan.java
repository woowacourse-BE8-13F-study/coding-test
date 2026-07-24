import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        // 처음 걸어본 길의 길이
        // 하나의 길 : [[0,0], [0,1]]
        int[][] dir = {
                {0, 1}, // U
                {1, 0}, // R
                {0, -1},// D
                {-1, 0} // L
        };

        int[] current = {0, 0};
        int[] next = {0, 0};
        Set<String> line = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            int dx = 0;
            int dy = 0;

            if ('U' == dirs.charAt(i)) {
                dx = dir[0][0];
                dy = dir[0][1];
            } else if ('R' == dirs.charAt(i)) {
                dx = dir[1][0];
                dy = dir[1][1];
            } else if ('D' == dirs.charAt(i)) {
                dx = dir[2][0];
                dy = dir[2][1];
            } else if ('L' == dirs.charAt(i)) {
                dx = dir[3][0];
                dy = dir[3][1];
            }

            next = new int[]{current[0] + dx, current[1] + dy};

            if (next[0] > 5 || next[0] < -5 || next[1] > 5 || next[1] < -5) {
                continue;
            }

            String path1 = current[0] + "," + current[1] + "-" + next[0] + "," + next[1];
            String path2 = next[0] + "," + next[1] + "-" + current[0] + "," + current[1];

            line.add(path1);
            line.add(path2);
            current = next;
        }
        return line.size() / 2;
    }
}