/*
스택 파트의 문제지만, 들어온 순서대로 출력해야 하므로 queue 개념으로 접근해 푸는 게 더 적절하다고 생각했다.
- peek() : 가장 앞의 것을 조회
- peekLast() : 가장 뒤의 것을 조회
- add() / offer() : 맨 뒤에 요소 넣기 (offer()는 예외 발생 안 함)
 */

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (int num : arr) {
            if (queue.size() != 0 && queue.peekLast() == num) {
                continue;
            }

            queue.add(num);
        }

        int[] answer = queue.stream()
            .mapToInt(Integer::intValue)
            .toArray();

        return answer;
    }
}
