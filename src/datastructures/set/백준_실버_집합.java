package baekjoon.silver;

import java.io.*;
import java.util.*;

public class 집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int S = 0; // 비트마스크로 집합 구현 (1~20)

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "add":
                    S |= (1 << (x - 1));
                    break;
                case "remove":
                    S &= ~(1 << (x - 1));
                    break;
                case "check":
                    sb.append(((S & (1 << (x - 1))) != 0) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    S ^= (1 << (x - 1));
                    break;
                case "all":
                    S = (1 << 20) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}

