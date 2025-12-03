package algorithms.hash;

import java.io.*;
import java.util.*;

// 🎯 자료구조 문제: 집합 (백준 실버5)
// 💡 비트마스킹을 이용한 집합 연산 구현
// ⚡ 시간복잡도: O(M), 공간복잡도: O(1)
public class 백준_실버5_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int S = 0; // 📝 비트마스크로 집합 구현 (1~20)

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "add":
                    S |= (1 << (x - 1)); // 📝 x번째 비트를 1로 설정
                    break;
                case "remove":
                    S &= ~(1 << (x - 1)); // 📝 x번째 비트를 0으로 설정
                    break;
                case "check":
                    sb.append(((S & (1 << (x - 1))) != 0) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    S ^= (1 << (x - 1)); // 📝 x번째 비트 반전
                    break;
                case "all":
                    S = (1 << 20) - 1; // 📝 모든 비트를 1로 설정
                    break;
                case "empty":
                    S = 0; // 📝 모든 비트를 0으로 설정
                    break;
            }
        }

        System.out.print(sb);
    }
} 