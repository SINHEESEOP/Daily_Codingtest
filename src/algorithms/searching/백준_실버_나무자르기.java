package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 랜선 자르기와 나무자르기 한번씩 내일 더풀기.
public class 나무자르기 {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int maxTree = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxTree = Math.max(maxTree, arr[i]);
        }

        int left = 0;
        int right = maxTree;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long cut = 0;
            for (int height : arr) {
                if (height > mid) {
                    cut += height - mid;
                }
            }

            if (cut >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
