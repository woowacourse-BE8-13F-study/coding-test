import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            String rotatedString = rotate(s, i);
            if(isCorrectParentheses(rotatedString)) {
                answer += 1;
            }
        }
        return answer;
    }

    private String rotate(String s, int n) {
        return new String(s.substring(n, s.length()) + s.substring(0, n));
    }

    private boolean isCorrectParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '['
                    || !stack.isEmpty() && s.charAt(i) == '}' && stack.peek() == '{'
                    || !stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
