import java.util.*;

class Solution {

    int answer;

    public int solution(int[] info, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        answer = 0;

        for(int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            tree.get(e[0]).add(e[1]);
        }

        List<Integer> next_nodes = new ArrayList<>();
        next_nodes.add(0);

        dfs(0, 0, 0, next_nodes, info, tree);

        return answer;
    }

    private void dfs(int index, int sheep, int wolf, List<Integer> next_nodes, int[] info, List<List<Integer>> tree) {

        if (info[index] == 0) { sheep += 1; }
        if (info[index] == 1) { wolf += 1; }
        if (sheep <= wolf) { return; }

        answer = Math.max(answer, sheep);

        List<Integer> updated_next_nodes = new ArrayList<>(next_nodes);
        updated_next_nodes.remove(Integer.valueOf(index));

        for(int n : tree.get(index)) {
            updated_next_nodes.add(n);
        }

        for(int n : updated_next_nodes) {
            dfs(n, sheep, wolf, updated_next_nodes, info, tree);
        }
    }
}
