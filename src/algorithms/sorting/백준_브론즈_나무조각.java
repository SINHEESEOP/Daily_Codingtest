package algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_브론즈_나무조각 {

    static int[] arr = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        while (st.hasMoreTokens()) {
            arr[cnt++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    StringBuilder sb = new StringBuilder();
                    for (int i1 : arr) {
                        sb.append(i1).append(" ");
                    }
                    System.out.println(sb);
                }
            }
        }

    }
}
