package programmers.level0;

import java.util.Scanner;

public class 저주의숫자3 {

    public static void main(String[] args) {

        System.out.println(solution(40));

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

    public static boolean isInvalidString(int num) {
        return num % 3 == 0 || Integer.toString(num).contains("3");
    }
}
