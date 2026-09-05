import java.util.*;

class Solution {

    static int answer;
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    static int dungeon_num;
    static List<int[]> allPermutations = new ArrayList<>();


    public int solution(int k, int[][] dungeons) {
        answer = -1;
        dungeon_num = dungeons.length;
        arr = new int[dungeon_num];
        result = new int[dungeon_num];
        visited = new boolean[dungeon_num];
        for(int i = 0; i < dungeon_num; i++) {
            arr[i] = i;
        }

        recur(0);

        for(int[] p : allPermutations) {
            int energy = k;
            int i;
            for(i = 0; i < p.length; i++) {
                int ordered_num = p[i];
                int minimumEnergy = dungeons[ordered_num][0];
                int usedEnergy = dungeons[ordered_num][1];
                if (!canEnter(energy, minimumEnergy, usedEnergy)) {
                    break;
                }
                energy = energy - usedEnergy;
            }
            answer = i > answer ? i : answer;
        }

        return answer;
    }

    private boolean canEnter(int energy, int minimumEnergy, int usedEnergy) {
        if(energy < minimumEnergy) {
            return false;
        }
        if(energy - usedEnergy < 0) {
            return false;
        }
        return true;
    }

    private void recur(int depth) {
        if(depth == dungeon_num) {
            allPermutations.add(result.clone());
            return;
        }

        for(int i = 0; i < dungeon_num; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];

                recur(depth + 1);

                visited[i] = false;
            }
        }
    }
}
