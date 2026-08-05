import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        //각 판매원이 득한 이익금을 나열한 배열을 return
        // 판매자의 부모 정보 맵
        Map<String, String> parent = new HashMap<>();
        // 판매자별 이익 맵
        Map<String, Integer> sellerProfit = new HashMap<>();

        for(int i=0; i<enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            sellerProfit.put(enroll[i], 0);
        }

        // seller 판매 정보 반복문 돌면서 하나씩 이익 분배하기
        for(int i=0; i<seller.length; i++) {

            String currentSeller = seller[i];
            int price = amount[i] * 100;

            while(!currentSeller.equals("-") && price >0) {

                // 90퍼센트 본인 이익에 추가
                int giveToParent = price / 10;
                int keep = price - giveToParent;

                sellerProfit.put(currentSeller, sellerProfit.get(currentSeller) + keep);

                if (giveToParent == 0) {
                    break;
                }

                price = giveToParent;
                currentSeller = parent.get(currentSeller);
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellerProfit.get(enroll[i]);
        }

        return answer;
    }
}