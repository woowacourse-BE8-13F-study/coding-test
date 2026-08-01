import java.util.*;


class Solution {
    static class Music implements Comparable<Music> {
        int id;
        int play;
        String genre;

        public Music(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }

        @Override
        public int compareTo(Music other) {
            if (this.play == other.play) {
                return Integer.compare(this.id, other.id);
            }
            return Integer.compare(other.play, this.play);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 재생 횟수
        Map<String, Integer> genrePlayMap = new HashMap<>();
        // 장르별 음악 리스트 맵
        Map<String, ArrayList<Music>> genreMusicMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);

            if (!genreMusicMap.containsKey(genres[i])) {
                genreMusicMap.put(genres[i], new ArrayList<>());
            }
            genreMusicMap.get(genres[i]).add(new Music(i, plays[i], genres[i]));
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayMap.keySet());
        sortedGenres.sort((g1, g2) -> Integer.compare(genrePlayMap.get(g2), genrePlayMap.get(g1)));

        List<Integer> answerList = new ArrayList<>();

        for (String genre : sortedGenres) {
            ArrayList<Music> musicList = genreMusicMap.get(genre);
            Collections.sort(musicList);

            for (int i = 0; i < Math.min(musicList.size(), 2); i++) {
                answerList.add(musicList.get(i).id);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}