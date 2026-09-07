/*
처음에 프로세스 클래스를 만들어서 그 자체를 큐에 넣을 생각을 못 했다. 그래서 location을 어떻게 추적해야하나 했다...
카운팅 배열 방식도 생각했는데, 그냥 정렬 리스트를 만드는 게 공수가 좀 덜 드는 것 같다.
이것도 참고를 좀 했기 때문에 다시 풀어봐야겠다...
 */

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        Deque<Process> queue = new ArrayDeque<>();
        List<Integer> sortedPriorities = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
            sortedPriorities.add(priorities[i]);
        }

        sortedPriorities.sort((p1, p2) -> p2 - p1);

        while (true) {
            Process process = queue.poll();

            if (process.priority == sortedPriorities.get(0)) {
                if (process.index == location) {
                    break;
                }

                sortedPriorities.remove(0);
                answer++;
            }

            queue.offer(process);
        }

        return answer;
    }

    class Process {
        int index;
        int priority;

        public Process (int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
