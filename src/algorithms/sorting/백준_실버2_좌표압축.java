package algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 🎯 정렬 문제: 좌표압축 (백준 실버2)
// 💡 좌표를 압축하여 순위로 변환 (정렬 + 해시맵 활용)
// ⚡ 시간복잡도: O(N log N), 공간복잡도: O(N)
public class 백준_실버2_좌표압축 {

    static int[] arr;
    static int[] result;
    static Map<Integer, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];
        hashMap = new HashMap<>(n);

        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr[cnt] = result[cnt++] = Integer.parseInt(st.nextToken());
        }

        // 📝 정렬하여 순위 매핑
        Arrays.sort(arr);

        // 중복 제거하여 좌표 압축
        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], i);
        }

        // 원래 순서대로 압축된 좌표 출력
        for (int j = 0; j < n; j++) {
            arr[j] = hashMap.get(result[j]);
        }

        System.out.println(Arrays.toString(arr));
    }
} 