/*
이 문제는 그래도 그렇게 어렵지 않아서 이해가 가는데...
조금 더 복잡해지면 풀 수 있을지 모르겠다...
 */

class Solution {
    public long solution(int n) {
        if (n == 1) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
