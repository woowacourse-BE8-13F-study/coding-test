/*
처음에 단순하게 양 쪽 부모의 값을 모두 더한 값이 자신이 된다고 생각했다.
그러나 해당 경로로 오면서 제일 합이 큰 경우를 구하면 됐다.
처음에는 매경로를 구할 떄마다 answer 값을 갱신했는데, 생각해보니 마지막 줄에서만 구하면 돼서 그렇게 고쳤다.
 */
class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;

        int n = triangle.length;
        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            int j = 0;

            for (int num : triangle[i]) {
                dp[i][j] = num;

                int leftSum = 0;
                if (j-1 >= 0) {
                    leftSum = dp[i - 1][j-1];
                }

                int rightSum = 0;
                if (j < i) {
                    rightSum = dp[i - 1][j];
                }

                dp[i][j] += Math.max(leftSum, rightSum);
                j++;
            }
        }

        for (int sum : dp[n-1]) {
            answer = Math.max(answer, sum);
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return answer;
    }
}
