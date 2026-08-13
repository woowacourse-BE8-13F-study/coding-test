import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length / 2;
        Set<Integer> count = new HashSet<>();
        for(int i : nums) {
            count.add(i);
        }

        answer = count.size() < num ? count.size() : num;

        return answer;
    }
}
