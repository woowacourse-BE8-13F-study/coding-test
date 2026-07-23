/*
제일 작은 수 제거하기
새로 각인한 함수
- Arrays.sort : 배열 정렬 (cf. Collections.sort : 리스트 정렬)
- Arrays.copyOf : 배열 (깊은) 복사
 */

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int min = sortedArr[0];

        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int num : arr) {
            if (num == min) {
                continue;
            }

            answer[index++] = num;
        }

        return answer;
    }
}
