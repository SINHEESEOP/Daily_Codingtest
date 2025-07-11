package algorithms.math;

import java.util.Arrays;

public class 프로그래머스_레벨1_행렬의덧셈 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}})));
    }

    private static int[][] solution(int[][] ints1, int[][] ints2) {


        for (int i = 0; i < ints1.length; i++) {
            for (int j = 0; j < ints1[i].length; j++) {
                ints1[i][j] = ints1[i][j] + ints2[i][j];
            }
        }

        return ints1;
    }

}
