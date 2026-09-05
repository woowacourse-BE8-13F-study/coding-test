/*
오늘 마지막으로 푼 탓에 길게 생각하기가 싫어서 그냥 이중 for문으로 풀었다..
카운팅 방식으로 해야한 단 걸 머리로는 알았는데 구현 방식이 명확히 안 떠올랐다.
주말에 다시 풀어봐야겠다...
 */

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int time = 0;
            for (int j = i + 1; j < prices.length; j++) {
                time++;

                if (prices[i] > prices[j]) {
                    break;
                }
            }

            answer[i] = time;
        }

        return answer;
    }
}
