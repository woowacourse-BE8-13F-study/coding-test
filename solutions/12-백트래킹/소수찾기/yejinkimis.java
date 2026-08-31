import java.util.*;

class Solution {

    static Set<Integer> numbers_set = new HashSet<>();

    public int solution(String numbers) {

        int answer = 0;

        recursive("", numbers);

        Iterator<Integer> it = numbers_set.iterator();

        while(it.hasNext()) {
            Integer num = it.next();
            if(isPrime(num)) {
                answer += 1;
            }
        }

        return answer;
    }

    private void recursive(String comb, String others) {
        if(!comb.equals("")) {
            numbers_set.add(Integer.valueOf(comb));
        }

        for(int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    private boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
