package algorithms.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_실버_골드바흐의추측 {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 빠른 입력을 처리합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력: 테스트 케이스의 개수 T를 읽습니다.
        int T = Integer.parseInt(br.readLine());

        // 0부터 10000까지의 정수에 대해 소수 여부를 판단하기 위해 에라토스테네스의 체를 사용합니다.
        // isPrime 배열에서 true이면 해당 인덱스의 숫자가 소수임을 의미합니다.
        boolean[] isPrime = sieve(10000);

        // 결과를 효율적으로 출력하기 위해 StringBuilder를 사용합니다.
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수만큼 반복합니다.
        while (T-- > 0) {
            // 각 테스트 케이스에서 짝수 n을 읽어옵니다.
            int n = Integer.parseInt(br.readLine());

            // n/2부터 2까지 내림차순으로 탐색합니다.
            // 이 방식은 두 소수의 차이가 최소가 되는 (즉, 두 소수가 n/2에 가까운) 파티션을 찾기 위한 방법입니다.
            for (int i = n / 2; i >= 2; i--) {
                // i와 n-i가 모두 소수라면 (isPrime[i]와 isPrime[n - i]가 true라면)
                if (isPrime[i] && isPrime[n - i]) {
                    // i와 n-i는 항상 오름차순(즉, i <= n-i)이므로 그대로 출력합니다.
                    sb.append(i).append(" ").append(n - i).append("\n");
                    // 첫 번째로 조건을 만족하는 쌍을 찾으면 반복을 종료합니다.
                    break;
                }
            }
        }
        // 누적된 결과를 한 번에 출력합니다.
        System.out.print(sb);
    }

    /**
     * 에라토스테네스의 체 알고리즘을 사용하여 0부터 n까지의 소수를 판별합니다.
     * @param n 소수 판별을 할 최대 정수
     * @return n+1 크기의 boolean 배열로, 인덱스 i가 true이면 i가 소수임을 의미합니다.
     */
    static boolean[] sieve(int n) {
        // n+1 크기의 배열을 생성
        boolean[] prime = new boolean[n + 1];
        // 모든 값을 true로 초기화합니다.
        Arrays.fill(prime, true);

        // 0과 1은 소수가 아니므로 false로 설정합니다.
        prime[0] = prime[1] = false;

        // 2부터 시작하여 i의 제곱이 n보다 작거나 같은 동안 반복합니다.
        // i가 소수이면, i의 배수들은 소수가 아니므로 false 처리합니다.
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                // i의 제곱부터 시작하여 n까지 i씩 증가하면서 i의 배수를 false 처리합니다.
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}
