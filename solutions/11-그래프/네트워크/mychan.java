class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                if(computers[i][j] == 1) {
                    dfs(n, i, computers);
                    answer++;
                }
            }
        }
        return answer;
    }

    void dfs(int n, int i, int[][] computers) {
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1) {
                computers[i][j] = 0;
                computers[j][i] = 0;
                dfs(n, j, computers);
            }
        }
    }
}