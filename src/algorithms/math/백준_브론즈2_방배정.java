package algorithms.math;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_브론즈2_방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][6];  // 0: 여, 1: 남, 열은 학년 (1~6)

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());  // 성별
            int y = Integer.parseInt(st.nextToken()) - 1;  // 학년(0-based)
            arr[s][y]++;
        }

        int answer = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                answer += (arr[i][j] + k - 1) / k;
            }
        }

        System.out.println(answer);
    }
}
