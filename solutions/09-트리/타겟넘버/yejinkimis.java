class Solution {

    private int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int index, int currentSum) {
        if(index == numbers.length) {
            if(currentSum == target) {
                answer += 1;
            }
            return;
        }
        dfs(numbers, target, index + 1, currentSum + numbers[index]);
        dfs(numbers, target, index + 1, currentSum - numbers[index]);

    }
}
