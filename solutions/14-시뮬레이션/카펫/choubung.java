/*
아래의 규칙을 먼저 찾은 뒤, 코드로 구현했다.
x * y == brown + yellow
brown == 2 * (x + y - 2)

x와 y에 어떤 값을 대입할 지가 고민이었는데, 가로가 세로보다 길다는 기준이 있어서
x(가로)는 넓이에서 넓이의 제곱근까지 값을 탐색하게 했고,
x가 넓이의 약수일 때만 y까지 구해서 조건문을 확인하도록 했다.
 */

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x, y;
        int sum = brown + yellow;

        for (int i = sum; i >= Math.sqrt(sum); i--) {
            if (sum % i != 0) {
                continue;
            }

            x = i;
            y = sum / i;

            if ((2 * (x + y - 2)) == brown) {
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }

        return answer;
    }
}
