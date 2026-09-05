/*
처음에 문제 이해를 못 해서 애먹음...
 */

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        for (char type : types) {
            scoreMap.put(type, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];

            if (choice < 4) {
                char type = survey[i].charAt(0);
                scoreMap.put(type, scoreMap.get(type) + (4 - choice));
            } else if (choice > 4) {
                char type = survey[i].charAt(1);
                scoreMap.put(type, scoreMap.get(type) + (choice - 4));
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        sb.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        sb.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        sb.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');

        return sb.toString();
    }
}
