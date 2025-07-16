package datastructures.list.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

public class 에디터_이터레이터없이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Character> left = new LinkedList<>();
        LinkedList<Character> right = new LinkedList<>();

        String initial = br.readLine();
        for (char ch : initial.toCharArray()) {
            left.addLast(ch);
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) right.addFirst(left.removeLast());
                    break;
                case 'D':
                    if (!right.isEmpty()) left.addLast(right.removeFirst());
                    break;
                case 'B':
                    if (!left.isEmpty()) left.removeLast();
                    break;
                case 'P':
                    left.addLast(cmd.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : left) sb.append(ch);
        for (char ch : right) sb.append(ch);
        System.out.println(sb);
    }
}

