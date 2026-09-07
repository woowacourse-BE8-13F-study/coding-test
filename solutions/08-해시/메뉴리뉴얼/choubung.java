/*
진짜 이해가 전혀 안 감...
dfs 좀 익숙해졌다고 생각했는데,
약간 꼬았다고 바로 모르겠음...
무조건 다시 풀어봐야할 듯 함...
 */

import java.util.*;

class Solution {
    static Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int courseSize : course) {
            map = new HashMap<>();
            int maxCount = 0;

            for (String order : orders) {
                char[] charArr = order.toCharArray();
                Arrays.sort(charArr);

                if (charArr.length >= courseSize) {
                    makeCombination(charArr, new StringBuilder(), 0, 0, courseSize);
                }
            }

            for (int count : map.values()) {
                if (count >= 2) {
                    maxCount = Math.max(maxCount, count);
                }
            }

            if (maxCount >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == maxCount) {
                        answerList.add(key);
                    }
                }
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    private static void makeCombination(char[] charArr, StringBuilder current, int index, int depth, int targetSize) {
        if (depth == targetSize) {
            String comb = current.toString();
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = index; i < charArr.length; i++) {
            current.append(charArr[i]);
            makeCombination(charArr, current, i + 1, depth + 1, targetSize);
            current.deleteCharAt(current.length() - 1); // 원상복구
        }
    }
}
