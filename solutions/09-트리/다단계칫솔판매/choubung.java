/*
다시 풀어야 할 듯...
 */

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> personMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++){
            personMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            String current = seller[i];

            while (!current.equals("-") && money > 0) {
                int give = money / 10;
                int keep = money - give;

                profitMap.put(current, profitMap.get(current) + keep);

                current = personMap.get(current);
                money = give;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (String name : enroll) {
            result.add(profitMap.get(name));
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
