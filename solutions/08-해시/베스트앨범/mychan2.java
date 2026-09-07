import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범 출시
        // 노래 - 고유번호 식별자

        // 1. 노래가 많이 재생된 장르 우선순위
        // 2. 장르 내에서 많이 재생된 노래 우선순위
        // 3. 장르 내, 재생횟수 같으면 고유번호가 낮은 노래 우선순위

        // 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return


        // 장르별 재생횟수 맵 생성
        HashMap<String, Integer> genrePlayMap = new HashMap<>();

        // 장르별 노래 재생횟수로 내림차순 정렬된 리스트 맵 생성
        HashMap<String, ArrayList<Music>> genreMusicMap = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);

            // 만약 장르별 음악 리스트 맵에 포함되어 있지 않으면 리스트 생성
            if(!genreMusicMap.containsKey(genres[i])) {
                genreMusicMap.put(genres[i], new ArrayList<>());
            }
            genreMusicMap.get(genres[i]).add(new Music(i, genres[i], plays[i]));
        }

        // 장르별 재생횟수 내림차순으로 정렬된 리스트
        List<String> sortedGenres = new ArrayList<>(genrePlayMap.keySet());
        sortedGenres.sort((g1, g2) -> Integer.compare(genrePlayMap.get(g2), genrePlayMap.get(g1)));

        List<Integer> answer = new ArrayList<>();

        for(String genre : sortedGenres) {

            List<Music> musices = genreMusicMap.get(genre).stream()
                    .sorted()
                    .toList();

            // 장르별 최대 2개 정답 리스트에 추가
            for(int i=0; i< Math.min(musices.size(), 2); i++) {
                answer.add(musices.get(i).id);
            }

        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    class Music implements Comparable<Music> {

        int id;
        String genre;
        int playCount;

        public Music(int id, String genre, int playCount) {
            this.id = id;
            this.genre = genre;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Music other) {
            // 재생 횟수가 같으면 식별자 작은거부터
            if(this.playCount == other.playCount) {
                return Integer.compare(this.id, other.id);
            }
            return Integer.compare(other.playCount, this.playCount);
        }
    }
}