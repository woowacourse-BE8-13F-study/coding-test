class Solution {
    public int solution(int n) {
        boolean[] np = new boolean[n+1];
        int count = 0;

        for(int i=2; i<=n; i++) {
            if(!np[i]) {
                count++;

                for(int j = 2*i; j<=n; j+=i) {
                    np[j] =true;
                }
            }
        }
        return count;
    }
}