import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            // 비어있으면 넣고
            if(stack.isEmpty()) {
                stack.add(c);
            } else {
                // 있으면 비교
                char top = stack.peekLast();

                // 동일하면 poll하고,
                if(top == c) {
                    stack.pollLast();
                } else {
                    stack.add(c);
                }
                // 다르면 넣고
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}