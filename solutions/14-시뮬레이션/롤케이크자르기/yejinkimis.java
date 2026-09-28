import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> a_map = new HashMap<>();
        Map<Integer, Integer> b_map = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            b_map.put(topping[i], b_map.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length -1 ; i++) {
            int n = topping[i];
            a_map.put(n, a_map.getOrDefault(n, 0) + 1);
            b_map.put(n, b_map.get(n) - 1);
            if (b_map.get(n) == 0) {
                b_map.remove(n);
            }
            if (a_map.size() == b_map.size()) {
                answer += 1;
            }
        }

        return answer;
    }
}
