package algorithms.recursion;

import java.io.*;

public class 백준_골드_별찍기10 {
    
    static char[][] canvas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        canvas = new char[n][n];

        // 초기화: 공백으로 채움
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                canvas[i][j] = ' ';
            }
        }

        // 재귀로 별 그리기
        drawStars(0, 0, n);

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(canvas[i]);
            bw.newLine();
        }
        bw.flush();
    }

    private static void drawStars(int y, int x, int size) {
        if (size == 1) {
            canvas[y][x] = '*';
            return;
        }

        int half = size / 3;

        // 상(좌,중,우)
        drawStars(y, x, half);
        drawStars(y, x + half, half);
        drawStars(y, x + half * 2, half);

        // 중(좌,우)
        drawStars(y + half, x, half);
        drawStars(y + half, x + half * 2, half);

        // 하(좌,중,우)
        drawStars(y + half * 2, x, half);
        drawStars(y + half * 2, x + half, half);
        drawStars(y  + half * 2, x + half * 2, half);

    }
}

