package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축 {

    static int[] arr;
    static int[] result;
    static Map<Integer, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr =  new int[n];
        result = new int[n];
        hashMap = new HashMap<>(n);

        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) arr[cnt] = result[cnt++] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], i);
        }

        for (int j = 0; j < n; j++) {
            arr[j] =  hashMap.get(result[j]);
        }

        System.out.println(Arrays.toString(arr));
    }

}

