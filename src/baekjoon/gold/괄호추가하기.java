package baekjoon.gold;

import java.io.*;

public class 괄호추가하기 {
    static int numCount;       // 숫자의 개수
    static long[] nums;        // 숫자들
    static char[] ops;         // 연산자들
    static long maxResult = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        String expr = br.readLine().trim();

        // 입력 문자열에서 숫자와 연산자 분리
        numCount = (N + 1) / 2;
        nums = new long[numCount];
        ops  = new char[numCount - 1];

        for (int i = 0; i < N; i++) {
            if ((i & 1) == 0) {  // 짝수 인덱스: 숫자
                nums[i / 2] = expr.charAt(i) - '0';
            } else {             // 홀수 인덱스: 연산자
                ops[i / 2] = expr.charAt(i);
            }
        }

        // 0번째 연산자부터 시작, 초기 결과는 nums[0]
        dfs(0, nums[0]);

        System.out.println(maxResult);
    }

    /**
     * @param idx 현재 처리할 연산자의 인덱스
     * @param acc 지금까지 계산된 누적 결과값
     */
    static void dfs(int idx, long acc) {
        // 모든 연산자를 다 사용했으면 결과 갱신
        if (idx >= ops.length) {
            maxResult = Math.max(maxResult, acc);
            return;
        }

        // 1) 괄호 없이 현재 연산자만 적용
        long noParen = compute(acc, ops[idx], nums[idx + 1]);
        dfs(idx + 1, noParen);

        // 2) 다음 연산자와 nums[idx+1], nums[idx+2]를 괄호로 묶어 먼저 계산
        if (idx + 1 < ops.length) {
            long inner = compute(nums[idx + 1], ops[idx + 1], nums[idx + 2]);
            long withParen = compute(acc, ops[idx], inner);
            dfs(idx + 2, withParen);
        }
    }

    // a (op) b 계산기
    static long compute(long a, char op, long b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default:  throw new IllegalArgumentException("Unknown op: " + op);
        }
    }
}
