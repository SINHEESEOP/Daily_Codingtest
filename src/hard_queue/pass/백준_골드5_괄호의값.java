package hard_queue.pass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_골드5_괄호의값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        String input = br.readLine();
        char prev = 0;
        int result = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                charStack.push(c);
                intStack.push(2);
            } else if (c == ')') {
                charStack.pop();
                result *= intStack.pop();
            }
        }

    }

}
