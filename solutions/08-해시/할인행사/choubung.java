/*
가입 가능일 카운트를 할 떄, 처음엔 map을 계속해서 재사용하려고 했으나, 0개인 품목 발생시 문제가 생긴다...
공간이 비효율적일 거라고 생각해서 새로 만드는 방식을 생각 못 했는데,
이런 경우에는 감수해야 하는 것 같다...
 */

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        if (discount.length < 10) {
            return 0;
        }

        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 10 + 1; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            for(int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            if (discountMap.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }
}
