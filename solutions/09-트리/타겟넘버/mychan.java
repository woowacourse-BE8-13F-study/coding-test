class Solution {

    int answer = 0;

    public int solution(int[] numbers, int target) {

        // 사용할 수 있는 숫자들로 적절히 더하거나 빼서 타겟 넘버를 만드는 방법의 수 return
        // 1. 재귀
        // 2. 큐
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, depth+1, sum+numbers[depth]);
        dfs(numbers, target, depth+1, sum-numbers[depth]);
    }
}