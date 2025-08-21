package hard_queue.pass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.Deque;

public class 백준_골드5_괄호의값 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        Deque<Character> st = new ArrayDeque<>();
        int ans = 0;     // 누적 결과
        int mul = 1;     // 현재 중첩 배수 ( '(' -> ×2, '[' -> ×3 )
        char prev = 0;   // 직전 문자로 "()" 또는 "[]" 즉시 가산 판단

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
                mul *= 2;
                prev = c;
            } else if (c == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if (prev == '(') ans += mul;
                prev = c;
                st.pop();
                mul /= 2;
            } else if (c == '[') {
                st.push(c);
                mul *= 3;
                prev = c;
            } else if (c == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (prev == '[') ans += mul;
                prev = c;
                st.pop();
                mul /= 3;
            }
        }
        System.out.println(st.isEmpty() ? ans : 0);
    }
}

