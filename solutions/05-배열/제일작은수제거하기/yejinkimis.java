import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        int min = Arrays.stream(arr)
                .min()
                .getAsInt();

        return Arrays.stream(arr)
                .filter(n -> n != min)
                .toArray();
    }
}
