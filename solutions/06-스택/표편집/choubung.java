/*
중간에 헤맨 부분이 너무 많았다.
일단 연결 리스트를 써야 한다는 생각을 못 했고,
삭제 여부를 관리하는 boolean 배열을 만들었다.
그러나 여러모로 시간초과가 발생했다....
방향성 인트를 거의 다 받아서 푼 거라서 주말에 다시 풀어야 할 것 같다.
 */

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int current = k;
        int[] pre = new int[n];
        int[] next = new int[n];
        Deque<Integer> deleted = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }

        next[n - 1] = -1;

        for (String c : cmd) {
            char op = c.charAt(0);

            if (op == 'U') {
                int distance = Integer.valueOf(c.split(" ")[1]);
                while(distance-- > 0) {
                    current = pre[current];
                }
            }

            if (op == 'D') {
                int distance = Integer.valueOf(c.split(" ")[1]);
                while(distance-- > 0) {
                    current = next[current];
                }
            }

            if (op == 'C') {
                deleted.push(current);

                int preNode = pre[current];
                int nextNode = next[current];

                if (preNode != -1) next[preNode] = nextNode;
                if (nextNode != -1) pre[nextNode] = preNode;

                if (nextNode == -1) {
                    current = preNode;
                } else {
                    current = nextNode;
                }

                continue;
            }

            if (op == 'Z') {
                int undo = deleted.pop();

                if (pre[undo] != -1) next[pre[undo]] = undo;
                if (next[undo] != -1) pre[next[undo]] = undo;
            }
        }

        StringBuilder answer = new StringBuilder("O".repeat(n));
        while (!deleted.isEmpty()) {
            answer.setCharAt(deleted.pop(), 'X');
        }

        return answer.toString();
    }
}
