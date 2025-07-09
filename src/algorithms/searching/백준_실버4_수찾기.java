package algorithms.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

// 🎯 이분탐색 문제: 수찾기 (백준 실버4)
// 💡 정렬된 배열에서 특정 수의 존재 여부 확인
// ⚡ 시간복잡도: O(N log N + M log N), 공간복잡도: O(N)
public class 백준_실버4_수찾기 {

    static int N;
    static int M;
    static List<Integer> arrList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arrList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrList.add(Integer.parseInt(st.nextToken()));
        }

        // 📝 이분탐색을 위한 정렬
        Collections.sort(arrList);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());

            // 📝 Collections.binarySearch 활용
            if (Collections.binarySearch(arrList, a) < 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }
} 