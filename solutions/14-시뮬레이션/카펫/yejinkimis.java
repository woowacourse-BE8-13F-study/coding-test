import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int length;
        int width;
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                length = i;
                width = yellow / i;
                if (length * 2 + width * 2 + 4 == brown) {
                    answer[0] = width + 2;
                    answer[1] = length + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}
