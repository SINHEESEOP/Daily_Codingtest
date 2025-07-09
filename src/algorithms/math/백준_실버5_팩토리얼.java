package algorithms.math;

import java.util.Scanner;

// 🎯 수학 문제: 팩토리얼 (백준 실버5)
// 💡 재귀를 이용한 팩토리얼 계산
// ⚡ 시간복잡도: O(N), 공간복잡도: O(N)
public class 백준_실버5_팩토리얼 {

    static int fact(int n) {
        if (n == 1) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fact(sc.nextInt()));
    }
} 