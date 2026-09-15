import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        List<Integer> answer = new ArrayList<>();

        for(int[] c : commands) {

            int i=c[0];
            int j=c[1];
            int k=c[2];

            List<Integer> b = new ArrayList<>();

            for(int x=i; x<=j; x++) {
                b.add(array[x-1]);
            }

            b = b.stream().sorted().toList();

            answer.add(b.get(k-1));
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}