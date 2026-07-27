import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < moves.length; i++) {
            int toy = 0;
            int idx = moves[i] - 1;
            int j = 0;
            while(j < board.length && toy == 0) {
                if(board[j][idx] != 0) {
                    toy = board[j][idx];
                    board[j][idx] = 0;
                }
                j++;
            }

            if(toy == 0) continue;

            if(!stack.isEmpty() && toy == stack.peek()) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(toy);
            }
        }

        return answer;
    }
}
