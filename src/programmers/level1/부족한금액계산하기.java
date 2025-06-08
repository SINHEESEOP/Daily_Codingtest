package programmers.level1;

public class 부족한금액계산하기 {

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 5));
    }

    private static long solution(long price, long money, long count) {
        long total = 0;

        if (count % 2 == 0) {
            total = (price * count + price) * (count/2);
        }

        if (count % 2 != 0) {
            total = (price * count) * ((count - 1) /2) + (price * count);
        }

        if (total <= money) {
            return 0;
        }
        return total - money;
    }
}

class 좋은답 {

    // 등차수열과 분배법칙을 이용함
    // 예로 들어 등차수열을 통해 55 * 3 과, 55를 이루고 있는 수 1 ~ 10의 각 수에 3을 곱한 후 더해도 답은 같기 때문에
    // 등차수열로 값을 구하고, 해당 값에 그냥 3을 곱해도 결과는 같아짐.
    // max 메서드를 이용
    public long solution(int price, int money, int count) {
        // 한 줄 수식으로 부족한 금액 계산
        return Math.max((long)price * count * (count + 1) / 2 - money, 0);
    }

}