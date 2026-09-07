/*
java 값 참조 규칙에 대해 조금 더 생각해봐야할 듯(언제 값 참조고, 언제 주소 참조인지)
 */

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedUser = new HashMap<>();

        for (String id : id_list) {
            reportedUser.put(id, new HashSet<>());
        }

        for (String users : report) {
            String[] userArr = users.split(" ");

            reportedUser.get(userArr[1]).add(userArr[0]);
        }

        Map<String, Integer> reportedCount = new HashMap<>();
        for (String id : id_list) {
            reportedCount.put(id, 0);
        }

        for (String key : reportedUser.keySet()) {
            if (reportedUser.get(key).size() >= k) {
                for (String byUser : reportedUser.get(key)) {
                    reportedCount.put(byUser, reportedCount.get(byUser) + 1);
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (String id : id_list) {
            list.add(reportedCount.get(id));
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
