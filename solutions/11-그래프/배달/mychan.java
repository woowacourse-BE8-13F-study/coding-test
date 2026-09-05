import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {

        List<List<int[]>> g = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            g.add(new ArrayList<>());
        }

        for(int[] r : road) {

            int a = r[0];
            int b = r[1];
            int c = r[2];

            g.get(a).add(new int[]{b, c});
            g.get(b).add(new int[]{a, c});
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{1,0});

        while(!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int d = current[1];

            if(d > dist[node]) continue;

            for(int[] next : g.get(node)) {

                int nextNode = next[0];
                int cost = next[1];

                if(dist[node] + cost < dist[nextNode]) {
                    dist[nextNode] = dist[node] + cost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int answer = 0;

        for(int i=1; i<=N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}