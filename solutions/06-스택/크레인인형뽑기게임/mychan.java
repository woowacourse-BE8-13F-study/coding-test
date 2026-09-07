import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        // 2차원 board, 크레인을 작동시킨 위치 배열 moves
        // 크레인을 모두 작동시킨 후 사라진 인형의 개수

        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;

        for(int col : moves) {

            for(int i = 0; i < board.length; i++) {

                int next = board[i][col-1];

                if(next != 0) {
                    board[i][col-1] = 0;

                    if(!stack.isEmpty() && stack.peekLast() == next) {
                        stack.pollLast();
                        count += 2;
                    } else {
                        stack.add(next);
                    }
                    break;
                }
            }
        }

        return count;
    }
}