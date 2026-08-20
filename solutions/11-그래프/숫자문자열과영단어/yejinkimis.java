import java.util.*;

class Solution {
    public int solution(String s) {

        Map<String, Integer> table = new HashMap<>();
        table.put("zero", 0);
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);
        table.put("four", 4);
        table.put("five", 5);
        table.put("six", 6);
        table.put("seven", 7);
        table.put("eight", 8);
        table.put("nine", 9);

        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                answer = answer * 10 + (c - '0');
                continue;
            }

            sb.append(c);

            Integer number = table.get(sb.toString());
            if(number != null) {
                answer = answer * 10 + number;
                sb.setLength(0);
            }
        }
        return answer;
    }
}
