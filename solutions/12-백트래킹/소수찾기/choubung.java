import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];

        dfs(numbers, "");

        for (int num : set) {
            boolean isDecimal = true;

            if (num == 0 || num == 1) {
                continue;
            }

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isDecimal = false;
                }
            }

            if (isDecimal) {
                System.out.println(num);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(String numbers, String current) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
}
