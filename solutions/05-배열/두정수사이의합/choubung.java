/*
두 정수 사이의 합
주제는 배열 파트인데 굳이 배열을 쓸 필요를 모르겠다.
 */

public class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for (int i = start; i <= end; i++) {
            answer += i;
        }

        return answer;
    }
}
