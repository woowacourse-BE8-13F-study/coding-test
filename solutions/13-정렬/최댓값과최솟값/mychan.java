import java.util.*;

class Solution {
    public String solution(String s) {

        int[] numbers = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = Arrays.stream(numbers).max().getAsInt();
        int min = Arrays.stream(numbers).min().getAsInt();

        return min + " " + max;
    }
}