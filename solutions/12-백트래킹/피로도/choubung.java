/*
백트래킹 너무 어렵다...
 */

import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(dungeons, 0, k);

        return answer;
    }

    public void dfs(int[][] dungeons, int depth, int hp) {
        answer = Math.max(answer, depth);

        if (depth == dungeons.length) {
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (hp < dungeons[i][0]) {
                    continue;
                }

                visited[i] = true;
                dfs(dungeons, depth + 1, hp - dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}
