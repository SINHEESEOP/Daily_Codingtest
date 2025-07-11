package lab;

public class 프로그래머스_레벨0_저주의숫자3_PerformanceTest {

    public static void main(String[] args) {
        int n = 1_000_000_000; // 10억

        // solution() (static 메서드) 성능 측정
        long startTime = System.nanoTime();
        int result1 = solution(n);
        long endTime = System.nanoTime();
        double elapsedTimeSec = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("solution() result: " + result1);
        System.out.println("solution() time: " + elapsedTimeSec + " seconds");

        // solution2() (non-static 메서드) 성능 측정
        저주의숫자3_PerformanceTest tester = new 저주의숫자3_PerformanceTest();
        startTime = System.nanoTime();
        int result2 = tester.solution2(n);
        endTime = System.nanoTime();
        elapsedTimeSec = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("solution2() result: " + result2);
        System.out.println("solution2() time: " + elapsedTimeSec + " seconds");
    }

    public static int solution(int n) {
        int count = 0; // 변환된 숫자 개수
        int current = 0; // 현재 숫자

        while (count < n) {
            current++; // 숫자 증가
            if (!isInvalidString(current)) { // 유효한 숫자만 카운트
                count++;
            }
        }
        return current; // n번째 변환된 숫자 반환
    }

    public int solution2(int n) {
        int num = 0;
        int count = 0;
        while (count < n) {
            num++;
            // num이 3의 배수이거나 '3'이라는 숫자를 포함하면 건너뜁니다.
            if (num % 3 == 0 || String.valueOf(num).contains("3")) {
                continue;
            }
            count++;
        }
        return num;
    }

    public static boolean isInvalidString(int num) {
        return num % 3 == 0 || Integer.toString(num).contains("3");
    }
}
