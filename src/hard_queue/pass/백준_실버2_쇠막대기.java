package hard_queue.pass;

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
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stick++;
                result++;
                stack.push(c);
            } else if (c == ')') {
                stick--;
                result--;
                result += stick;
            }
        }
        System.out.println(result);
    }

}
