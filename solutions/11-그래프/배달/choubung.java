/*
거리와 cost가 다를 수 있다는 점 때문에 코드를 짜기 난감했다..
다익스트라 코드 템플릿 암기가 필요할 것 같다.
 */

import java.util.*;

class Solution {
    class Edge {
        int town;
        int distance;

        public Edge(int town, int distance) {
            this.town = town;
            this.distance = distance;
        }
    }

    public int solution(int N, int[][] road, int K) {
        List<Edge>[] edges = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] info : road) {
            int from = info[0];
            int to = info[1];
            int distance = info[2];

            edges[from].add(new Edge(to, distance));
            edges[to].add(new Edge(from, distance));

        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (dist[current.town] < current.distance) {
                continue;
            }

            for (Edge next : edges[current.town]) {
                int cost = current.distance + next.distance;

                if (cost < dist[next.town]) {
                    dist[next.town] = cost;
                    pq.add(new Edge(next.town, cost));
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
