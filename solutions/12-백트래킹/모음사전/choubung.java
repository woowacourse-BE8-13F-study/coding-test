/*
indexOf 메서드 사용
굳이 정렬할 필요 없음
방문처리 할 필요 없음
 */

import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    String[] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        dfs("");

        return dictionary.indexOf(word);
    }

    public void dfs(String word) {
        dictionary.add(word);

        if (word.length() == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(word + words[i]);
        }
    }
}
