package algorithms.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 🎯 백트래킹 문제: 부분수열의합 (백준 실버2)
// 💡 부분수열 중 합이 S가 되는 개수 구하기
// ⚡ 시간복잡도: O(2^N), 공간복잡도: O(N)
public class 백준_실버2_부분수열의합 {

    static int cnt;
    static int N;
    static int S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0, 0);
        System.out.println(cnt);
    }

    // 📝 각 원소를 포함하거나 포함하지 않는 두 가지 선택
    private static void recursion(int index, int sum) {
        if (index == N) return;

        int newSum = sum + arr[index];
        if (newSum == S) cnt++; // 현재 원소를 포함한 부분수열이 목표값

        // 포함하는 경우와 포함하지 않는 경우 모두 탐색
        recursion(index + 1, newSum); // 포함
        recursion(index + 1, sum);    // 미포함
    }
} 