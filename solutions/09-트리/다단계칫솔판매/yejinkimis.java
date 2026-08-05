import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> enroll_map = new HashMap<>();
        Map<String, String> referral_map = new HashMap<>();
        for(String s : enroll) {
            enroll_map.put(s, 0);
        }

        for(int i = 0; i < enroll.length; i++) {
            referral_map.put(enroll[i], referral[i]);
        }

        for(int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int profit = amount[i] * 100;

            while(!currentSeller.equals("-")) {
                int tax = profit / 10;
                int mine = profit - tax;

                enroll_map.put(currentSeller, enroll_map.get(currentSeller) + mine);

                if(tax < 1) {
                    break;
                }

                profit = tax;
                currentSeller = referral_map.get(currentSeller);
            }
        }

        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = enroll_map.get(enroll[i]);
        }
        return answer;
    }
}
