package algorithms.dp;

import java.util.Scanner;

// 🎯 DP 문제: 퇴사 (백준 실버3)
// 💡 상담 일정이 주어졌을 때 퇴사 전까지 얻을 수 있는 최대 수익
// ⚡ 시간복잡도: O(N), 공간복잡도: O(N)
public class 백준_실버3_퇴사 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] t = new int[n + 2];  // t[i]: i일 째에 상담에 걸리는 기간
        int[] p = new int[n + 2];  // p[i]: i일 째에 받을 수 있는 보수
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int[] dp = new int[n + 2];
        // 📝 역방향 DP: 마지막 날(N)부터 1일째로 거슬러 오며 dp 채우기
        for (int i = n; i >= 1; i--) {
            // 상담을 선택할 수 있는 경우 (퇴사일 이전에 끝나는 상담)
            if (i + t[i] <= n + 1) {
                dp[i] = Math.max(
                        p[i] + dp[i + t[i]],  // 오늘 상담을 선택했을 때
                        dp[i + 1]             // 오늘 상담을 건너뛰었을 때
                );
            } else {
                // 기간이 범위를 벗어나면 오늘 상담은 불가능
                dp[i] = dp[i + 1];
            }
        }

        // 1일째부터 벌 수 있는 최대 이익
        System.out.println(dp[1]);
        sc.close();
    }
} 