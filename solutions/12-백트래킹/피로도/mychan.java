class Solution {

    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k,0,dungeons, visited);
        return answer;
        // 순열 백트래킹
        // 선택
        // 탐색
        // 되돌리기
    }

    private void dfs(int k, int depth, int[][] dungeons, boolean[] visited) {

        answer = Math.max(answer, depth);

        for(int i=0; i< dungeons.length; i++) {

            int need = dungeons[i][0];
            int cost = dungeons[i][1];

            if(!visited[i] && k >= need) {
                visited[i] = true;
                dfs(k-cost, depth+1, dungeons, visited);
                visited[i] = false;
            }
        }
    }
}