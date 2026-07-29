import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        char[] answer = new char[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            answer[i] = 'O';
        }
        next[n - 1] = -1;

        for(String s : cmd) {
            switch (s.charAt(0)) {
                case 'D': {
                    int x = getX(s);
                    for(int i = 0; i < x; i++) {
                        k = next[k];
                    }
                    break;
                }
                case 'U': {
                    int x = getX(s);
                    for(int i = 0; i < x; i++) {
                        k = prev[k];
                    }
                    break;
                }
                case 'C': {
                    stack.push(k);
                    answer[k] = 'X';
                    int p = prev[k];
                    int nn = next[k];
                    if(p != -1) {
                        next[p] = nn;
                    }
                    if(nn != -1) {
                        prev[nn] = p;
                        k = nn;
                    } else {
                        k = p;
                    }
                    break;
                }
                case 'Z': {
                    int popped = stack.pop();
                    answer[popped] = 'O';
                    int p = prev[popped];
                    int nn = next[popped];
                    if (p != -1) {
                        next[p] = popped;
                    }
                    if (nn != -1) {
                        prev[nn] = popped;
                    }
                    break;
                }
            }
        }
        return new String(answer);
    }

    private int getX(String s) {
        return Integer.parseInt(s.substring(2, s.length()));
    }
}
