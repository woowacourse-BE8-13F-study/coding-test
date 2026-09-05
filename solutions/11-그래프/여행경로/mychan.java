import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();

        // 항공권 정보 2차원 배열 tickets
        // 방문하는 공항 경로 배열 return
        // 가능한 경로가 2개 이상이면 알파벳 순서 앞서는 경로 return

        Map<String, List<String>> graph = new HashMap<>();

        for(String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        for(List<String> v : graph.values()) {
            Collections.sort(v);
        }

        String current = "ICN";
        answer.add(current);

        dfs(current, tickets.length, graph, answer);

        return answer.toArray(new String[0]);
    }

    private boolean dfs(String current, int remain, Map<String, List<String>> graph, List<String> answer) {
        if(remain == 0) {
            return true;
        }

        List<String> v = graph.get(current);
        if(v == null || v.isEmpty()) {
            return false;
        }

        for(int i=0; i< v.size(); i++) {
            String next = v.get(i);

            v.remove(i);
            answer.add(next);

            if(dfs(next, remain-1, graph, answer)) return true;

            v.add(i, next);
            answer.remove(answer.size() - 1);
        }

        return false;
    }
}