/*
스택이 비어있지 않은지 체크하지 않아서 예외가 발생했다.
 */

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.size() > 0 && stack.peek() == c) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        if (stack.size() == 0) {
            answer = 1;
        }

        return answer;
    }
}
