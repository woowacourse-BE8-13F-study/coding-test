import java.util.*;

class Solution {
    public int solution(int[] nums) {

        int returnSize = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int n:nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int mapSize = map.size();

        if(mapSize >= returnSize) {
            return returnSize;
        } else {
            return mapSize;
        }
    }
}