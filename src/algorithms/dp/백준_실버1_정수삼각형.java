package algorithms.dp;

import java.util.Scanner;

// 🎯 DP 문제: 정수삼각형 (백준 실버1)
// 💡 삼각형 꼭대기에서 바닥까지 내려가면서 얻을 수 있는 최대 합
// ⚡ 시간복잡도: O(N²), 공간복잡도: O(N²)
public class 백준_실버1_정수삼각형 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        // 삼각형 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        // 첫 줄 초기화
        dp[0][0] = triangle[0][0];

        // DP로 최대 합 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        // 마지막 줄에서 최대값 찾기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        System.out.println(answer);
    }
}

