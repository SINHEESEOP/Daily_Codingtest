package algorithms.string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 프로그래머스_레벨1_수박수박수박수 {

    public static void main(String[] args) {
        System.out.println(solution(5));
    }


    public static String solution(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> (i % 2 == 0) ? "수" : "박")
                .collect(Collectors.joining());
    }

}
