import java.util.*;

class Solution {

    char[][] priorities = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
    };
    static List<Long> numbers;
    static List<Character> operators;

    public long solution(String expression) {

        long answer = -1;
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
        separate(expression);

        for(int i = 0; i < priorities.length; i++) {
            List<Long> numbers_copied = new ArrayList<>(numbers);
            List<Character> operators_copied = new ArrayList<>(operators);

            for(int j = 0; j < 3; j++) {
                char op = priorities[i][j];

                for(int k = 0; k < operators_copied.size(); k++) {
                    if(operators_copied.get(k) == op) {
                        long calculated = calculate(numbers_copied.get(k), numbers_copied.get(k + 1), op);
                        numbers_copied.set(k, calculated);

                        numbers_copied.remove(k + 1);
                        operators_copied.remove(k);

                        k--;
                    }
                }
            }

            long result = Math.abs(numbers_copied.get(0));
            if(result > answer) {
                answer = result;
            }
        }

        return answer;
    }

    private void separate(String expression) {
        long num = 0;
        for(char c : expression.toCharArray()) {
            if('0' <= c && c <= '9') {
                num *= 10;
                num += c - '0';
            } else {
                numbers.add(num);
                operators.add(c);
                num = 0;
            }
        }
        numbers.add(num);
    }

    private long calculate(long a, long b, char op) {
        if(op == '+') {
            return a + b;
        }
        if(op == '-') {
            return a - b;
        }
        if(op == '*') {
            return a * b;
        }
        return 0;
    }
}
