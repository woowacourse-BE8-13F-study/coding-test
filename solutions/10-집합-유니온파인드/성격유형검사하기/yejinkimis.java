import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        String types = "RTCFJMAN";
        String[] matches = {"RT", "CF", "JM", "AN"};
        Map<Character, Integer> counted = new HashMap<>();

        for(char c : types.toCharArray()) {
            counted.put(c, 0);
        }

        for(int i = 0; i < survey.length; i++) {
            char negative = survey[i].charAt(0);
            char positive = survey[i].charAt(1);
            if(choices[i] > 4) {
                int score = choices[i] - 4;
                counted.put(positive, counted.get(positive) + score);
            }
            if(choices[i] < 4) {
                int score = 4 - choices[i];
                counted.put(negative, counted.get(negative) + score);
            }
        }

        for(String s : matches) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            char first = arr[0];
            int first_count = counted.get(first);
            char second = arr[1];
            int second_count = counted.get(second);
            if (second_count > first_count) {
                sb.append(second);
            } else {
                sb.append(first);
            }
        }
        return sb.toString();
    }
}
