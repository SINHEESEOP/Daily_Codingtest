package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 일곱난쟁이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 두 가짜 난쟁이 찾기
        int removeA = 0, removeB = 0;
        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (arr[i] + arr[j]) == 100) {
                    removeA = i;
                    removeB = j;
                    break outer;
                }
            }
        }

        // 선택된 7명 리스트에 담고 정렬
        List<Integer> seven = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i == removeA || i == removeB) continue;
            seven.add(arr[i]);
        }
        Collections.sort(seven);

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int h : seven) {
            bw.write(h + "\n");
        }
        bw.flush();
    }
}

