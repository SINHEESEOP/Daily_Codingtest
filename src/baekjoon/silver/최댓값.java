package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최댓값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            int a = Integer.parseInt(br.readLine());

            if (max < a) {
                max = a;
                cnt = i;
            }
        }

        System.out.println(max);
        System.out.println(cnt + 1);
    }
}
