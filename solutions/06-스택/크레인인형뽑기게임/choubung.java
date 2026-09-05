/*
주어진 배열의 배열 방식을 행 열 거꾸로 이해해서 처음에 시간을 꽤 날렸다.
이후에는 0은 push하지 말았어야 했는데, 제거하지 않아서 문제가 생겼다.
뽑기 칸의 인덱스도 0부터 시작하지 않는다는 걸 놓쳤다.
 */
import java.util.*;

class Solution {
    static int answer = 0;

    public int solution(int[][] board, int[] moves) {
        int n = board.length;

        Deque<Integer> stack = new ArrayDeque<>();

        List<Deque<Integer>> box = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            box.add(new ArrayDeque<>());

            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    box.get(i).push(board[j][i]);
                }
            }
        }

        for (int move : moves) {
            int index = move - 1;

            if (box.get(index).size() > 0) {
                Integer taken = box.get(index).pop();
                take(taken, stack);
            }
        }

        return answer;
    }

    public void take(Integer num, Deque<Integer> stack) {
        if (num == 0) {
            return;
        }

        if (stack.size() > 0 && num.equals(stack.peek())) {
            stack.pop();
            answer += 2;
            return;
        }

        stack.push(num);
    }
}
