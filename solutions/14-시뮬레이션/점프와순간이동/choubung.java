/*
처음에는 전부 탐색해서 가장 작은 값을 찾으려고 했다.
그런데 규칙이 너무 변칙적이라, 모든 경우의 수 탐색 자체가 힘들 것 같았다.
문제를 잘 보니, 도착지부터 거꾸로 짝수면 그냥 나누기, 홀수면 -1하여 짝수로 만들어 나누기를 하면 될 것 같았다.
 */

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (true) {
            if (n == 0) {
                break;
            }

            if (n % 2 != 0) {
                n--;
                answer++;
            }

            n /= 2;
        }

        return answer;
    }
}
