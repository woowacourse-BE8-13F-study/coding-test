class Solution {

    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;

    }

    private void dfs(int cur, int[][] computers) {
        visited[cur] = true;
        for(int i=0; i< computers.length; i++){
            if(!visited[i] && computers[cur][i] == 1){
                dfs(i, computers);
            }
        }
    }
}
