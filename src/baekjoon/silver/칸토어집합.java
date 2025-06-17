package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 칸토어집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            System.out.println(generateCantor(n));
        }
    }

    // n단계 칸토어 집합 문자열 생성
    private static String generateCantor(int n) {
        if (n == 0) {
            // 기저 사례: 단계 0에서는 '-' 하나
            return "-";
        }
        // (n-1)단계 문자열을 먼저 구한다
        String prev = generateCantor(n - 1);
        // 가운데에 prev 길이만큼의 공백을 삽입
        String blanks = " ".repeat(prev.length());
        // 앞(prev) + 공백 + 뒤(prev)를 이어붙여 반환
        return prev + blanks + prev;
    }

    class 제거방식 {

        private static char[] line;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while ((str = br.readLine()) != null) {
                int n = Integer.parseInt(str.trim());
                int length = (int) Math.pow(3, n);
                line = new char[length];
                // 1) 전체를 '-'로 초기화
                for (int i = 0; i < length; i++) {
                    line[i] = '-';
                }
                // 2) 중간 구간을 비워 나가는 재귀 호출
                removeMiddle(0, length);
                // 3) 결과 출력
                System.out.println(new String(line));
            }
        }

        /**
         * start 부터 size 길이만큼의 구간에서
         * 중간 1/3 구간을 공백으로 바꾸고,
         * 양쪽 구간에 동일 작업을 재귀 수행
         */
        private static void removeMiddle(int start, int size) {
            if (size < 3) {
                // 더 쪼갤 수 없는 수준이면 종료
                return;
            }
            int third = size / 3;
            // 중간 구간을 빈칸으로
            for (int i = start + third; i < start + 2 * third; i++) {
                line[i] = ' ';
            }
            // 왼쪽 구간 재귀
            removeMiddle(start, third);
            // 오른쪽 구간 재귀
            removeMiddle(start + 2 * third, third);
        }
    }

}
