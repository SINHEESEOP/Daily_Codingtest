package algorithms.math;

import java.util.Scanner;

// 🎯 수학 문제: 피보나치수5 (백준 브론즈2)
// 💡 재귀를 이용한 피보나치 수열 계산
// ⚡ 시간복잡도: O(2^N), 공간복잡도: O(N)
public class 백준_브론즈2_피보나치수5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
} 