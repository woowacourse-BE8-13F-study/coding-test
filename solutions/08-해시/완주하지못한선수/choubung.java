import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        Map<String, Integer> completionMap = new HashMap<>();

        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            completionMap.put(c, completionMap.getOrDefault(c, 0) + 1);
        }

        for (String name : participantMap.keySet()) {
            if (!participantMap.get(name).equals(completionMap.get(name))) {
                return name;
            }
        }

        return "";
    }
}
