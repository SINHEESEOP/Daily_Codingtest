package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_골드_Z {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(z(c, r, n));
    }

    private static int z(int c, int r, int n) {
        if (n == 0) return 0;

        int half = (int) Math.pow(2, n - 1);
        int size = half * half;

        // 1분면
        if (c < half && r < half) {
            return z(c, r, n - 1);
        // 2분면
        } else if (c >= half && r < half) {
            return size + z(c - half, r, n - 1);
        // 3분면
        } else if (c < half && r >= half) {
            return 2 * size + z(c, r - half, n - 1);
        // 4분면
        } else {
            return 3 *  size + z(c - half, r - half, n - 1);
        }
    }

    class Z해설 {
        /**
         *  조건 :
         *  기본적으로 배열을 만들어서 직접 순차하는 방법도 있지만, 최대의 경우 크기의 (2^15 * 2^15) * int(4) = 4GIB 크기를 차지한다.
         *  실제 테스트용으로 해당 크기에 배열을 만들어 유지시키니 작업 관리자에서 4GB 가까이 먹는걸 확인했다..
         *  512MB 메모리 제한이 있으므로, 이 방법은 Fail
         *
         *  접근법 :
         *  1. 기본적으로 4분면으로 분할 접근하는 방식으로 가야하는건 맞다.
         *  2. 여기서 힌트를 얻은것은 각 분면으로 진입했을때, 찾으려는 값이 어느 분면이냐에 따라 얼마를 더해줘야 하는지 알 수 있다.
         *  3. 그럼 더이상 다른 분면은 확인하지 않아도 되며, 이때 찾으려는 값의 분면으로 들어가서 또 다시 4분면으로 쪼개면 된다.
         *  4. 이걸 반복하여 답을 찾을 수 있으며, 각 r 또는 c 값에 half 를 빼는 이유를 알기 위해선 half 와 size 를 왜 구하는지 알아야한다.
         *
         *  중요포인트 및 설계 이유 :
         *  - half 를 구하는 이유
         *  왜 2^n-1 제곱이냐? 우리가 구하려는 것은 목표가 어느 분면에 있는가 이기 때문에
         *  한면의 반만 구하여 4분면으로 생각해야 하기 때문이다. 그렇게 구한 반x반이 결국 하나의 반면이자 그 분면의 전체 칸 갯수이다.
         *  (그냥 (2^n) / 2 를 해도 된다 같은거다. 항상 이전문제에서 분할재귀를 할 때 하던 방식을 다르게 한 것 뿐이다.)
         *
         *  자 그러면 우리의 목표가 예로들어 3분면에 있다고 가정한다면, 우리는 분할 후 3분면으로 진입한다.
         *  이제 3분면을 다시 4분면으로 쪼갠다. 여기서 목표는 이제 4분면이 아닐 수 있다.
         *  그렇기 때문에 r 과 c 값도 해당 분면의 위치에 맞게 수정해야한다. 그래서 half 를 뺴는 것.
         *  또 한 4분면으로 쪼갠다면 다시 1분면의 (0,0)은 0부터 시작이다.
         *
         *  - 그럼 왜 n-1 해서 넘기나?
         *  일단 pow 에서 n-1 과 재귀 할 때 n-1 이 다른 의미다.
         *  pow 에서 n-1 은 한면의 반만 구하겠단 소리이고,
         *  재귀 n-1 로 넘기는건, NxN 의 테이블을 반으로 쪼개서 넘기겠다는 거다. 즉 4x4 -> 2x2 로 만드는것.
         *  이후에 pow 에서 한분면인 2에 반을 즉 1를 구하는 것이다.
         */
    }

}
