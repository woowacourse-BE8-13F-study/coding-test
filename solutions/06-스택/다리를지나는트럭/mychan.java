import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지
        // 다리는 최대 bridge_length 개 트럭만 올라갈 수 있음
        // bridge_length 1초의 1길이 만큼만 갈 수 있음
        // 다리는 weight까지 무게만 견딜 수 있음

        // 대기 트럭 스택 초기화
        Deque<Integer> stack = new ArrayDeque<>();
        for(int truck : truck_weights) {
            stack.add(truck);
        }
        // 다리 상태 큐 초기화
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0; // 현재 시간 변수
        int sum = 0;  // 현재 다리의 총 트럭 무게

        while(true) {
            // 대기 중인 트럭 없고, 다리 위에 무게 0이면 종료
            if(stack.isEmpty() && sum == 0) break;

            // 다리 마지막에서 꺼내고 현재 다리 무게에서 빼기
            sum -= bridge.poll();

            // 대기 중인 트럭이 있다면,
            if(!stack.isEmpty()) {

                int truck = stack.peekLast();

                // 현재 다리의 총 무게 + 그 트럭의 무게 <= weight
                if(sum + truck <= weight) {
                    // 조건 만족하면 대기 스택에서 꺼내서 큐에 트럭 넣기
                    bridge.add(stack.pollLast());
                    sum += truck;
                } else {
                    // 조건 만족 안하면 add(0) 넣기
                    bridge.add(0);
                }
            }
            // 시간 1 증가
            time++;
        }
        return time;
    }
}