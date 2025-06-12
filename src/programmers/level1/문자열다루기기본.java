package programmers.level1;

public class 문자열다루기기본 {

    public static void main(String[] args) {
        "Hello world!".chars().forEach(System.out::println);
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

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

}

class 스트림활용 {
    public boolean solution(String s) {
        // 길이가 4 또는 6 이고, 모든 문자가 숫자(true)여야 함
        return (s.length() == 4 || s.length() == 6)
                // 1. 문자열 s의 각 문자를 유니코드 코드값(int) 스트림으로 만든 후
                // 2. 그 스트림의 모든 코드값이 숫자(digit) 문자인지 검사해 true/false를 반환
                // 3. 예로들어서 "a123"인 경우 a 의 유니코드 값이 숫자의 유니코드 값이 아니라면 false 를 반환.
                && s.chars().allMatch(Character::isDigit);
    }
}