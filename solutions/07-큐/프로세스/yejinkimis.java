import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] { i, priorities[i] });
        }

        while (true) {
            int[] cur = queue.poll();
            int idx = cur[0];
            int k = cur[1];

            if (notPriority(k, queue)) {
                answer+=1;
                if (idx == location) {
                    return answer;
                }
            } else {
                queue.offer(cur);
            }
        }
    }

    private boolean notPriority(int k, Queue<int[]> queue) {
        for (int[] q : queue) {
            if (q[1] > k) {
                return false;
            }
        }
        return true;
    }
}
