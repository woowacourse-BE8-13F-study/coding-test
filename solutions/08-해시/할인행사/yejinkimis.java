import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map_want = new HashMap<>();

        for(int i = 0; i < want.length; i++) {
            map_want.put(want[i], number[i]);
        }

        for(int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> map_discount = new HashMap<>();
            boolean ok = true;

            for(int j = 0; j < 10; j++) {
                map_discount.put(discount[i + j], map_discount.getOrDefault(discount[i + j], 0) + 1);
            }
            for(Map.Entry<String, Integer> entry : map_want.entrySet()) {
                if(map_discount.getOrDefault(entry.getKey(), 0) != entry.getValue()) {
                    ok = false;
                    break;
                }
            }
            if(ok) answer += 1;
        }



        return answer;
    }
}
