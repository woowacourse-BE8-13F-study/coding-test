import java.util.*;
class Solution {
    public long solution(long n) {

        String[] array = String.valueOf(n).split("");

        Arrays.sort(array, (a1, a2) -> a2.compareTo(a1));

        String result = String.join("", array);
        return Long.parseLong(result);
    }
}