/*
이게 최선이 아니란 걸 알지만,, 규칙을 찾는 게 너무 귀찮다.
그래도 문법 안 찾고 스스로의 힘으로 풀었음.
 */

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        int[] pattern2 = new int[]{2,1,2,3,2,4,2,5};
        int[] pattern3 = new int[]{3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == i % 5 + 1) scores[0]++;
            if (answers[i] == pattern2[i % pattern2.length]) scores[1]++;
            if (answers[i] == pattern3[i % pattern3.length]) scores[2]++;
        }

        int max = 0;
        for (int score : scores) {
            max = Math.max(max, score);
        }

        Set<Integer> winner = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) {
                winner.add(i+1);
            }
        }

        int[] answer = winner.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(answer);
        return answer;
    }
}
