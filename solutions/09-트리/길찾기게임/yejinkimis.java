import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];
        List<Integer> preOrdered = new ArrayList<>();
        List<Integer> postOrdered = new ArrayList<>();
        List<Node> tree = new ArrayList<>();

        for(int i = 0; i < nodeinfo.length; i++) {
            tree.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(tree);

        Node root = tree.get(0);

        for(int i = 1; i < tree.size(); i++) {
            insertNode(root, tree.get(i));
        }

        preOrder(root, preOrdered);
        postOrder(root, postOrdered);

        answer[0] = preOrdered.stream().mapToInt(i -> i).toArray();
        answer[1] = postOrdered.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    private void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        }
        if(parent.x < child.x) {
            if(parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    private void preOrder(Node node, List<Integer> ordered) {
        if (node == null) return;
        ordered.add(node.num);
        preOrder(node.left, ordered);
        preOrder(node.right, ordered);
    }

    private void postOrder(Node node, List<Integer> ordered) {
        if (node == null) return;
        postOrder(node.left, ordered);
        postOrder(node.right, ordered);
        ordered.add(node.num);
    }
}

class Node implements Comparable<Node>{
    int num;
    int x;
    int y;
    Node left;
    Node right;

    public Node(int n, int x, int y) {
        this.num = n;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node o) {
        if (this.y == o.y) {
            // y가 같다면 x 오름차순
            return Integer.compare(this.x, o.x);
        }
        // 기본적으로 y 내림차순
        return Integer.compare(o.y, this.y);
    }
}
