package algorithms.math;

import java.util.Scanner;

public class 백준_브론즈_팩토리얼 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));


    }

    static int factorial(int n) {
        if (n == 1) return 1;
        if (n == 0) return 1;

        return factorial(n - 1) * n;
    }
}
