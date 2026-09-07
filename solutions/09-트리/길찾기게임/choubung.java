/*
무조건 다시 풀기...
풀이를 어떻게 해야할 지는 보이는데, 구현이 안 된다.
 */


import java.util.*;

class Solution {
    int idx = 0;

    public int[][] solution(int[][] nodeinfo) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i+ 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        list.sort((n1, n2) -> {
                    if (n1.y == n2.y) {
                        return n1.x - n2.x;
                    }
                    return n2.y - n1.y;
                }
        );

        Node root = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }


        int[][] answer = new int[2][nodeinfo.length];

        idx = 0;
        preOrder(root, answer[0]);

        idx = 0;
        postOrder(root, answer[1]);

        return answer;
    }

    public void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    private void preOrder(Node node, int[] result) {
        if (node == null) return;

        result[idx++] = node.id;
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    private void postOrder(Node node, int[] result) {
        if (node == null) return;

        postOrder(node.left, result);
        postOrder(node.right, result);
        result[idx++] = node.id;
    }

    class Node {
        int id;
        int x, y;
        Node left, right;

        public Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }
}
