/*
최소 비용을 어떻게 얻을 수 있는지는 생각하기가 쉬웠다
근데 유니온 파인드를 이해하고 적용하기 힘들었다.
처음에는 단순 방문처리로 생각해서, 섬이 모두 연결되지 않은 상태가 생겼었다
유니온파인드를 좀 더 잘 공부할 필요가 있는 것 같다...
 */

import java.util.*;

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int answer = 0;

        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if (union(from, to)) {
                answer += cost;
            }
        }

        return answer;
    }

    public int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
}
