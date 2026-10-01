class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        int maxX = board[0] / 2;   // 가로 경계
        int maxY = board[1] / 2;   // 세로 경계

        for (String key : keyinput) {
            if (key.equals("up") && y + 1 <= maxY)  y++;
            if (key.equals("down") && y - 1 >= -maxY) y--;
            if (key.equals("left") && x - 1 >= -maxX) x--;
            if (key.equals("right") && x + 1 <= maxX)  x++;
        }
        return new int[]{x, y};
    }
}