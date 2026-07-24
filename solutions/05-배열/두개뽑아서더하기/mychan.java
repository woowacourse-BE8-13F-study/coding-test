import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 두개의 수를 뽑아 더해서 만들 수 있는 모든 수
        Set<Integer> result = new TreeSet<>();

        int size = numbers.length;

        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}