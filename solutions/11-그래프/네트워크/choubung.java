/*
유니온 파인드 기억 안 나서 섬 연결 코드 참고함...
네트워크 개수를 셀 때 처음엔 set을 적용했는데,
연결되어있지만 부모 표기가 다른 경우가 있을 수 있어서...
그냥 원론적으로 생각해서 직접 세는 게 더 낫다
 */

import java.util.*;

class Solution {
    int[] parent;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int from = 0; from < n; from++) {
            for (int to = 0; to < n; to++) {
                if (from != to && computers[from][to] == 1) {
                    union(from, to);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                answer++;
            }
        }
        return answer;
    }

    public int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
