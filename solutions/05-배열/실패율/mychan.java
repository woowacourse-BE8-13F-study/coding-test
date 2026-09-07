import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        Map<Integer, Double> failRatio = new HashMap<>();

        // N은 전체 스테이지 수
        // 사용자가 현재 멈춰있는 스테이지 번호가 담긴 배열 stagres

        // 실패율 = 아직 거기 멈춰있는 사람 수 / 도달한 사람 수

        for(int i=1; i<=N; i++) {

            // 각 스테이지 별 실패율 계산 후 배열에 저장
            // 도달 사람 수
            int finalI = i;
            int reach = (int)Arrays.stream(stages)
                    .filter(value -> value >= finalI)
                    .count();

            // 도달한 사람이 없으면 0.0
            if (reach == 0) {
                failRatio.put(i, 0.0);
                continue;
            }

            int stop = (int)Arrays.stream(stages)
                    .filter(value -> value == finalI)
                    .count();

            failRatio.put(i, (double) stop / (double) reach);
        }

        // 실패율이 높은 스테이지부터 내림차순으로
        // 스테이지의 번호가 담겨있는 배열을 return
        return failRatio.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}