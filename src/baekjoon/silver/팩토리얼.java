package baekjoon.silver;

import java.util.Scanner;

public class 팩토리얼 {

    static int fact(int n) {
        if (n == 1) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(fact(sc.nextInt()));
    }


}
