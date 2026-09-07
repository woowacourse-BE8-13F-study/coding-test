import java.util.HashMap;
import java.util.Map;

class Solution {
    // 성격유형 4개 지표로 구분
    // n개 질문, 7개 선택지
    // mbti 검사처럼 점수를 계산하여 유형을 판단

    // 질문마다 판단하는 지표를 담은 배열 servey
    // 검사자가 각 질문마다 선택한 선택지를 담은 배열 choices
    // 이때 검사자의 성격유형 검사 결과 지표 번호 순서대로 return

    // 지표 번호	성격 유형
    // 1번 지표	라이언형(R), 튜브형(T)
    // 2번 지표	콘형(C), 프로도형(F)
    // 3번 지표	제이지형(J), 무지형(M)
    // 4번 지표	어피치형(A), 네오형(N)

    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();
        for (char c : "RTCFJMAN".toCharArray()) {
            scores.put(c, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char disagreeType = survey[i].charAt(0); // 비동의 관련
            char agreeType = survey[i].charAt(1);    // 동의 관련
            int choice = choices[i];

            if (choice < 4) {
                // 비동의 쪽: 4에서 멀수록 점수 큼 (1->3, 2->2, 3->1)
                scores.put(disagreeType, scores.get(disagreeType) + (4 - choice));
            } else if (choice > 4) {
                // 동의 쪽: (5->1, 6->2, 7->3)
                scores.put(agreeType, scores.get(agreeType) + (choice - 4));
            }
            // choice == 4 (모르겠음): 점수 없음
        }

        // 4개 지표를 순서대로 판단
        String[] indicators = {"RT", "CF", "JM", "AN"};
        StringBuilder result = new StringBuilder();

        for (String indicator : indicators) {
            char first = indicator.charAt(0);
            char second = indicator.charAt(1);

            if (scores.get(first) > scores.get(second)) {
                result.append(first);
            } else if (scores.get(first) < scores.get(second)) {
                result.append(second);
            } else {
                // 같으면 사전순으로 빠른 것
                result.append(first < second ? first : second);
            }
        }

        return result.toString();
    }
}
