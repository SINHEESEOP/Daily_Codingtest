package algorithms.simulation;

public class 프로그래머스_PCCE_지폐접기 {

    public static void main(String[] args) {
        int[] wallet1 = {30, 15};
        int[] bill1 = {26, 17};
        int[] wallet2 = {50, 50};
        int[] bill2 = {100, 241};

        System.out.println(solution(wallet1, bill1)); // 1
        System.out.println(solution(wallet2, bill2)); // 4
    }

    public static int solution(int[] wallet, int[] bill) {
        int foldCount = 0;
        // bill의 가로, 세로를 long으로 처리 (계산 과정에서 오버플로우 예방)
        long w = bill[0];
        long h = bill[1];

        // 접힌 지폐가 지갑에 들어가는지 (회전 고려) 확인
        while (!canFit(w, h, wallet)) {
            // 현재 지폐의 두 변 중 더 큰 쪽을 접음
            if (w >= h) {
                w /= 2; // 정수 나눗셈: 소수점 이하 버림
            } else {
                h /= 2;
            }
            foldCount++;
        }
        return foldCount;
    }

    // 지폐 크기 (w, h)가 지갑에 들어가는지 판단 (회전 가능)
    private static boolean canFit(long w, long h, int[] wallet) {
        int a = wallet[0], b = wallet[1];
        return (w <= a && h <= b) || (w <= b && h <= a);
    }
}

