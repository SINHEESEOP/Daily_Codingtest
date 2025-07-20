package algorithms.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class 백준_실버2_키로거 {

    static List<String> keyList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            keylogger(br.readLine());
        }

        for (int i = 0; i < keyList.size(); i++) {
            System.out.println(keyList.get(i));
        }
    }

    private static void keylogger(String input) {
        List<Character> list = new LinkedList<>();
        ListIterator<Character> iterator = list.listIterator();

        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                if (iterator.hasPrevious()) iterator.previous();
            } else if (ch == '>') {
                if (iterator.hasNext()) iterator.next();
            } else if (ch == '-') {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else {
                iterator.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }

        keyList.add(sb.toString());
    }

    public class 이터레이터안쓰고{

        static List<String> keyList2 = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                keylogger2(br.readLine());
            }

            for (int i = 0; i < keyList2.size(); i++) {
                System.out.println(keyList2.get(i));
            }
        }

        private static void keylogger2(String input) {
            List<Character> left = new LinkedList<>();
            List<Character> right = new LinkedList<>();

            for (char ch : input.toCharArray()) {

                if (ch == '<') {
                    if (!left.isEmpty()) right.addFirst(left.removeLast());
                } else if (ch == '>') {
                    if (!right.isEmpty()) left.addLast(right.removeFirst());
                } else if (ch == '-') {
                    if (!left.isEmpty()) left.removeLast();
                } else {
                    left.add(ch);
                }

            }

            StringBuilder sb = new StringBuilder();
            for (char ch : left) sb.append(ch);
            for (char ch : right) sb.append(ch);
            keyList2.add(sb.toString());
        }

    }

}
