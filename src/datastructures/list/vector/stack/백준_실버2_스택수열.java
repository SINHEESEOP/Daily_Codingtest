package datastructures.list.vector.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 백준_실버2_스택수열 {

    static int N;
    static int K;
    static int sequence;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static List<String> result;

    // 문제 해결 논리는 맞음. 정확한 출력이나, NO 분기는 없지만 추가하는게 어렵지 않음
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        result = new ArrayList<>();

        stack.push(++sequence);
        result.add("+");

        while (!stack.isEmpty()) {

            if (K == stack.peek()) {
                stack.pop();
                result.add("-");
                // 문제가 생기는 부분 //힌트로 백준 입력 조건예시 1번 잘보면됨
                K = Integer.parseInt(br.readLine());
            } else if (sequence != N) {
                stack.push(++sequence);
                result.add("+");
            } else {
                break;
            }

        }

        System.out.println(result.toString());
    }

    public class 스택수열_정답 {

        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();

                int n = Integer.parseInt(br.readLine());
                int[] sequence = new int[n];
                for (int i = 0; i < n; i++) {
                    sequence[i] = Integer.parseInt(br.readLine());
                }

                Stack<Integer> stack = new Stack<>();
                int num = 1, idx = 0;

                while (idx < n) {
                    // 원하는 값이 stack의 top에 있다면 pop
                    if (!stack.isEmpty() && stack.peek() == sequence[idx]) {
                        stack.pop();
                        sb.append("-\n");
                        idx++;
                        continue;
                    }

                    // 더 이상 push할 수가 없고 pop도 불가능하다면 NO
                    if (num > n) {
                        System.out.println("NO");
                        return;
                    }

                    // 원하는 값이 아니면 push
                    stack.push(num++);
                    sb.append("+\n");
                }

                System.out.print(sb);
            }
        }

    }
}
