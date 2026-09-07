import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // 탐욕법: 매 순간 좋아보이는 최선의 선택으로 그게 전체 최적으로 이어진다고 믿는 방법
        // n개 섬 사이에 다리 건설 비용
        // 최소 비용으로 모든 섬이 서로 통행 가능하도록 만드는 최소 비용
        // 배열 0,1,2는 (섬1, 섬2, 비용) 이렇게 되어 있음
        // 순서 바뀌어도 하나로 간주

        int answer=0;
        int edgeCount=0;

        // 간선의 가중치로 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        // 처음의 본인 가방을 부모로 표현하고 각 노드가 어떤 부모에 포함되어 있는지 초기화한다.
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int[] edge : costs) {
            // 작은 가중치 간선부터 하나씩 순회하면서 a,b가 같은 가방에 들어있는지 검사

            int rootA=findRoot(parent, edge[0]);
            int rootB=findRoot(parent, edge[1]);

            if(rootA != rootB) {
                // 가방이 다르면 하나 가방으로 합친다.
                // root 끼리 연결한다.
                parent[rootB] = parent[rootA];
                // 정답 간선 비용에 덧셈
                answer+= edge[2];
                edgeCount++;
            }

            // 모두 통행한지 검사 후에 가능하면 그때까지 가중치로 정답 return
            // MST 최소 신장 트리는 n개 노드에 n-1 간선이면 모두 통행 가능하기 때문에, 즉시 종료하도록 한다.
            if(edgeCount == n-1) break;
        }

        return answer;
    }

    private int findRoot(int[] parent, int node) {
        if(node == parent[node]) {
            return node;
        }

        return findRoot(parent, parent[node]);
    }
}