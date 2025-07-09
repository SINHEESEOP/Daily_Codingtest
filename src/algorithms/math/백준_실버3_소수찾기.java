package algorithms.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 🎯 수학 문제: 소수찾기 (백준 실버3)
// 💡 주어진 수들 중 소수의 개수 구하기
// ⚡ 시간복잡도: O(N * √M), 공간복잡도: O(1)
public class 백준_실버3_소수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int primeCount = 0;
        while (n-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            if (isPrime(number)) {
                primeCount++;
            }
        }

        System.out.println(primeCount);
    }

    // 📝 소수 판별: 2부터 √number 까지 확인
    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
} 