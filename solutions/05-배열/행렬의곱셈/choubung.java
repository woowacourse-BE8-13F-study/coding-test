/*
행렬 공식이 애매하게 기억나서 찾아봤다...
 */

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr1[0].length;
        int l = arr2[0].length;

        int[][] answer = new int[n][l];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                answer[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < m; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
