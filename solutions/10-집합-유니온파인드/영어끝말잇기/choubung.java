import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();

        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String pre = list.get(i - 1);
            String word = words[i];

            if (pre.charAt(pre.length() - 1) != word.charAt(0) || list.contains(word)) {
                answer[0] = (i + 1) % n;
                if (answer[0] == 0) answer[0] = n;
                answer[1] = i / n + 1;
                return answer;
            }

            list.add(word);
        }

        return new int[]{0, 0};
    }
}
