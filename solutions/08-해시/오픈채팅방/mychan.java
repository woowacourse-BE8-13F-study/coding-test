import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 채팅방 들어오고 나가거나, 닉네임 변경 기록이 담긴 문자열 배열 record
        // 모든 기록이 처리된 후, 최종적으로 보게되는 메시지를 문자열 배열로 return


        // 유저의 Map (uid, 이름)
        HashMap<String, String> user = new HashMap<>();
        // 유저의 입퇴장 기록 List (uid, 들어왔습니다./나갔습니다.)
        List<String[]> action = new ArrayList<>();

        for(String r : record) {
            StringTokenizer st = new StringTokenizer(r, " ");

            String command = st.nextToken();
            String uid = st.nextToken();

            if(command.equals("Enter")) {
                String name = st.nextToken();
                user.put(uid, name);
                action.add(new String[]{uid, "들어왔습니다."});

            } else if(command.equals("Leave")) {
                action.add(new String[]{uid, "나갔습니다."});
            } else if(command.equals("Change")) {
                String name = st.nextToken();
                user.put(uid, name);
            }
        }

        String[] answer = new String[action.size()];
        for (int i = 0; i < action.size(); i++) {
            String uid = action.get(i)[0];
            String a = action.get(i)[1];

            String nickname = user.get(uid);
            answer[i] = nickname+"님이 "+ a;
        }

        return answer;
    }
}