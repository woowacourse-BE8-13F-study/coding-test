class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1_row = arr1.length;
        int arr1_col = arr1[0].length;
        int arr2_row = arr2.length;
        int arr2_col = arr2[0].length;

        int[][] answer = new int[arr1_row][arr2_col];

        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < answer[0].length; j++) {
                answer[i][j] = 0;
                for(int k = 0; k < arr1_col; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
