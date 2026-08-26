import java.util.*;

class Solution {

    static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {

        List<Node>[] graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] r : road) {
            int v1 = r[0];
            int v2 = r[1];
            int c = r[2];

            graph[v1].add(new Node(v2, c));
            graph[v2].add(new Node(v1, c));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int answer = 0;

        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost)
        );

        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(current.cost > dist[current.vertex]) {
                continue;
            }

            for(Node next : graph[current.vertex]) {
                int newCost = current.cost + next.cost;

                if(newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    pq.offer(new Node(next.vertex, newCost));
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) {
                answer += 1;
            }
        }
        return answer;
    }
}
