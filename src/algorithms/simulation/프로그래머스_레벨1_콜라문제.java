package algorithms.simulation;

public class 프로그래머스_레벨1_콜라문제 {

    public static void main(String[] args) {

        int result = solution(90, 89, 100);
        System.out.println(result);

    }

    private static int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int tt = 0; // 주고 남은 콜라
            tt += n % a;
            answer += (n / a) * b; //서비스로 받은 콜라 누적
            n = (n / a) * b + tt; // 남아있는 콜라
        }
        return answer;
    }

}
