import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {

        // 두팀으로 나눔
        // 같은 곳을 다른 순서로 방문해서 먼저 순회를 마친 팀이 승리

        // 서로 다른 x값을 갖음
        // 같은 레벨은 y좌표
        // 자식의 y는 항상 부모 보다 작다

        // 노드 v의 왼쪽 서브트리의 모든 노드 x값은 v의 x값보다 작다.
        // 노드 v의 오른쪽 서브트리에 있는 모든 노드의 x값은 v의 x값보다 크다.

        // 전위 순회, 후위 순회 결과를 2차원 배열에 순서대로 담아 return

        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // y 내림차순, x 오름차순 정렬 , 위에서 아래로, 부모 먼저 삽입
        Arrays.sort(nodes, (a, b) -> {
            if (a.y != b.y) return b.y - a.y;
            return a.x - b.x;
        });

        Node root = nodes[0];
        for (int i = 1; i < n; i++) {
            insert(root, nodes[i]);
        }

        List<Integer> pre = preorder(root);
        List<Integer> post = postorder(root);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
    }

    private void insert(Node root, Node node) {
        Node cur = root;
        while (true) {
            if (node.x < cur.x) {
                if (cur.left == null) { cur.left = node; return; }
                cur = cur.left;
            } else {
                if (cur.right == null) { cur.right = node; return; }
                cur = cur.right;
            }
        }
    }

    private List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node == null) continue;
            result.add(node.num);
            // 스택이라 오른쪽 먼저 넣어야 왼쪽이 먼저
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    private List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root, lastVisited = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node peek = stack.peek();
            if (peek.right != null && lastVisited != peek.right) {
                cur = peek.right;
            } else {
                result.add(peek.num);
                lastVisited = stack.pop();
            }
        }
        return result;
    }
}

class Node {
    int num, x, y;
    Node left;
    Node right;

    Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}