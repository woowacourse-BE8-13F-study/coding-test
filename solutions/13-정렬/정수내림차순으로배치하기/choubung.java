import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] strList = String.valueOf(n).split("");
        Arrays.sort(strList, Comparator.reverseOrder());
        answer = Long.valueOf(String.join("", strList));

        return answer;
    }
}
