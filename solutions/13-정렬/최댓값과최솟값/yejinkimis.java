import java.util.*;

class Solution {
    public String solution(String s) {

        String[] arr = s.split(" ");
        int[] arr_num = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            arr_num[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(arr_num);

        String answer = "";
        answer += arr_num[0] + " ";
        answer += arr_num[arr.length - 1];

        return answer;
    }
}
