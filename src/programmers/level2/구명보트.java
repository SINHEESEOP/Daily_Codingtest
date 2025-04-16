package programmers.level2;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {

        int[] arr = {70, 50, 80, 50};
        System.out.println(solution(arr, 100));
    }

    /**
     * 풀이방법 : 최대 2명 탑승 가능한 조건이 있어, 배열을 오름차 순으로 정렬 후 min + max 합으로 경우의 수 계산.

     * 조건.
     * 1. boat 에 탑승한 인원은 제외시켜야 한다.
     * 2. min + max 보다 limit 이 더 크거나 같을 경우 boat++ 해줘야 한다.
     * 3. 초과의 경우 boat++ 해주며, min 은 제외시키지 않는다. ( 증가시지키 않고 그대로 둔다 )
     */

    public static int solution(int[] people, int limit) {
        int boat = 0;

        Arrays.sort(people);

        int min = 0;
        int max = people.length - 1;
        while (min <= max) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            max--;
            boat++;
        }

        return boat;
    }


}
