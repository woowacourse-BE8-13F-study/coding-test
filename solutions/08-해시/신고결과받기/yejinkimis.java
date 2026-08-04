import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> report_set = new HashSet<>(Arrays.asList(report));
        Map<String, Set<String>> report_record = new HashMap();
        Map<String, Integer> reported_map = new HashMap();
        for(String s : report_set) {
            String[] users = s.split(" ");
            String reporter = users[0];
            String target = users[1];
            report_record.computeIfAbsent(reporter, hs -> new HashSet<>()).add(target);
            reported_map.put(target, reported_map.getOrDefault(target, 0) + 1);
        }

        for(int i = 0; i < id_list.length; i++) {
            Set<String> reported_record_set = report_record.get(id_list[i]);
            if (reported_record_set == null) continue;
            for(String target : reported_record_set) {
                if(reported_map.get(target) >= k) {
                    answer[i] += 1;
                }
            }
        }

        return answer;
    }
}
