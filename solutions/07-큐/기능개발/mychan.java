import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        // 작업의 진도 배열 progresses
        // 작업의 개발 속도 배열 speeds

        // 각 배포마다 몇 개의 기능이 배포되는지 return

        int size = progresses.length;
        int[] days = new int[size];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<size; i++) {

            int current = progresses[i];
            int speed = speeds[i];

            q.offer((int)Math.ceil((double)(100 - current) / speed));
        }

        int max=q.poll();
        int count=1;

        while(!q.isEmpty()) {

            int current = q.poll();

            // 현재 날짜가 최대 일수보다 작으면 count++
            if(current <= max) count++;
            else {
                // 현재 날짜가 최대 일수보다 크면
                // 정답에 count 추가
                // count=1로 하고
                // max= current
                answer.add(count);
                count=1;
                max=current;
            }
        }
        answer.add(count);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}