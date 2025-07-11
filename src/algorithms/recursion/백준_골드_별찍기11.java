package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_골드_별찍기11 {

    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int width = n * 2 - 1;
        star = new char[n][width];

        writerStar(n, width / 2, 0);
        StringBuilder sb = new StringBuilder();
        for (char[] chars : star) {
            for (char aChar : chars) {
                sb.append(aChar == 0 ? ' ' : aChar);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void writerStar(int n, int y, int x) {
        if (n == 3) {
            star[x][y] = '*';
            star[x + 1][y - 1] = '*';
            star[x + 1][y + 1] = '*';
            for (int i = -2; i <= 2; i++) {
                star[x + 2][y - i] = '*';
            }
            return;
        }

        int half = n / 2;

        writerStar(half, y, x);
        writerStar(half, y - half, x + half);
        writerStar(half, y + half, x + half);
    }

}
