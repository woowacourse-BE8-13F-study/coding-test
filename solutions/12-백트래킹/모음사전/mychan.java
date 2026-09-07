class Solution {
    public int solution(String word) {
        // 단어 하나가 주어졌을 때ㅡ 사전에서 몇 번째 단어인지 return
        // 길이가 1이상 5이하
        // A E I O U 로만 이루어져 있음
        // 각 자리마다 가중치 781, 156, 31, 6

        int[] weights = {781, 156, 31, 6, 1};
        int answer = 0;

        for(int i=0; i<word.length(); i++) {
            answer += "AEIOU".indexOf(word.charAt(i)) * weights[i] + 1;
        }
        return answer;
    }
}