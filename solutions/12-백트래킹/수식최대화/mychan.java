import java.util.*;

class Solution {
    public Long solution(String expression) {

        List<String> a = Arrays.asList(expression.split("(?<=[-+*])|(?=[-+*])"));

        char[][] orders = {
                {'+','-','*'}, {'+','*','-'},
                {'-','+','*'}, {'-','*','+'},
                {'*','+','-'}, {'*','-','+'}
        };

        Long answer = 0L;
        for(char[] order : orders) {
            answer = Math.max(answer, Math.abs(calculate(a, order)));
        }

        return answer;
    }

    private Long calculate(List<String> a, char[] order) {

        List<String> b = new ArrayList<>(a);

        for(char o : order) {

            for(int i=0; i< b.size(); i++) {

                if(b.get(i).equals(String.valueOf(o))) {

                    Long x = Long.parseLong(b.get(i-1));
                    Long y = Long.parseLong(b.get(i+1));
                    Long z = o == '+' ? x+y : o == '-' ? x-y : x*y;

                    b.set(i-1, String.valueOf(z));
                    b.remove(i+1);
                    b.remove(i);
                    i--;

                }
            }

        }
        return Long.parseLong(b.get(0));
    }
}