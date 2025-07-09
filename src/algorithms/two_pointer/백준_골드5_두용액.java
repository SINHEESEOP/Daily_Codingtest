package algorithms.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

// 🎯 투포인터 문제: 두용액 (백준 골드5)
// 💡 정렬된 배열에서 두 수의 합이 0에 가장 가까운 조합 찾기
// ⚡ 시간복잡도: O(N log N), 공간복잡도: O(1)
public class 백준_골드5_두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 📝 투포인터를 위한 정렬
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int bestSum = 2_100_000_000;
        int bestLeft = 0, bestRight = 0;

        // 📝 양 끝에서 시작하여 0에 가장 가까운 합 찾기
        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            if (absSum < bestSum) {
                bestSum = absSum;
                bestRight = right;
                bestLeft = left;
            }

            if (sum > 0) {
                right--; // 합이 양수면 더 작은 값으로
            } else {
                left++;  // 합이 음수면 더 큰 값으로
            }

            if (absSum == 0) {
                break; // 정확히 0이면 최적해
            }
        }

        System.out.println(arr[bestLeft] + " " + arr[bestRight]);
    }
} 