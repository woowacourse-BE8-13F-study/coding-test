import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        // 정답의 순서대로 매개변수로 주어진다.
        int[][] a = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] result = {0, 0, 0};

        // 맞힌 문제의 개수 계산해서 배열 정렬
        for (int i = 0; i < 3; i++) {
            int size = a[i].length;

            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == a[i][j % size]) {
                    result[i]++;
                }
            }
        }
        // 제일 큰수를 찾아서 앞에서부터 그 수가 있는 index+1을 결과 배열에 넣는다.
        int max = Arrays.stream(result).max().getAsInt();

        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (result[i] == max) {
                index.add(i + 1);
            }
        }

        return index.stream().mapToInt(Integer::intValue).toArray();
    }
}