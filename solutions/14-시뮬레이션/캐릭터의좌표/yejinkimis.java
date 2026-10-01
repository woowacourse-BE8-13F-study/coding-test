import java.util.*;

class Solution {

    public int[] solution(String[] keyinput, int[] board) {

        int x = 0;
        int y = 0;

        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        for (String input : keyinput) {
            if (input.equals("up") && y < maxY) {
                y++;
            }
            if (input.equals("down") && y > -maxY) {
                y--;
            }
            if (input.equals("left") && x > -maxX) {
                x--;
            }
            if (input.equals("right") && x < maxX) {
                x++;
            }
        }

        return new int[]{x, y};
    }
}
