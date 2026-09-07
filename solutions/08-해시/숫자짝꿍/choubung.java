/*
단순무식하게 풀어야 하는데,
완벽히 깔끔하게 풀고 싶다는 생각에 말도 안 되게 돌아간다
 */

import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();

        int[] xCount = new int[10];
        int[] yCount = new int[10];

        for (int i = 0; i < X.length(); i++) {
            xCount[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            yCount[Y.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            int count = Math.min(xCount[i], yCount[i]);

            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }

        if (sb.length() == 0) {
            return "-1";
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
