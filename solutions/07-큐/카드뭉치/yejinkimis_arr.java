class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        int len1 = cards1.length;
        int len2 = cards2.length;

        for(String s : goal) {
            if (idx1 < len1 && s.equals(cards1[idx1])) {
                idx1+=1;
            } else if(idx2 < len2 && s.equals(cards2[idx2])) {
                idx2+=1;
            } else {
                return new String("No");
            }
        }

        return new String("Yes");
    }
}
