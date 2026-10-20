import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int n : d) {
            budget -= n;
            if (budget < 0) {
                return answer;
            }
            answer += 1;
        }
        return answer;
    }
}
