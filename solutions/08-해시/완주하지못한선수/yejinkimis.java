import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map_participant = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            String s = participant[i];
            map_participant.put(s, map_participant.getOrDefault(s, 0) + 1);
        }
        for(int i = 0; i < completion.length; i++) {
            String s = completion[i];
            map_participant.put(s, map_participant.get(s) - 1);
        }

        for(String s : map_participant.keySet()) {
            if (map_participant.get(s) > 0) {
                return s;
            }
        }

        return answer;
    }
}
