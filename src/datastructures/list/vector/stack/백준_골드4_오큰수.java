package datastructures.list.vector.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_골드4_오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[i] <= stack.peek()) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans[i]);
            if (i + 1 < n) sb.append(" ");
        }
        System.out.println(sb);
    }

}
