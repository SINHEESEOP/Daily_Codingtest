package algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_실버_소트인사이트 {

    static char[] arr;
    static char[] copyArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        copyArr  = new char[arr.length];

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

        while (leftPointer <= midIdx && rightPointer <= rightIdx) {
            if (copyArr[leftPointer] <= copyArr[rightPointer]) {
                arr[copyPointer++] = copyArr[rightPointer++];
            } else {
                arr[copyPointer++] = copyArr[leftPointer++];
            }
        }

        while (leftPointer <= midIdx) {
            arr[copyPointer++] = copyArr[leftPointer++];
        }
    }

}
