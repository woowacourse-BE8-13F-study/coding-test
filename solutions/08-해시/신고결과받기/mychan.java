import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 게시판 불량 이용자 신고 -> 처리 결과 메일 발송 시스템
        // 각 유저는 한번에 한명의 유저만 신고 가능

        // k번 이상 신고 유저 -> 정리
        // 신고한 유저에게 정지 사실 메일로 발송

        // 유저별 신고 리스트 맵에 저장
        Map<String, List<String>> userReport = new HashMap<>();

        // 유저별 신고 당한 횟수
        Map<String, Integer> userReportedCountMap = new HashMap<>();

        // 정지된 유저 리스트
        List<String> stopUser = new ArrayList<>();

        for(String id : id_list) {
            userReport.put(id, new ArrayList<>());
        }

        for(String r : report) {
            String a = r.split(" ")[0];
            String b = r.split(" ")[1];

            if(userReport.get(a).contains(b)) continue;

            userReport.get(a).add(b);
            userReportedCountMap.put(b, userReportedCountMap.getOrDefault(b,0)+1);
            if(userReportedCountMap.get(b) == k) {
                stopUser.add(b);
            }
        }

        int[] answer = new int[id_list.length];

        // 유저별 신고 리스트 맵을 순회하면서 정지된 유저 리스트에 몇명 있는지 보고 결과 배열에 추가
        for(int i=0; i<id_list.length; i++) {
            String user = id_list[i];

            List<String> reports = userReport.get(user);

            int result = (int)reports.stream()
                    .filter(a -> stopUser.contains(a))
                    .count();

            answer[i] = result;
        }

        return answer;
    }
}