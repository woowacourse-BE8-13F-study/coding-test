import java.util.*;

class Solution {

    static boolean[] visited;
    List<String> answer;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        List<String> currentRoute = new ArrayList<>();
        currentRoute.add("ICN");

        dfs("ICN", currentRoute, tickets);

        return answer.toArray(new String[0]);
    }

    private void dfs(String current, List<String> currentRoute, String[][] tickets) {
        if(currentRoute.size() == tickets.length + 1) {
            answer = new ArrayList<>(currentRoute);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                currentRoute.add(tickets[i][1]);

                dfs(tickets[i][1], currentRoute, tickets);

                if (!answer.isEmpty()) return;

                currentRoute.remove(currentRoute.size() - 1);

                visited[i] = false;
            }
        }
    }
}
