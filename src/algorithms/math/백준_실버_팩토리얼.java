package algorithms.math;

import java.util.Scanner;

public class 백준_실버_팩토리얼 {

    static int fact(int n) {
        if (n == 1) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(fact(sc.nextInt()));
    }


}
