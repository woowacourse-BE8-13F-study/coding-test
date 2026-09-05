/*
* 문법 검색
set을 배열로 바꾸고 싶을 때 : stream().toArray();를 사용
중간에 다른 자료형으로 매핑이 필요한 경우 매퍼 사용
 */

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(answer);
        return answer;
    }
}
