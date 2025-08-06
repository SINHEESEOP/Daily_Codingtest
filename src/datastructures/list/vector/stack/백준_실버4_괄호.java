package datastructures.list.vector.stack;

import java.io.*;
import java.util.*;

public class 백준_실버4_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean valid = true;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            sb.append((valid && stack.isEmpty()) ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }

    public class 괄호_정답 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());
            while (T-- > 0) {
                String s = br.readLine();
                Stack<Character> stack = new Stack<>();
                boolean valid = true;

                for (char c : s.toCharArray()) {
                    if (c == '(') {
                        stack.push(c);
                    } else {
                        if (stack.isEmpty()) {
                            valid = false;
                            break;
                        }
                        stack.pop();
                    }
                }

                sb.append((valid && stack.isEmpty()) ? "YES" : "NO").append('\n');
            }

            System.out.print(sb);
        }
    }
}
