package algorithms.greedy;

import java.util.Arrays;

// 🎯 그리디 문제: 구명보트 (프로그래머스 레벨2)
// 💡 최대 2명 탑승 가능한 보트로 모든 사람을 구출하는 최소 보트 수
// ⚡ 시간복잡도: O(N log N), 공간복잡도: O(1)
public class 프로그래머스_레벨2_구명보트 {

    public static void main(String[] args) {
        int[] arr = {70, 50, 80, 50};
        System.out.println(solution(arr, 100));
    }

    /**
     * 🔍 풀이 전략:
     * 1. 배열을 오름차순 정렬
     * 2. 투 포인터로 가장 가벼운 사람과 무거운 사람을 함께 태울 수 있는지 확인
     * 3. 태울 수 있으면 둘 다 제외, 없으면 무거운 사람만 제외
     */
    public static int solution(int[] people, int limit) {
        int boat = 0;

        Arrays.sort(people);

        int min = 0;                    // 가장 가벼운 사람
        int max = people.length - 1;    // 가장 무거운 사람
        
        while (min <= max) {
            if (people[min] + people[max] <= limit) {
                min++; // 가벼운 사람도 태움
            }
            max--; // 무거운 사람은 항상 태움
            boat++;
        }

        return boat;
    }
} 