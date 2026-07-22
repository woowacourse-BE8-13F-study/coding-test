import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 1개 이하이면 -1 채워서 리턴
        if(arr.length <= 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();

        // 아니면 제일 작은거 제거하고 리턴
        return Arrays.stream(arr)
                .filter(value -> value != min)
                .toArray();
    }
}