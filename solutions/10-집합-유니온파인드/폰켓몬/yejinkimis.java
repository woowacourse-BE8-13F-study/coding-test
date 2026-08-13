import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length / 2;
        Map<Integer, Integer> count = new HashMap<>();

        for(int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        answer = count.keySet().size() < num ? count.keySet().size() : num;

        return answer;
    }
}
