/*
자바의 함수 참조 방식 때문에, 원본 배열이 훼손되는 문제가 생겼었다.
 */
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            deque.offer(c);
        }

        for (int i = 0; i < len; i++) {
            if (isPossible(deque)) {
                answer++;
            }

            char first = deque.poll();
            deque.offer(first);
        }

        return answer;
    }

    public boolean isPossible(Deque<Character> deque) {
        Deque<Character> queue = new ArrayDeque<>(deque);;

        Deque<Character> stack = new ArrayDeque<>();
        while (queue.size() > 0) {
            if (isStart(queue.peek())) {
                stack.push(queue.poll());
                continue;
            }

            if (stack.size() == 0 || !isMatch(stack.pop(), queue.poll())) {
                return false;
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }

    public boolean isStart(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public boolean isMatch(char open, char close) {
        return open == '(' && close == ')' ||
                open == '[' && close == ']' ||
                open == '{' && close == '}';
    }
}
