import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";

        Deque<String> cardsQueue1 = new ArrayDeque<>();
        for (String card : cards1) {
            cardsQueue1.offer(card);
        }

        Deque<String> cardsQueue2 = new ArrayDeque<>();
        for (String card : cards2) {
            cardsQueue2.offer(card);
        }

        Deque<String> goalQueue = new ArrayDeque<>();
        for (String g : goal) {
            goalQueue.offer(g);
        }

        while(!goalQueue.isEmpty()) {
            if (!(goalQueue.peek().equals(cardsQueue1.peek()) || goalQueue.peek().equals(cardsQueue2.peek()))) {
                break;
            }

            // 아래를 삼항연산자로 바꾸는 게 나은지?
            String word = goalQueue.poll();
            if (word.equals(cardsQueue1.peek())) {
                cardsQueue1.poll();
            } else {
                cardsQueue2.poll();
            }
        }

        if (goalQueue.isEmpty()) {
            answer = "Yes";
        }

        return answer;
    }
}
