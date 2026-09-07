import java.util.*;

class Process {

    int priority;
    boolean isTarget;

    public Process(int priority, boolean isTarget) {
        this.priority = priority;
        this.isTarget = isTarget;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isTarget() {
        return isTarget;
    }
}

class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Process> q = new LinkedList<>();

        for(int i=0; i <priorities.length; i++) {
            if(location == i) {
                q.offer(new Process(priorities[i], true));
            } else {
                q.offer(new Process(priorities[i], false));
            }
        }

        while(true) {
            Process p = q.poll();

            int max = q.stream()
                    .mapToInt(process -> process.getPriority())
                    .max()
                    .orElse(p.getPriority());

            // 더 큰게 있으면 다시 넣기
            if(p.getPriority() < max) {
                q.offer(p);
            }else {
                // 없으면 자원 실행 후 다음 순회
                // 그게 target이라면 종료 return
                answer++;

                if(p.isTarget()) {
                    return answer;
                }
            }
        }

    }
}