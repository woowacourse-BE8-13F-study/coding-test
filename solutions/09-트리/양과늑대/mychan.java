import java.util.*;

class Solution {

    // 최대 양의 수를 저장
    private int maxSheep = 0;
    // 트리 인접 리스트
    private List<List<Integer>> tree = new ArrayList<>();

    public int solution(int[] info, int[][] edges) {
        //info	                    edges	                                                                result
        //[0,0,1,1,1,0,1,0,1,0,1,1]	[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]	5

        // 모을수 있는 양의 최대 마리수 return
        // 0 양, 1 늑대

        // dfs로 다음 자식들이 양 개수 - 늑대개수 > 0 인 다음 노드로 이동

        // 트리 초기화
        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        // 다음에 갈 수 있는 노드들을 담을 리스트 생성 및 루트 노드 추가
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        // dfs 탐색 시작 (현재 노드는 0번이지만 처음 들어갈 때 계산)
        dfs(0, 0, 0, nextNodes, info);

        return maxSheep;
    }

    private void dfs(int currentNode, int sheepCount, int wolfCount, List<Integer> nextNodes, int[] info) {
        // 현재 노드의 양/늑대 여부에 따라 카운트 증가
        if (info[currentNode] == 0) {
            sheepCount++;
        } else {
            wolfCount++;
        }

        // 늑대가 양과 같거나 많아지면 탐색 종료
        if (sheepCount <= wolfCount) {
            return;
        }

        // 최대 양의 개수 갱신
        maxSheep = Math.max(maxSheep, sheepCount);

        // 다음 탐색을 위한 새로운 후보 리스트 생성
        List<Integer> nextList = new ArrayList<>(nextNodes);

        // 현재 방문한 노드는 다음 후보에서 제외
        nextList.remove(Integer.valueOf(currentNode));

        // 현재 노드의 자식 노드들을 새로운 후보에 추가
        if (tree.get(currentNode) != null) {
            nextList.addAll(tree.get(currentNode));
        }

        // 갈 수 있는 모든 다음 노드들에 대해 재귀 호출
        for (int nextNode : nextList) {
            dfs(nextNode, sheepCount, wolfCount, nextList, info);
        }
    }
}