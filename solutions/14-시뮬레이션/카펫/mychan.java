class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int h=3; h <= total; h++) {
            if (total % h != 0) continue;
            int w = total / h;
            if (w < h) continue;

            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }
        }
        return new int[]{};

    }
}