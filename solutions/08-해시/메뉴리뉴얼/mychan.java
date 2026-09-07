import java.util.*;

class Solution {
    // 각 코스 개수별 조합과 빈도수를 저장할 맵
    static HashMap<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        // 각 코스 요리의 개수(c)별로 탐색
        for (int c : course) {
            map = new HashMap<>();
            int maxFreq = 0;

            // 각 손님의 주문 내역 분석
            for (String order : orders) {
                // 주문 내역을 알파벳 순으로 정렬
                char[] chars = order.toCharArray();
                Arrays.sort(chars);

                // 조합 생성 시작 (백트래킹)
                if (chars.length >= c) {
                    makeCombinations(chars, 0, c, new StringBuilder());
                }
            }

            // 현재 코스 개수(c)에서 가장 많이 주문된 횟수 찾기
            for (int freq : map.values()) {
                maxFreq = Math.max(maxFreq, freq);
            }

            // 최소 2명 이상 주문했고, 가장 많이 주문된 조합을 정답 리스트에 추가
            if (maxFreq >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == maxFreq) {
                        answerList.add(key);
                    }
                }
            }
        }

        // 전체 결과를 사전 순(오름차순)으로 정렬
        Collections.sort(answerList);

        // List를 String[] 배열로 변환하여 반환
        return answerList.toArray(new String[0]);
    }

    // 조합 구하는 백트래킹
    private void makeCombinations(char[] chars, int start, int length, StringBuilder sb) {
        // 원하는 길이의 조합이 완성된 경우
        if (sb.length() == length) {
            String comb = sb.toString();
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }

        // 백트래킹 탐색
        for (int i = start; i < chars.length; i++) {
            sb.append(chars[i]);
            makeCombinations(chars, i + 1, length, sb);
            sb.deleteCharAt(sb.length() - 1); // 재귀 탈출 후 마지막 문자 제거
        }
    }
}
