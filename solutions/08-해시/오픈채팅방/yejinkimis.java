import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        for(String s : record) {
            String[] splitted = s.split(" ");
            if(splitted[0].equals("Enter") || splitted[0].equals("Change")) {
                users.put(splitted[1], splitted[2]);
            }
        }
        for(String s : record) {
            String[] splitted = s.split(" ");
            StringBuilder sb = new StringBuilder();
            String name = users.get(splitted[1]);
            sb.append(name);
            if(splitted[0].equals("Change")) {
                continue;
            }
            if(splitted[0].equals("Enter")) {
                sb.append("님이 들어왔습니다.");
            }
            if(splitted[0].equals("Leave")) {
                sb.append("님이 나갔습니다.");
            }
            answer.add(sb.toString());
        }
        return answer.stream().toArray(String[]::new);
    }
}
