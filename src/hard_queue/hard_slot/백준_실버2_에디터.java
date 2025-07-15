package hard_queue.hard_slot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class 백준_실버2_에디터 {

    static LinkedList<String> str = new LinkedList<>();
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] arr = br.readLine().split("");
        str.addAll(Arrays.asList(arr));

        index = str.size();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (s.length() > 1) {
                st = new StringTokenizer(s);
                st.nextToken();
                while (st.hasMoreTokens()) {
                    str.add(index, st.nextToken());
                    index++;
                }
                continue;
            }


            switch (s) {
                case "L": {
                    if (index != 0) index--;
                    break;
                }
                case "D": {
                    if (index != str.size()) index++;
                    break;
                }
                case "B": {
                    if (index != 0) {
                        str.remove(index - 1);
                        index--;
                    }
                    break;
                }
            }
        }
        str.forEach(System.out::print);
    }

    public class 에디터_정답 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> cursor = list.listIterator();

            for (char ch : br.readLine().toCharArray()) {
                cursor.add(ch);
            }

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                if (s.charAt(0) == 'L') {
                    if (cursor.hasPrevious()) cursor.previous();
                } else if (s.charAt(0) == 'D') {
                    if (cursor.hasNext()) cursor.next();
                } else if (s.charAt(0) == 'B') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else { // 'P x'
                    char ch = s.charAt(2);
                    cursor.add(ch);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : list) sb.append(ch);
            System.out.println(sb);
        }

    }

}
