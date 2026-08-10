/*
노드를 자꾸 구현하고 싶어져서 그러지 않도록 잘 제동을 걸어야겠다...
어떤 문제는 노드클래스를 만드는 게 또 낫던데
그런 문제와 아닌 문제의 차이가 뭔지도 궁금하다...
 */

import java.util.*;

class Solution {
    static int answer = 0;
    static List<Integer>[] tree;

    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        dfs(0, 0, 0, nextNodes, info);

        return answer;
    }

    public void dfs(int current, int sheepCount, int wolfCount, List<Integer> nextNodes, int[] info) {
        if (info[current] == 0) {
            sheepCount += 1;
        } else {
            wolfCount += 1;
        }

        if (sheepCount <= wolfCount) {
            return;
        }

        answer = Math.max(answer, sheepCount);

        System.out.println("sheep: " + sheepCount + ", wolf: " + wolfCount + ", answer: " + answer);

        List<Integer> nextList = new ArrayList<>(nextNodes);
        nextList.remove(Integer.valueOf(current));

        for (int child : tree[current]) {
            nextList.add(child);
        }

        for (int next : nextList) {
            dfs(next, sheepCount, wolfCount, nextList, info);
        }
    }
}

/*

노드를 구현한 코드

import java.util.*;

class Solution {
    static int answer = 0;

    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            Node node = new Node(i, info[i]);
            list.add(node);
        }

        for (int i = 0; i < edges.length; i++) {
            Node child = list.get(edges[i][1]);
            Node parents = list.get(edges[i][0]);

            parents.addChild(child);
            child.setParents(parents);
        }

        dfs(list.get(0), visited, 0, 0);

        return answer;
    }

    public void dfs(Node current, int sheepCount, int wolfCountList<Node> nextNodes) {
        if (current.isSheep) {
            sheepCount += 1;
        } else {
            wolfCount += 1;
        }

        if (sheepCount <= wolfCount) {
            return;
        }

        answer = Math.max(answer, sheepCount);

        System.out.println("sheep: " + sheepCount + ", wolf: " + wolfCount + ", answer: " + answer);

        List<Node> nextList = new ArrayList<>(nextNodes);
        nextList.remove(findByNodeNum());

        for (Node child : current.children) {
            nextList.add(child.nodeNum);
        }

        for (int next : nextList) {
            dfs()
        }
    }

    public boolean isAllVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                return false;
            }
        }

        return true;
    }

    class Node {
        int nodeNum;
        Node parents;
        boolean isSheep;
        List<Node> children;

        public Node(int num, int wolfCount) {
            this.nodeNum = num;
            children = new ArrayList<>();

            if (wolfCount == 0) {
                isSheep = true;
            } else {
                isSheep = false;
            }
        }

        public void setParents(Node node) {
            this.parents = node;
        }

        public void addChild(Node node) {
            this.children.add(node);
        }
    }
}
 */
