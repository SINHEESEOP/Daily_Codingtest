package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 🎯 재귀 문제: 하노이탑이동순서 (백준 골드5)
// 💡 재귀로 하노이탑 이동 과정 출력하기
// ⚡ 시간복잡도: O(2^N), 공간복잡도: O(N)
public class 백준_골드5_하노이탑이동순서 {

    private static int cnt;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hanoi(Integer.parseInt(br.readLine()), "1", "2", "3");
        System.out.println(cnt + "\n" + sb);
    }

    // 📝 하노이탑 재귀: n개 원판을 start에서 end로 이동
    private static void hanoi(int n, String start, String temp, String end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            cnt++;
            return;
        }

        // 위쪽 n-1개를 보조 기둥으로 이동
        hanoi(n - 1, start, end, temp);
        // 가장 큰 원판을 목표 기둥으로 이동
        sb.append(start).append(" ").append(end).append("\n");
        cnt++;
        // 보조 기둥의 n-1개를 목표 기둥으로 이동
        hanoi(n - 1, temp, start, end);
    }
} 