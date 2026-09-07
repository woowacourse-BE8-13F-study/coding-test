/*
List<String[]> result 말고 더 좋은 방법이 있는지...?
Queue를 쓰면 for문 대신 while문을 쓰면서 더 간결해질 것 같긴 하다.
 */

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String[]> result = new ArrayList<>();

        Map<String, String> idAndNickMap = new HashMap<>();
        for (String message : record) {
            String[] messages = message.split(" ");

            if (messages[0].equals("Enter")) {
                idAndNickMap.put(messages[1], messages[2]);
                result.add(new String[]{messages[1], "님이 들어왔습니다."});
            } else if (messages[0].equals("Leave")) {
                result.add(new String[]{messages[1], "님이 나갔습니다."});
            } else {
                idAndNickMap.put(messages[1], messages[2]);
            }
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String id = result.get(i)[0];

            answer[i] = sb.append(idAndNickMap.get(id))
                    .append(result.get(i)[1]).toString();
        }
        return answer;
    }
}
