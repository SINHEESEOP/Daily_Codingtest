package algorithms.math;

import java.util.stream.IntStream;

// 🎯 수학 문제: 내적 (프로그래머스 레벨1)
// 💡 두 벡터의 내적(dot product) 계산
// ⚡ 시간복잡도: O(N), 공간복잡도: O(1)
public class 프로그래머스_레벨1_내적 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};
        System.out.println(solution(a, b));
    }

    private static int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                .map(i -> a[i] * b[i])
                .sum();
    }
} 