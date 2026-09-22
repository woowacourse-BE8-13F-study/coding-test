class Solution {
    int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public String solution(int a, int b) {
        int days = b;

        for (int i = 0; i < a - 1; i++) {
            days += month[i];
        }

        return day[(days + 4) % 7];
    }
}
