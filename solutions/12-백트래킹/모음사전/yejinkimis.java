class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;
    static int answer = 0;

    public int solution(String word) {
        count = 0;
        answer = 0;

        dfs("", 0, word);

        return answer;
    }

    private void dfs(String str, int len, String target) {
        if(answer != 0) return;

        if(!str.equals("")) {
            count++;

            if(str.equals(target)) {
                answer = count;
                return;
            }
        }

        if(len >= 5) return;

        for(int i = 0; i < 5; i++) {
            dfs(str + vowels[i], len + 1, target);
        }
    }
}
