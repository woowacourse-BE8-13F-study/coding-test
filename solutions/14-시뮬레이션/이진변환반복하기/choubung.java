/*
새로 배운 문법:
Integer.toBinaryString()에 정수 값을 넣으면 이진수 형태의 문자열
알고리즘보다는 적절한 메서드를 찾는 게 어려웠다.
이진수 관련 메서드를 좀 외워놓는 게 좋을 것 같긴하다.
 */

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeroCount = 0;

        // 1이 될 때까지 반복
        while(!"1".equals(s)) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                }
            }

            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            count++;
        }

        return new int[]{count, zeroCount};
    }
}
