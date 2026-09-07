class Solution {
    public int solution(int n, int a, int b) {

        // 게임 참가자 수 n
        // A번 참가자와 B번 참가자가 몇 번째 라운드에서 만나는지 return

        int answer = 0;

        while(a!=b) {

            a = (a+1)/2;
            b = (b+1)/2;

            answer++;
        }

        return answer;
    }
}