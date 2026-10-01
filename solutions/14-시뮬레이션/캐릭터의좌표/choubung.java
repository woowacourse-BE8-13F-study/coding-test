/*
처음 했던 실수는 좌표 이동 값을, 개념적 이동이 아니라 배열의 행/열 기준으로 잡은 것이다
그리고 코드 자체도 너무 복잡하게 작성했다...
switch문을 쓰고 경계검사를 즉각적으로 해서 옮길지 아닐지를 정했다.
 */

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        int x = 0;
        int y = 0;

        for (String key : keyinput) {
            switch(key) {
                case "up":
                    if (y + 1 <= maxY) y++;
                    break;
                case "down":
                    if (y - 1 >= maxY * -1) y--;
                    break;
                case "left":
                    if (x - 1 >= maxX * -1) x--;
                    break;
                case "right":
                    if (x + 1 <= maxX) x++;
                    break;
            }
        }

        return new int[]{x, y};
    }
}

/*
첫 코드

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    int[] cur = {0, 0};

    public int[] solution(String[] keyinput, int[] board) {
        int x = board[0] / 2;
        int y = board[1] / 2;

        for (String key : keyinput) {
            move(key, x, y);
            // System.out.println("x: " + cur[0] + ", y: " + cur[1]);
        }

        return cur;
    }

    public void move(String command, int x, int y) {
        int index = 0;

        if ("down".equals(command)) {
            index = 1;
        } else if ("left".equals(command)) {
            index = 2;
        } else if ("right".equals(command)) {
            index = 3;
        }

        int nextX = cur[0] + dx[index];
        int nextY = cur[1] + dy[index];

        if (nextX > x) {
            nextX = x;
        } else if (nextX < x * -1) {
            nextX = x * -1;
        }

        if (nextY > y) {
            nextY = y;
        } else if (nextY < y * -1) {
            nextY = y * -1;
        }

        cur[0] = nextX;
        cur[1] = nextY;
     }
}
 */
