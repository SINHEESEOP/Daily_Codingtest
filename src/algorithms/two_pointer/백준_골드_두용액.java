package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class 두용액 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int bestSum = 2_100_000_000;
        int bestLeft = 0, bestRight = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            if (absSum < bestSum) {
                bestSum = absSum;
                bestRight = right;
                bestLeft = left;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }

            if (absSum == 0) {
                break;
            }

        }

        System.out.println(arr[bestLeft] + " " + arr[bestRight]);
    }

}
