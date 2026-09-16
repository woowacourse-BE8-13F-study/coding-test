import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int n : numbers) {
            list.add(String.valueOf(n));
        }

        Collections.sort(list, (o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });

        if (list.get(0).equals("0")) {
            return "0";
        }

        return String.join("", list);
    }
}
