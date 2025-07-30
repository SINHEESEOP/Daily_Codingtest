package datastructures.list.vector.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_실버4_제로 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static int sum;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Integer k = Integer.parseInt(br.readLine());
            if (k == 0) {
                stack.pop();
                continue;
            }
            stack.push(k);
        }

        for (Integer i : stack) {
            sum += i;
        }

        System.out.println(sum);
    }

}
