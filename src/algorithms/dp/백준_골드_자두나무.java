package algorithms.dp;

import java.io.*;
import java.util.*;

public class 백준_골드_자두나무 {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());  // 총 시간 (초)
        int W = Integer.parseInt(st.nextToken());  // 최대 이동 횟수

        int[] fall = new int[T + 1];
        for (int t = 1; t <= T; t++) {
            fall[t] = Integer.parseInt(br.readLine());
        }

        // dp[w] : 이번 초에 이동 w번 했을 때 누적 최댓값
        // prev[w] : 전 초의 값
        int[] dp   = new int[W + 1];
        int[] prev = new int[W + 1];

        // 시간 1초 처리 (초기화)
        // w=0 이면 1번 나무 아래, w=1 이면 2번 나무 아래...
        for (int w = 0; w <= W; w++) {
            int pos = (w % 2 == 0 ? 1 : 2);
            prev[w] = (fall[1] == pos ? 1 : 0);
        }

        // 2초부터 T초까지 DP 갱신
        for (int t = 2; t <= T; t++) {
            // w=0 처리 (이동 없이 같은 나무)
            dp[0] = prev[0] + (fall[t] == 1 ? 1 : 0);

            // w=1..W 처리
            for (int w = 1; w <= W; w++) {
                int pos = (w % 2 == 0 ? 1 : 2);
                int got = (fall[t] == pos ? 1 : 0);
                // 이동하지 않거나, t-1초에 이동했을 때
                dp[w] = Math.max(prev[w], prev[w - 1]) + got;
            }

            // prev에 복사
            System.arraycopy(dp, 0, prev, 0, W + 1);
        }

        // 정답: 마지막 초에 w=0..W 중 최댓값
        int answer = 0;
        for (int w = 0; w <= W; w++) {
            answer = Math.max(answer, prev[w]);
        }

        System.out.println(answer);
    }
}

