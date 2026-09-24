/*
처음 내가 생각한 풀이는, 시계방향을 돌며 밀어야 하는 것을 저장하고, 덮어쓰는 방식이었다.
수가 밀리는 걸 어떻게 구현해야할 지 감이 오지 않았기 때문이다.
그러나 이게 최선의 코드가 아닐 것 같아 제미나이에게 물어보니, 반시계방향으로 돌며 땡기는 방법이 있다는 걸 알게 되었다.
코테를 대비해 일단 첫 생각 버전으로 스스로 풀고,
두 번째 버전도 '반시계 방향으로 돌며 밀기'만 인지한 상태로 스스로 풀어보았다.
 */

import java.util.*;

class Solution {
    int[][] arr;

    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();

        arr = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }

        for (int[] query : queries) {
            answer.add(rotateAndFindMin(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1));
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int rotateAndFindMin(int fromRow, int fromCol, int toRow, int toCol) {
        int temp = arr[fromRow][fromCol];
        int min = temp;

        for (int i = fromRow; i < toRow; i++) {
            arr[i][fromCol] = arr[i + 1][fromCol];
            min = Math.min(min, arr[i][fromCol]);
        }

        for (int i = fromCol; i < toCol; i++) {
            arr[toRow][i] = arr[toRow][i + 1];
            min = Math.min(min, arr[toRow][i]);
        }

        for (int i = toRow; i > fromRow; i--) {
            arr[i][toCol] = arr[i - 1][toCol];
            min = Math.min(min, arr[i][toCol]);
        }

        for (int i = toCol; i > fromCol; i--) {
            arr[fromRow][i] = arr[fromRow][i - 1];
            min = Math.min(min, arr[fromRow][i]);
        }

        arr[fromRow][fromCol + 1] = temp;
        return min;
    }
}

/*
구 버전
: 시계방향으로 미는 행동을 할 때 총 두 바퀴를 돌며,
1) 밀어야하는 것들 리스트에 저장
2) 다음 칸부터 다시 돌며 덮어쓰기

import java.util.*;

class Solution {
    // 시계방향 이동 벡터
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] arr;

    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        arr = new int[rows][columns];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num;
                num++;
            }
        }

        for (int[] query : queries) {
            answer.add(rotateAndFindMin(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1));
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    public int rotateAndFindMin(int fromRow, int fromCol, int toRow, int toCol) {
        int row = fromRow;
        int col = fromCol;
        int index = 0;

        List<Integer> list = new ArrayList<>();

        while (true) {
            list.add(arr[row][col]);

            int nr = row + dx[index];
            int nc = col + dy[index];

            if (nr < fromRow || nr > toRow || nc < fromCol || nc > toCol) {
                index = (index + 1) % 4;
            }

            row += dx[index];
            col += dy[index];

            if (row == fromRow && col == fromCol) {
                break;
            }
        }

        col++;
        index = 0;

        for (int num : list) {
            arr[row][col] = num;

            int nr = row + dx[index];
            int nc = col + dy[index];

            if (nr < fromRow || nr > toRow || nc < fromCol || nc > toCol) {
                index = (index + 1) % 4;
            }

            row += dx[index];
            col += dy[index];
        }

        return Collections.min(list);
    }
}


 */
