package algorithms.dp;

import java.io.*;
import java.util.*;

public class 백준_골드5_내려가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dpMax[prv][j], dpMin[prv][j] 에 이전 줄의 최대/최소 누적합을 저장
        int[][] dpMax = new int[2][3];
        int[][] dpMin = new int[2][3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 첫째 줄 초기화
        for (int j = 0; j < 3; j++) {
            int v = Integer.parseInt(st.nextToken());
            dpMax[0][j] = v;
            dpMin[0][j] = v;
        }

        int prv = 0, cur = 1;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 열 0: 왼쪽 위, 위에서만
            dpMax[cur][0] = Math.max(dpMax[prv][0], dpMax[prv][1]) + a;
            dpMin[cur][0] = Math.min(dpMin[prv][0], dpMin[prv][1]) + a;

            // 열 1: 왼쪽 위, 위, 오른쪽 위 모두 가능
            dpMax[cur][1] = Math.max(
                    Math.max(dpMax[prv][0], dpMax[prv][1]),
                    dpMax[prv][2]
            ) + b;
            dpMin[cur][1] = Math.min(
                    Math.min(dpMin[prv][0], dpMin[prv][1]),
                    dpMin[prv][2]
            ) + b;

            // 열 2: 위, 오른쪽 위에서만
            dpMax[cur][2] = Math.max(dpMax[prv][1], dpMax[prv][2]) + c;
            dpMin[cur][2] = Math.min(dpMin[prv][1], dpMin[prv][2]) + c;

            // 다음 줄을 위해 swap
            int tmp = prv; prv = cur; cur = tmp;
        }

        // 마지막 줄(prv)에 저장된 값 중 최대/최소
        int maxAns = Math.max(
                Math.max(dpMax[prv][0], dpMax[prv][1]),
                dpMax[prv][2]
        );
        int minAns = Math.min(
                Math.min(dpMin[prv][0], dpMin[prv][1]),
                dpMin[prv][2]
        );

        System.out.println(maxAns + " " + minAns);
    }
}

