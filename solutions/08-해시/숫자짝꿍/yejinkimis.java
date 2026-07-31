import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> numbers_x = new HashMap<>();
        Map<Character, Integer> numbers_y = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            numbers_x.put(c, numbers_x.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            numbers_y.put(c, numbers_y.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(char n = '9'; n >= '0'; n--) {
            int count_x = numbers_x.getOrDefault(n, 0);
            int count_y = numbers_y.getOrDefault(n, 0);
            int min = Math.min(count_x, count_y);

            for(int i = 0; i < min; i++) {
                sb.append(n);
            }
        }

        if(sb.length() == 0) return "-1";
        if(sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
