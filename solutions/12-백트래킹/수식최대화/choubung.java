/*
카카오는 핵심 알고리즘보다는,
자잘한 파싱이나 함수 분리해야 코드가 깔끔해진다는 게 어려운 것 같다.
 */

import java.util.*;

class Solution {
    String[][] priorities = {
            {"+", "-", "*"}, {"+", "*", "-"},
            {"-", "+", "*"}, {"-", "*", "+"},
            {"*", "+", "-"}, {"*", "-", "+"}
    };

    public long solution(String expression) {
        long answer = 0;

        List<Long> numList = new ArrayList<>();
        List<String> opList = new ArrayList<>();

        String[] nums = expression.split("[+\\-*]");
        for (String n : nums) {
            numList.add(Long.parseLong(n));
        }

        String ops = expression.replaceAll("[0-9]", "");
        for (char c : ops.toCharArray()) {
            opList.add(String.valueOf(c));
        }

        for (String[] priority : priorities) {
            List<Long> numbers = new ArrayList<>(numList);
            List<String> operations = new ArrayList<>(opList);

            for (String op : priority) {
                for (int i = 0; i < operations.size(); i++) {
                    if (operations.get(i).equals(op)) {
                        long res = calculate(numbers.get(i), numbers.get(i + 1), op);

                        numbers.remove(i + 1);
                        numbers.set(i, res);
                        operations.remove(i);

                        i--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(numbers.get(0)));
        }

        return answer;
    }

    public long calculate(long num1, long num2, String op) {
        if (op.equals("+")) {
            return num1 + num2;
        }

        if (op.equals("-")) {
            return num1 - num2;
        }

        if (op.equals("*")) {
            return num1 * num2;
        }

        return -1;
    }
}
