package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 소수찾기 {

    public static void main(String[] args) throws IOException {
        // 빠른 입력 처리를 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄의 숫자 개수 읽기
        int n = Integer.parseInt(br.readLine());
        // 두 번째 줄에 있는 숫자들을 StringTokenizer로 분리
        StringTokenizer st = new StringTokenizer(br.readLine());

        int primeCount = 0;
        while (n-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            if (isPrime(number)) {
                primeCount++;
            }
        }

        // 소수의 개수 출력
        System.out.println(primeCount);
    }

    // number가 소수인지 판별하는 함수 (2부터 √number 까지 확인)
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
