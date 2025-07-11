package algorithms.recursion;

public class 백준_골드_하노이의탑 {

    public static void main(String[] args) {
        int n = 3; // 원판 개수 (예제: 3개)
        hanoi(n, 'A', 'C', 'B'); // (원판 개수, 시작 기둥, 목표 기둥, 보조 기둥)
    }

    // 하노이 탑 재귀 함수
    public static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) { // 원판이 하나일 때 직접 이동
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }

        // 1단계: N-1개의 원판을 A → B로 이동
        hanoi(n - 1, from, aux, to);

        // 2단계: N번째 원판을 A → C로 이동
        System.out.println("Move disk " + n + " from " + from + " to " + to);

        // 3단계: N-1개의 원판을 B → C로 이동
        hanoi(n - 1, aux, to, from);
    }
}
