/*
작은 규칙성을 찾아 순회하는 게 어렵다...
 */

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        boolean[][] isPuddle = new boolean[n+1][m+1];

        for (int[] p : puddles) {
            isPuddle[p[1]][p[0]] = true;
        }

        dp[1][1] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if ((i == 1 && j == 1) || isPuddle[i][j]) {
                    continue;
                }

                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_007;
            }
        }

        return dp[n][m];
    }
}
