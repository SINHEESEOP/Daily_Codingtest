package programmers.level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 수박수박수박수 {

    public static void main(String[] args) {
        System.out.println(solution(5));
    }


    public static String solution(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> (i % 2 == 0) ? "수" : "박")
                .collect(Collectors.joining());
    }

}
