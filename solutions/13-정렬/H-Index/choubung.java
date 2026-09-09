import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();

        for (int citation : citations) {
            list.add(citation);
        }

        list.sort(Comparator.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < i + 1) {
                return i;
            }
        }

        return list.size();
    }
}
