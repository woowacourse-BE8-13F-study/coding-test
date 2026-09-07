/*
정렬할 때 람다식 안 쓰고 다른 메서드 썼더니 타입 캐스팅에서 문제 생김
장르마다 2곡씩 수록인 걸 놓침
주말에 무조건 다시 풀면서 복기해보기...
 */

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        // 장르별 총 회수
        Map<String, Integer> genreCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 총 회수 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedGenre = new ArrayList<>(genreCount.entrySet());
        sortedGenre.sort((e1, e2) -> e2.getValue() - e1.getValue());

        // 장르 순서대로 노래 수록
        for (Map.Entry<String, Integer> entry : sortedGenre) {
            String genre = entry.getKey();

            Map<Integer, Integer> numAndPlays = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    numAndPlays.put(i, plays[i]);
                }
            }

            List<Map.Entry<Integer, Integer>> played = new ArrayList<>(numAndPlays.entrySet());

            played.sort((e1, e2) -> {
                if (e1.getValue().equals(e2.getValue())) {
                    return e1.getKey() - e2.getKey(); // 인덱스 오름차순
                }
                return e2.getValue() - e1.getValue(); // 재생횟수 내림차순
            });

            int count = 0;
            for (Map.Entry<Integer, Integer> song : played) {
                answer.add(song.getKey());
                count++;
                if (count == 2) break;
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
