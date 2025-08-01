package datastructures.list.vector.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 백준_실버2_스택수열 {

    static int N;
    static int[] K;
    static int sequence = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = new int[N];
        for (int i = 0; i < N; i++) {
            K[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        while (idx < N) {

            if (!stack.isEmpty() && K[idx] == stack.peek()) {
                stack.pop();
                sb.append("-\n");
                idx++;
                continue;
            }

            if (sequence > N) {
                System.out.println("NO");
                return;
            }

            stack.push(sequence++);
            sb.append("+\n");
        }

        System.out.println(sb);
    }
}
