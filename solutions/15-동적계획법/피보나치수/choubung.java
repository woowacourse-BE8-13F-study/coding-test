/*
점화식이 너무 유명하고 익숙하고 명확한 문제라 딱히 어려운 게 없었다.
 */

class Solution {
    public int solution(int n) {
        int[] f = new int[n+1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            f[i] = (f[i-2] + f[i-1]) % 1234567;
        }

        return f[n];
    }
}
