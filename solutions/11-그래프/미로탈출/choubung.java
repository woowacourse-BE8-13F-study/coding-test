/*
bfs를 다 까먹었다!! ㅠ
언제 node 쓰고 언제 String으로 해야할 지 모르겠달까...
int[]로 했어도 됐을 것 같긴하다...
이게 최선의 방법은 아닐 것 같은데.. 더 깔끔하게 할 생각이 안 난다.
 */

import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps) {
        int road1 = bfs(maps, 'S', 'L');
        if (road1 == -1) {
            return -1;
        }

        int road2 = bfs(maps, 'L', 'E');

        if (road2 == -1) {
            return -1;
        }

        System.out.println("1. " + road1 +" / 2. " + road2);

        return road1 + road2;
    }

    public int bfs(String[] maps, char start, char target) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];

        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == start) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current);

            int x = current.x;
            int y = current.y;
            int dis = current.dis;

            if (maps[x].charAt(y) == target) {
                return dis;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, dis + 1));
                    }
                }
            }
        }

        return -1;
    }

    class Node {
        int x;
        int y;
        int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
