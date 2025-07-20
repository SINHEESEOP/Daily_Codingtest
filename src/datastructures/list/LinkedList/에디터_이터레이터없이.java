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
                // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                case 'L':
                    if (!left.isEmpty()) right.addFirst(left.removeLast());
                    break;
                // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                case 'D':
                    if (!right.isEmpty()) left.addLast(right.removeFirst());
                    break;
                // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                case 'B':
                    if (!left.isEmpty()) left.removeLast();
                    break;
                // $라는 문자를 커서 왼쪽에 추가함
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

