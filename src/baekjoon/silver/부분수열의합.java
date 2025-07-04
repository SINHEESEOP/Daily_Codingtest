package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 부분수열의합 {

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

    private static void recursion(int index, int sum) {
        if (index == N) return;

        int newSum = sum + arr[index];
        if (newSum == S) cnt++;

        recursion(index + 1, newSum);
        recursion(index + 1, sum);

    }


}
