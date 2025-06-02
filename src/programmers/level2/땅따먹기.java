package programmers.level2;

public class 땅따먹기 {

    public static void main(String[] args) {
        int result = solution(new int[][]{ {1,2,3,5}, {5,6,7,8}, {4,3,2,1}} );
        System.out.println(result);
    }

    public static int solution(int[][] land) {
        int rows = land.length;
        // dp[i][j]: i행에서 j열을 선택했을 때 얻을 수 있는 최대 점수
        // land 배열을 그대로 갱신하며 dp처럼 사용
        for (int i = 1; i < rows; i++) {
            // 0열을 선택했을 때 이전 행에서 1,2,3열 중 최대치 더하기
            land[i][0] += Math.max(
                    Math.max(land[i - 1][1], land[i - 1][2]),
                    land[i - 1][3]
            );
            // 1열을 선택했을 때 이전 행에서 0,2,3열 중 최대치 더하기
            land[i][1] += Math.max(
                    Math.max(land[i - 1][0], land[i - 1][2]),
                    land[i - 1][3]
            );
            // 2열을 선택했을 때 이전 행에서 0,1,3열 중 최대치 더하기
            land[i][2] += Math.max(
                    Math.max(land[i - 1][0], land[i - 1][1]),
                    land[i - 1][3]
            );
            // 3열을 선택했을 때 이전 행에서 0,1,2열 중 최대치 더하기
            land[i][3] += Math.max(
                    Math.max(land[i - 1][0], land[i - 1][1]),
                    land[i - 1][2]
            );
        }

        // 마지막 행에서 네 개 중 최대값 반환
        int last = rows - 1;
        return Math.max(
                Math.max(land[last][0], land[last][1]),
                Math.max(land[last][2], land[last][3])
        );
    }


}
