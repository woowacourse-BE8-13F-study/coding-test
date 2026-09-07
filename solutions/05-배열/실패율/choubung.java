/*
체감상 레벨 1이 전혀 아니었음
실패율을 어떻게 구할 진 + 누적합을 쓰면 더 효율적이란 걸 알았는데
1) 0으로 나누는 예외 분기 처리 놓침
2) 정렬에서 세컨더리 규칙 적용하는 거 놓침
3) 누적합 구현 방법 파악 못함
주말에 다시 풀어봐야 할 듯 함

새롭게 알게 된 문법
- Map.Entry.<Integer, Double>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey())
 */

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] clear = new int[N+2];

        for (int stage : stages) {
            clear[stage] += 1;
        }

        // 나 / 나+끝까지
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            // System.out.println("스테이지 " + i + ", " + clear[i] + "<- 나");
            Double denominator = Double.valueOf(clear[i]);

            for (int j = i + 1; j < N + 2; j++) {
                denominator += Double.valueOf(clear[j]);
                // System.out.println("clear[j]: " + clear[j] + " 분모는 " + denominator);
            }

            // System.out.println("실패율: " + (clear[i] / denominator));
            Double answer =  clear[i] / denominator;
            if (denominator == 0.0) {
                answer = 0.0;
            }
            map.put(i,answer);
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Double>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()));

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}
