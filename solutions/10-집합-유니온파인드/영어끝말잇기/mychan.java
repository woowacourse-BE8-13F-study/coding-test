import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int[] count = new int[n+1];

        Character pc;
        HashSet<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        count[1]++;
        pc = words[0].charAt(words[0].length()-1);
        
        for(int i=1; i<words.length; i++) {
            int current = (i%n)+1;
            count[current]++;

            String curr = words[i];

            if(curr.charAt(0) != pc || wordSet.contains(curr)) {
                answer[0] = current;
                answer[1] = count[current];
                break;
            }

            pc = curr.charAt(curr.length()-1);
            wordSet.add(curr);
        }

        return answer;
    }
}