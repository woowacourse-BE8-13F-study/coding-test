/*
처음에는 둘 다 set을 써야 하나 했는데, 그렇게 하면 개수를 카운트해서 반영할 수가 없었다.
이중for문을 쓰지 않고 하는 게 관건이었다.
 */

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            map.put(t, map.get(t) - 1);

            if (map.get(t) == 0) {
                map.remove(t);
            }

            set.add(t);

            if (map.size() == set.size()) {
                answer++;
            }
        }

        return answer;
    }
}
