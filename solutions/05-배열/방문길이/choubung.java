/*
 처음엔 커스텀 클래스를 만들었지만, 코테에서 하기에는 여러 위험 요소가 있었다.
 찾아보니 String을 많이 활용하는 듯해서, 해당 방벙으로 다시 풀었다.
 방문 여부가 중요한 문제는 방문 처리에서 실수가 안 나도록 하는 게 중요한 것 같다.
 */

import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(String dirs) {
        List<String> visited = new ArrayList<>();
        int answer = 0;

        int cx = 0;
        int cy = 0;

        for(int i = 0; i < dirs.length(); i++) {
            int index = convertIndex(dirs.charAt(i));
            int nx = cx + dx[index];
            int ny = cy + dy[index];

            if (nx > -6 && nx < 6 && ny > -6 && ny < 6) {
                String edge = "(" + cx + ", " + cy + ") -> (" + nx + ", " + ny + ")";

                if (!visited.contains(edge)) {
                    visited.add(edge);
                    String reversedEdge = "(" + nx + ", " + ny + ") -> (" + cx + ", " + cy + ")";
                    visited.add(reversedEdge);
                    answer++;
                }

                cx = nx;
                cy = ny;
            }
        }

        return answer;
    }

    public int convertIndex(char alp) {
        if (alp == 'U') return 0;
        if (alp == 'D') return 1;
        if (alp == 'R') return 2;
        if (alp == 'L') return 3;
        return -1;
    }
}

/*
커스텀 클래스를 만든 버전

import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(String dirs) {
        List<Set<Node>> visited = new ArrayList<>();

        int answer = 0;
        Node currentNode = new Node(0, 0);

        for (int i = 0; i < dirs.length(); i++) {
            int index = convertIndex(dirs.charAt(i));
            int nx = currentNode.x + dx[index];
            int ny = currentNode.y + dy[index];

            if (nx > -6 && nx < 6 && ny > -6 && ny < 6) {
                Node nextNode = new Node(nx, ny);
                Set<Node> edge = new HashSet<>();
                edge.add(currentNode);
                edge.add(nextNode);

                if (!visited.contains(edge)) {
                    visited.add(edge);
                    answer++;
                }

                currentNode = nextNode;
            }
        }

        return answer;
    }

    public int convertIndex(char alp) {
        if (alp == 'U') return 0;
        if (alp == 'D') return 1;
        if (alp == 'R') return 2;
        if (alp == 'L') return 3;
        return -1;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return this.x == node.x && this.y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }
}

 */
