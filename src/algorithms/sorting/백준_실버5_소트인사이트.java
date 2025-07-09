package algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 🎯 정렬 문제: 소트인사이트 (백준 실버5)
// 💡 문자열의 각 자릿수를 내림차순으로 정렬 (머지 정렬 구현)
// ⚡ 시간복잡도: O(N log N), 공간복잡도: O(N)
public class 백준_실버5_소트인사이트 {

    static char[] arr;
    static char[] copyArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        copyArr = new char[arr.length];

        // 📝 머지 정렬로 내림차순 정렬
        sort(0, arr.length - 1);

        StringBuilder sb = new StringBuilder();
        for (char i : arr) {
            sb.append(i);
        }
        System.out.println(sb);
    }

    private static void sort(int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) return;

        int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
        sort(leftIdx, midIdx);
        sort(midIdx + 1, rightIdx);
        merge(leftIdx, midIdx, rightIdx);
    }

    private static void merge(int leftIdx, int midIdx, int rightIdx) {
        int leftPointer = leftIdx;
        int rightPointer = midIdx + 1;
        int copyPointer = leftIdx;

        for (int i = leftIdx; i <= rightIdx; i++) {
            copyArr[i] = arr[i];
        }

        // 📝 내림차순 정렬: 더 큰 값을 앞에 배치
        while (leftPointer <= midIdx && rightPointer <= rightIdx) {
            if (copyArr[leftPointer] >= copyArr[rightPointer]) {
                arr[copyPointer++] = copyArr[leftPointer++];
            } else {
                arr[copyPointer++] = copyArr[rightPointer++];
            }
        }

        while (leftPointer <= midIdx) {
            arr[copyPointer++] = copyArr[leftPointer++];
        }
    }
} 