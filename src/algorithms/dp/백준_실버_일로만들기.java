package algorithms.dp;

import java.util.Scanner;

// DP 기출문제_ 1로 만들기 _ 백준 실버문제
// 30분 시간초과
public class 백준_실버_일로만들기 {

    public static void main(String[] args) {

//        for (int i = 1; i <= 12; i++) {
//            System.out.print(solution(i) + ", ");
//        }
        Scanner sc = new Scanner(System.in);

//        나의 풀이
        System.out.println(solution(sc.nextInt()));

//        정답풀이
        System.out.println(solution2(sc.nextInt()));
    }

    private static int solution2(int n) {

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 뺀값
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 1을 뺀값과 2로 나눈값준 최솟값
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // (1을 뺀 값과 2로 나눈 값중 최솟값) 과 3으로 나눈값중 최솟값
            }
        }

        return dp[n];
    }

    // 틀렸던 나의 풀이
    public static int solution(int n) {

        int[] dp = new int[n + 1];

        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 1;

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < dp.length; i++) {

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp[n];
    }


}
