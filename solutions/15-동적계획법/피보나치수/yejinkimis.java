class Solution {
    public int solution(int n) {
        int[] fArr = new int[n + 1];
        fArr[0] = 0;
        fArr[1] = 1;
        for(int i = 2; i <= n; i++) {
            fArr[i] = (fArr[i-1] + fArr[i-2]) % 1234567;
        }
        return fArr[n];
    }
}
