import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genres_map = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            genres_map.put(genres[i], genres_map.getOrDefault(genres[i], 0) + plays[i]);
        }
        for(int i = 0; i < genres.length; i++) {
            songs.putIfAbsent(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(new int[]{i, plays[i]});
        }

        List<String> genreList = new ArrayList<>(genres_map.keySet());
        genreList.sort((a, b) -> genres_map.get(b) - genres_map.get(a));

        List<Integer> answer = new ArrayList<>();
        for(String genre : genreList) {
            List<int[]> list = songs.get(genre);
            list.sort((a, b) -> {
                if(a[1] != b[1]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            });
            int i = 0;
            while(i < 2 && i < list.size()) {
                answer.add(list.get(i)[0]);
                i++;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
