package datastructures.list.vector.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_실버2_쇠막대기 {

    static int stick;
    static int result;
    static Stack<Character> stack = new Stack<>();
    // ()(((()())(())()))(())

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char prev = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                prev = c;
            } else {
                if (prev == '(') {
                    stack.pop();
                    prev = c;
                    result += stack.size();
                } else {
                    stack.pop();
                    result++;
                }
             }
        }
        System.out.println(result);
    }

}
