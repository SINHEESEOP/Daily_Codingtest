package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 🎯 분할정복 문제: Z (백준 골드2)
// 💡 2^N x 2^N 배열을 4분면으로 나누어 Z순서로 방문할 때의 순서 구하기
// ⚡ 시간복잡도: O(N), 공간복잡도: O(N)
public class 백준_골드2_Z {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(z(c, r, n));
    }

    private static int z(int c, int r, int n) {
        if (n == 0) return 0;

        int half = (int) Math.pow(2, n - 1);
        int size = half * half;

        // 1분면
        if (c < half && r < half) {
            return z(c, r, n - 1);
        // 2분면
        } else if (c >= half && r < half) {
            return size + z(c - half, r, n - 1);
        // 3분면
        } else if (c < half && r >= half) {
            return 2 * size + z(c, r - half, n - 1);
        // 4분면
        } else {
            return 3 *  size + z(c - half, r - half, n - 1);
        }
    }

    /*
     * 📝 분할정복 접근법:
     * 1. 2^N x 2^N 배열을 4분면으로 분할
     * 2. 목표 위치가 어느 분면에 있는지 판단
     * 3. 해당 분면의 시작 값에 재귀 결과를 더함
     * 4. half: 한 면의 반, size: 한 분면의 총 칸 수
     */
} 