package algorithms.searching;

import java.io.*;
import java.util.*;

// 🎯 이분탐색 문제: 랜선자르기 (백준 실버2)
// 💡 랜선을 동일한 길이로 잘라서 N개를 만들 수 있는 최대 길이 구하기 (파라메트릭 서치)
// ⚡ 시간복잡도: O(K*log(max)), 공간복잡도: O(K)
public class 백준_실버2_랜선자르기 {

    public static void main(String[] args) throws IOException {
        // 1. 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int existingCount = Integer.parseInt(st.nextToken()); // N
        int requiredCount = Integer.parseInt(st.nextToken()); // K

        long[] cables = new long[existingCount];
        long maxCable = 0;
        for (int i = 0; i < existingCount; i++) {
            cables[i] = Long.parseLong(br.readLine());
            if (cables[i] > maxCable) {
                maxCable = cables[i];
            }
        }

        // 2. 이분 탐색 범위 설정
        long left = 1;            // 최소 자를 수 있는 길이
        long right = maxCable;    // 최대 자를 수 있는 길이
        long answer = 0;          // 정답이 될 수 있는 최대 길이

        // 3. 이분 탐색 반복 (파라메트릭 서치)
        while (left <= right) {
            long mid = (left + right) / 2;
            // mid 길이로 잘랐을 때 몇 개가 나오는지 계산
            long pieces = 0;
            for (long cable : cables) {
                pieces += cable / mid;
            }

            // 원하는 개수 이상이면, mid를 정답 후보로 기록하고 더 긴 길이 시도
            if (pieces >= requiredCount) {
                answer = mid;
                left = mid + 1;
            }
            // 원하는 개수에 못 미치면, 자르는 길이를 줄여야 함
            else {
                right = mid - 1;
            }
        }

        // 4. 결과 출력
        System.out.println(answer);
    }
} 