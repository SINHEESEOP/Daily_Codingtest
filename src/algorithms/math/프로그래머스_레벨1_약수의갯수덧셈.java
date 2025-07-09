package programmers.level1;

import java.util.stream.IntStream;

public class 약수의갯수덧셈 {

    public static void main(String[] args) {

        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
        System.out.println(solution(1, 1));

    }

    private static int solution(int left, int right) {
        return IntStream.rangeClosed(left, right)
                .map(i -> isDivisorCountEven(i) ? i : -i)
                .sum();
    }

    private static boolean isDivisorCountEven(int n) {
        long count = IntStream.rangeClosed(1, n)
                .filter(j -> n % j == 0)
                .count();
        return count % 2 == 0;
    }

}
