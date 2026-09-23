/*
삼각형이라는 배치 때문에 어떻게 해야 할지 매우 고민했다...
직각 삼각형으로 접근해서 조금더 쉽게 하려고 했다.
 */

import java.util.*;

class Solution {
    int[] dx = {1, 0, -1};
    int[] dy = {0, 1, -1};

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        List<Integer> answer = new ArrayList<>();

        int index = 0;
        int count = 1;
        int row = -1;
        int col = 0;

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                row += dx[index];
                col += dy[index];

                arr[row][col] = count;
                count++;
            }

            index = (index+1) % 3;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    answer.add(arr[i][j]);
                }
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
