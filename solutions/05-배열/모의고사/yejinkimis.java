import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supoja1 = {1, 2, 3, 4, 5};
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] correctCount = {0, 0, 0};

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == supoja1[i % supoja1.length]) {
                correctCount[0]++;
            }
        }

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == supoja2[i % supoja2.length]) {
                correctCount[1]++;
            }
        }

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == supoja3[i % supoja3.length]) {
                correctCount[2]++;
            }
        }

        int max = Arrays.stream(correctCount).max().getAsInt();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(correctCount[i] == max) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
