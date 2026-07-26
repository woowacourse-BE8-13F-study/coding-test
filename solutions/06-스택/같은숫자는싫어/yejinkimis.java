import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int num : arr) {
            if(stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        int stackSize = stack.size();
        int[] answer = new int[stackSize];
        for(int i = stackSize - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
