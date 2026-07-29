import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            int deployDay = getDeployableDay(progresses[i], speeds[i]);
            queue.offer(deployDay);
        }

        while(!queue.isEmpty()) {
            int dayCount = 1;
            int d = queue.poll();
            while(!queue.isEmpty() && queue.peek() <= d) {
                dayCount += 1;
                queue.poll();
            }
            answer.add(dayCount);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getDeployableDay(int progress, int speed) {
        return (100 - progress + speed - 1) / speed;
    }
}
