package algorithms.string;

// 🎯 문자열 문제: 문자열다루기기본 (프로그래머스 레벨1)
// 💡 문자열이 숫자로만 구성되어 있는지 검증
// ⚡ 시간복잡도: O(N), 공간복잡도: O(1)
public class 프로그래머스_레벨1_문자열다루기기본 {

    public static void main(String[] args) {
        "Hello world!".chars().forEach(System.out::println);
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

    // 📝 예외 처리를 이용한 검증 방법
    private static boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    // 📝 스트림을 이용한 더 효율적인 방법
    static class 스트림활용 {
        public boolean solution(String s) {
            return (s.length() == 4 || s.length() == 6)
                    && s.chars().allMatch(Character::isDigit);
        }
    }
} 