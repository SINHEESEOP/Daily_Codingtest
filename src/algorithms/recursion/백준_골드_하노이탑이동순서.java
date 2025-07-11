package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_골드_하노이탑이동순서 {

    private static int cnt;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hanoi(Integer.parseInt(br.readLine()), "1", "2", "3");
        System.out.println(cnt + "\n" + sb);
    }

    private static void hanoi(int n, String start, String temp, String end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            cnt++;
            return;
        }

        hanoi(n - 1, start, end, temp);
        sb.append(start).append(" ").append(end).append("\n");
        cnt++;
        hanoi(n - 1, temp, start , end);
    }

}
