package algorithms.dp;

import java.util.Scanner;

public class 백준_실버_타일장식물 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        long[] fib = new long[N + 2];  // F(N+1)까지 필요하므로 N+2 크기
        fib[1] = 1;
        fib[2] = 1;

        for (int i = 3; i <= N + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        long perimeter = 2 * (fib[N] + fib[N + 1]);
        System.out.println(perimeter);
    }

}
