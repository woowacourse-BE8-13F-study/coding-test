class Solution {
    public String solution(String X, String Y) {
        // 0부터 9까지 숫자의 빈도수를 저장할 배열
        int[] countX = new int[10];
        int[] countY = new int[10];

        // X의 각 숫자 빈도수
        for (int i = 0; i < X.length(); i++) {
            countX[X.charAt(i) - '0']++;
        }

        // Y의 각 숫자 빈도수
        for (int i = 0; i < Y.length(); i++) {
            countY[Y.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            // 두 그룹에서 공통으로 존재하는 최소 개수 구하기
            int commonCount = Math.min(countX[i], countY[i]);

            // 공통 개수만큼 숫자를 반복해서 추가
            for (int j = 0; j < commonCount; j++) {
                sb.append(i);
            }
        }

        // 짝꿍이 존재하지 않는 경우
        if (sb.length() == 0) {
            return "-1";
        }

        // 짝꿍이 0으로만 구성된 경우
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}

