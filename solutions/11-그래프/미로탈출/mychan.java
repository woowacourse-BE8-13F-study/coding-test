import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;

        // 미로를 나타낸 문자열 배열 maps
        // return 미로를 탈출하는데 필요한 최소 시간

        int row = maps.length;
        int col = maps[0].length();

        int startRow = 0;
        int startCol = 0;
        int leverRow = 0;
        int leverCol = 0;

        char[][] arr = new char[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                Character c = maps[i].charAt(j);
                arr[i][j] = c;
                if (c == 'S') { startRow = i; startCol = j; }
                if (c == 'L') { leverRow = i; leverCol = j; }
            }
        }

        int toLever = bfs(row, col, startRow, startCol, 'L', arr);
        int toExit  = bfs(row, col, leverRow, leverCol, 'E', arr);

        if (toLever == -1 || toExit == -1) return -1;

        return toLever + toExit;
    }

    int bfs(int row, int col, int startRow, int startCol, char target, char[][] arr) {

        int[][] div = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };

        boolean[][] isVisited = new boolean[row][col];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startRow, startCol, 0});
        isVisited[startRow][startCol] = true;

        int time=-1;

        while(!q.isEmpty()) {

            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            time = current[2];

            if(arr[r][c] == target) return time;

            for(int[] d : div) {

                int nr = r + d[0];
                int nc = c + d[1];
                int depth = time + 1;

                // 범위에 맞고, 갈 수 있고, 방문하지 않았으면 큐에 넣는다.
                if(nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    if(arr[nr][nc] != 'X' && !isVisited[nr][nc]) {
                        q.offer(new int[]{nr, nc, depth});
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }

        return -1;
    }
}