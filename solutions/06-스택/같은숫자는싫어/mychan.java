import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<arr.length; i++) {
            // 비어있거나, 제일 최근 숫자가 다른 숫자이면 push 한다.
            if(stack.isEmpty() || stack.peekLast() != arr[i]) {
                stack.add(arr[i]);
            }
        }

        // stack을 배열로 변환
        return stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}