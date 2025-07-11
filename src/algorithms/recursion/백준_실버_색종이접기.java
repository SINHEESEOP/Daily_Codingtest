package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_실버_색종이접기 {

    static int white = 0;
    static int blue = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
            }
        }
        recursion(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void recursion(int y, int x, int size) {
        if (isUniform(y, x, size)) {
            if (arr[y][x] == 0) white++;
            else blue++;
            return;
        }
        int half = size / 2;
        // 좌상
        recursion(y, x, half);
        // 우상
        recursion(y, x + half, half);
        // 좌하
        recursion(y + half,  x, half);
        // 우하
        recursion(y + half, x + half, half);
    }

    private static boolean isUniform(int y, int x, int size) {
        int con = arr[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != con) {
                    return false;
                }
            }
        }
        return true;
    }

}
