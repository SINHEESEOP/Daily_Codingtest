package algorithms.dp;

import java.util.Scanner;

public class 백준_브론즈_Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fibonacci(sc.nextInt()));
    }

    private static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
