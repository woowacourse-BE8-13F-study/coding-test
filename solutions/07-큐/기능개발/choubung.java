/*
동시 출력하는 그룹의 첫 번째 원소를 가지고 비교를 했어야 했는데,
전체적으로 나아가면서 상승세(배포가 끊기는 시점)을 체크해서 논리적 오류가 발생했다.
이런 식으로 조금 삐끗해서 틀렸을 때 진짜 허무한 것 같다...
 */

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> cnts = new ArrayDeque<>();
        int len = progresses.length;

        for (int i = 0; i < len; i++) {
            int rest = 100 - progresses[i];

            int mod = rest % speeds[i];
            int cnt = rest / speeds[i];

            if (mod != 0) {
                cnt++;
            }

            cnts.offer(cnt);
        }

        // System.out.println(cnts);

        int task = 1;
        List<Integer> answer = new ArrayList<>();
        int maxProgress = cnts.poll();

        while (!cnts.isEmpty()) {
            int currentProgress = cnts.poll();

            if (maxProgress < currentProgress) {
                maxProgress = currentProgress;
                answer.add(task);
                task = 1;
                continue;
            }

            task++;
        }

        if (task != 0) {
            answer.add(task);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
