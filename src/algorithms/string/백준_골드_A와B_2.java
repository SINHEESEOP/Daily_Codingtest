package algorithms.string;

import java.io.*;

public class 백준_골드_A와B_2 {

    static String S;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());
        br.close();

        dfs(T);

        System.out.println(answer);
    }

    private static void dfs(StringBuilder t) {
        // 이미 정답을 찾았으면 더 이상 탐색하지 않음
        if (answer == 1) return;

        int lenT = t.length();
        // 길이가 같아지면 직접 비교
        if (lenT == S.length()) {
            if (t.toString().equals(S)) {
                answer = 1;
            }
            return;
        }

        // 1) 마지막이 'A' 였다면: 뒤의 A 제거 → 재귀 → 복구
        if (t.charAt(lenT - 1) == 'A') {
            t.deleteCharAt(lenT - 1);
            dfs(t);
            // 복구
            t.insert(lenT - 1, 'A');
        }

        // 2) 첫 글자가 'B' 였다면: 앞의 B 제거 → 뒤집기 → 재귀 → 복구(뒤집기, B 삽입)
        if (answer == 0 && t.charAt(0) == 'B') {
            t.deleteCharAt(0);
            t.reverse();
            dfs(t);
            // 복구: 다시 뒤집고, 앞에 B 삽입
            t.reverse();
            t.insert(0, 'B');
        }
    }
}
