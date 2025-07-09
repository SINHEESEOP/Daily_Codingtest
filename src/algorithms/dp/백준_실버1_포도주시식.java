package algorithms.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 🎯 DP 문제: 포도주시식 (백준 실버1)
// 💡 연속으로 3잔은 마실 수 없는 조건에서 최대 포도주 양 구하기
// ⚡ 시간복잡도: O(N), 공간복잡도: O(N)
public class 백준_실버1_포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (N >= 1) {
            dp[1] = wine[1];
        }
        if (N >= 2) {
            dp[2] = wine[1] + wine[2];
        }

        for (int i = 3; i <= N; i++) {
            // 1) i번째 잔을 마시지 않는 경우
            int skip = dp[i - 1];
            // 2) 연속 1잔 마시고 i번째 잔 마시는 경우
            int takeOne = dp[i - 2] + wine[i];
            // 3) 연속 2잔 마시고 i번째 잔 마시는 경우
            int takeTwo = dp[i - 3] + wine[i - 1] + wine[i];

            dp[i] = Math.max(skip, Math.max(takeOne, takeTwo));
        }

        System.out.println(dp[N]);
        br.close();
    }
}
