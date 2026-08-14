import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<String> word_set = new HashSet<>();
        int[] answer = {0, 0};

        word_set.add(words[0]);
        count.put(0, count.getOrDefault(0, 1) + 1);

        for (int i = 1; i < words.length; i++) {
            int turn = i % n;
            int prev_len = words[i - 1].length();
            if(word_set.contains(words[i]) || words[i-1].charAt(prev_len-1) != words[i].charAt(0)) {
                answer[0] = turn + 1;
                answer[1] = count.getOrDefault(turn, 1);
                return answer;
            }
            word_set.add(words[i]);
            count.put(turn, count.getOrDefault(turn, 1) + 1);
        }
        return answer;
    }
}
