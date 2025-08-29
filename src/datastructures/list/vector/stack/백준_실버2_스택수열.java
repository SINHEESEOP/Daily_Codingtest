package datastructures.list.vector.stack;

import java.io.*;
import java.util.Stack;

public class 백준_실버2_스택수열 {

    static int N;
    static int sequence = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            while (sequence <= target) {
                stack.push(sequence++);
                sb.append("+\n");
            }

            if (stack.isEmpty() || stack.peek() != target) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}