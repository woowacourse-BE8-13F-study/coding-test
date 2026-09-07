import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {

        //표의 행을 선택, 삭제, 복구 하는 프로그램
        boolean[] deleted = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        int[] prevR = new int[n];
        int[] nextR = new int[n];

        for (int i = 0; i < n; i++) {
            prevR[i] = i - 1;
            nextR[i] = i + 1;
        }

        int current = k;

        for(String command : cmd) {

            char c = command.charAt(0);


            if(c == 'U') {

                int x = Integer.parseInt(command.split(" ")[1]);
                // x칸 위로 이동 (삭제된 행 건너뛰기)
                for (int i = 0; i < x; i++) {
                    current = prevR[current];
                }


            } else if(c == 'D') {

                int x = Integer.parseInt(command.split(" ")[1]);
                // x칸 아래로 이동
                for (int i = 0; i < x; i++) {
                    current = nextR[current];
                }

            } else if(c == 'C') {

                // 현재 행 삭제
                deleted[current] = true;
                stack.push(current);

                int prev = prevR[current];
                int next = nextR[current];

                // 다음 행 또는 이전 행 선택
                if (next < n) {
                    current = next;
                } else {
                    current = prev;
                }

                // 연결 끊기 (논리적 삭제)
                if (prev != -1) {
                    nextR[prev] = next;
                }
                if (next < n) {
                    prevR[next] = prev;
                }

            } else if(c == 'Z') {
                int recovered = stack.pop();
                deleted[recovered] = false;

                int prev = prevR[recovered];
                int next = nextR[recovered];

                // 연결 복구
                if (prev != -1) {
                    nextR[prev] = recovered;
                }
                if (next < n) {
                    prevR[next] = recovered;
                }

            }

        }

        // U 4 위로 4칸 행 선택

        // D 4 아래로 4칸 행 선택

        // C 현재 선택된 행 삭제 후, 바로 아래 행 선택
        // 마지막 행 삭제라면 바로 위의 행 선택

        // Z 가장 최근 삭제된 행을 복구
        // 선택된 행은 바뀌지 않음

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(deleted[i] ? 'X' : 'O');
        }

        return result.toString();

    }
}