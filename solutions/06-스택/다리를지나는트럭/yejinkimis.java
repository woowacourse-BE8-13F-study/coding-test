import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();

        for(int i = 0; i < bridge_length; i++) {
            bridge.offerLast(0);
        }

        int truck_idx = 0;
        int time = 0;
        int bridge_weight = 0;

        while(truck_idx < truck_weights.length) {
            time+=1;

            bridge_weight -= bridge.pollFirst();

            int next_truck = truck_weights[truck_idx];

            if(bridge_weight + next_truck <= weight) {
                truck_idx+=1;
                bridge.offerLast(next_truck);
                bridge_weight += next_truck;
            } else {
                bridge.offerLast(0);
            }
        }

        while(bridge_weight > 0) {
            time += 1;
            bridge_weight -= bridge.pollFirst();
        }

        return time;
    }
}
