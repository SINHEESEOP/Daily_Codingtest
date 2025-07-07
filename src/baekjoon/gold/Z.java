package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {

    static int index;
    static int[][] table;
    static int tableX;
    static int tableY;

    // 공간초과 -- 미리 만들지 말고 만들면서 진행해야함.
    // 항상 메모리나 시간을 봐야하며, 근데 애초에 최대값 나오면 만들면서 가도 문제가 되는데... 정답을 보자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int exponent = (int) Math.pow(2, Integer.parseInt(st.nextToken()));

        table = new int[exponent][exponent];
        tableX = Integer.parseInt(st.nextToken());
        tableY = Integer.parseInt(st.nextToken());

        recursion(0, 0, exponent);
    }

    private static void recursion(int x, int y, int size) {
        if (size == 1) {
            table[x][y] = index++;
            if (tableX == x && tableY == y) {
                System.out.println(table[x][y]);
            }
            return;
        }

        int half = size / 2;

        recursion(x, y, half);
        recursion(x, y + half, half);
        recursion(x + half, y, half);
        recursion(x + half, y + half, half);
    }

}
