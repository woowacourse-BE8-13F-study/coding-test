import java.util.*;

class Solution {

    static Map<String, Integer> course_map;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> answers = new ArrayList<>();
        for(int i = 0; i < orders.length; i++) {
            char[] tmp_order_arr = orders[i].toCharArray();
            Arrays.sort(tmp_order_arr);
            orders[i] = String.valueOf(tmp_order_arr);
        }

        for(int len : course) {
            course_map = new HashMap<>();
            int maxOrderCount = 0;

            for(String order : orders) {
                if(order.length() >= len) {
                    dfs(order, new StringBuilder(), 0, 0, len);
                }
            }

            for(String key : course_map.keySet()) {
                int count = course_map.get(key);
                if(count >= 2 && count > maxOrderCount) {
                    maxOrderCount = count;
                }
            }

            for(String key : course_map.keySet()) {
                int count = course_map.get(key);
                if(count == maxOrderCount) {
                    answers.add(key);
                }
            }
        }

        Collections.sort(answers);
        return answers.stream().toArray(String[]::new);
    }

    private void dfs(String order, StringBuilder sb, int depth, int start, int len) {
        if(depth == len) {
            course_map.put(sb.toString(), course_map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for(int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            dfs(order, sb, depth + 1, i + 1, len);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
