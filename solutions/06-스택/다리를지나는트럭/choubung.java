/*
시뮬레이션으로 해결하면 되는데 공식처럼 계산을 해야한다고 생각해서 풀이를 돌아감
차가 나가는 순간 새로운 게 들어올 수 있는데, 그를 감안해서 계산하지 않음
- poll() : 맨 앞 제거
- peek() : 맨 앞 값 조회
 */

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int sum = 0;
        for (int truck_weight : truck_weights) {
            while(sum - bridge.peek() + truck_weight > weight){
                sum -= bridge.poll();
                bridge.offer(0);
                answer++;
            }

            sum = sum - bridge.poll() + truck_weight;
            bridge.offer(truck_weight);
            answer++;
        }

        while(sum > 0) {
            sum -= bridge.poll();
            bridge.offer(0);
            answer++;
        }

        return answer;
    }
}
