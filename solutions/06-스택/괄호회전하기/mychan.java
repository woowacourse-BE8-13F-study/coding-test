import java.util.*;

class Solution {
    public int solution(String s) {
        int count=0;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isTrue(rotated)) {
                count++;
            }
        }
        return count;
    }

    public boolean isTrue(String s) {

        Map<Character, Character> mapping = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        mapping.put('[', ']');
        mapping.put('{', '}');
        mapping.put('(', ')');

        for(int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            // 여는 괄호
            if(c == '[' || c == '{' || c == '(') {
                stack.add(c);
            } else if(c == ']' || c == '}' || c == ')') { // 닫는 괄호
                if(!stack.isEmpty()) {
                    char top = stack.peekLast();
                    if(mapping.containsKey(top) && mapping.get(top) == c) {
                        stack.pollLast();
                    }
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.isEmpty();
    }
}