
import java.util.*;

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] conn : costs) {
            int from = conn[0];
            int to = conn[1];
            int price = conn[2];

            if(find(from) != find(to)) {
                union(from, to);
                answer += price;
            }
        }
        return answer;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
