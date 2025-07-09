package algorithms.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 🎯 재귀 문제: 칸토어집합 (백준 실버3)
// 💡 재귀적으로 중간 1/3을 제거하는 칸토어 집합 생성
// ⚡ 시간복잡도: O(3^N), 공간복잡도: O(3^N)
public class 백준_실버3_칸토어집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            System.out.println(generateCantor(n));
        }
    }

    // 📝 n단계 칸토어 집합 문자열 생성
    private static String generateCantor(int n) {
        if (n == 0) {
            return "-"; // 기저 사례
        }
        
        // 이전 단계 문자열 구하기
        String prev = generateCantor(n - 1);
        // 가운데 공백 생성
        String blanks = " ".repeat(prev.length());
        // 앞 + 공백 + 뒤 구조로 칸토어 집합 생성
        return prev + blanks + prev;
    }
} 