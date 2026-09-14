import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        List<Long> arr = new ArrayList<>();
        while(n > 0) {
            arr.add(n % 10);
            n /= 10;
        }
        arr.sort(Comparator.reverseOrder());
        for(long l : arr) {
            answer *= 10;
            answer += l;
        }
        return answer;
    }
}
