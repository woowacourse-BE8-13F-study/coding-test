import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[][] failRatio = new double[N][2];

        for (int i = 1; i <= N; i++) {
            int tried = 0;
            int failed = 0;

            for (int stage : stages) {
                if (stage >= i) {
                    tried++;
                }
                if (stage == i) {
                    failed++;
                }
            }

            failRatio[i-1][0] = i;
            failRatio[i-1][1] = tried == 0 ? 0.0 : (double) failed/tried;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Double.compare(failRatio[i][1], failRatio[j][1]) < 0 ||
                        (Double.compare(failRatio[i][1], failRatio[j][1]) == 0
                                && failRatio[i][0] > failRatio[j][0])) {

                    double[] temp = failRatio[i];
                    failRatio[i] = failRatio[j];
                    failRatio[j] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer[i] = (int) failRatio[i][0];
        }


        return answer;
    }
}
