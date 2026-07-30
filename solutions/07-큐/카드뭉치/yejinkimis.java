import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1_q = toQueue(cards1);
        Queue<String> cards2_q = toQueue(cards2);

        for(String s : goal) {
            if(!cards1_q.isEmpty() && s.equals(cards1_q.peek())) {
                cards1_q.poll();
            } else if(!cards2_q.isEmpty() && s.equals(cards2_q.peek())) {
                cards2_q.poll();
            } else{
                return "No";
            }
        }
        return "Yes";
    }

    private Queue<String> toQueue(String[] cards) {
        Queue<String> queue = new ArrayDeque<>();
        for(String s : cards) {
            queue.offer(s);
        }
        return queue;
    }
}
