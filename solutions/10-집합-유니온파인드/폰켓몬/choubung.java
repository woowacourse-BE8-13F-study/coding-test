import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        int answer = n / 2;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        answer = Math.min(answer, set.size());

        return answer;
    }
}
