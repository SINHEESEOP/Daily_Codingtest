package algorithms.recursion;

import java.util.Scanner;

// 🎯 재귀 문제: 재귀함수가뭔가요 (백준 실버5)
// 💡 재귀 호출을 이용한 문자열 출력 패턴
// ⚡ 시간복잡도: O(N), 공간복잡도: O(N)
public class 백준_실버5_재귀함수가뭔가요 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(n, 0);
    }

    private static void recursion(int n, int x) {
        StringBuilder str = new StringBuilder();
        
        // 인덴트 생성 (효율적인 repeat 사용)
        str.append("____".repeat(Math.max(0, x)));

        System.out.println(str + "\"재귀함수가 뭔가요?\"");
        if (n == 0) {
            System.out.println(str + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(str + "라고 답변하였지.");
            return;
        }
        System.out.println(str + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                str + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                str + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        recursion(n - 1, x + 1);
        System.out.println(str + "라고 답변하였지.");
    }
} 