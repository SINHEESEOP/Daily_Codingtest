package algorithms.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 🃏 백준 브론즈 - 블랙잭 문제 해결
 * 세 장의 카드를 선택하여 M에 가장 가까운 합을 구하는 문제
 */
public class 백준_브론즈_블랙잭 {

    static int[] arr;
    static int N; // 📊 카드의 개수
    static int M; // 🎯 목표 숫자
    static int MAX; // 🏆 최대 합

    public static void main(String[] args) throws IOException {
        // 🔧 입력 받기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        // 🃏 카드 값들을 배열에 저장
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        // 🔄 브루트포스로 세 장의 카드 조합 확인
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // 💡 현재 합이 M 이하이면서 기존 최대값보다 크면 갱신
                    if (MAX < arr[i] + arr[j] + arr[k] && M >= arr[i] + arr[j] + arr[k]) {
                        MAX = arr[i] + arr[j] + arr[k];
                    }
                }
            }
        }

        System.out.println(MAX);
        br.close();
    }
}

/**
 * 🚀 리팩토링된 블랙잭 클래스 - 성능 최적화 포함
 */
class 블랙잭_리팩토링 {

    static int N; // 📊 카드의 개수
    static int M; // 🎯 목표 합
    static int[] cards; // 🃏 카드 배열
    static int best; // 🏆 최적의 합

    public static void main(String[] args) throws IOException {
        // 🔧 입력 받기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 카드 개수
        M = Integer.parseInt(st.nextToken()); // 목표 합

        // 🃏 카드 배열 초기화 및 값 입력
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        best = 0;
        // 🔄 세 장의 카드를 모두 고르는 브루트포스
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    // 💡 목표값 이하이면서 현재 최선보다 좋으면 갱신
                    if (sum <= M && sum > best) {
                        best = sum;
                    }
                    // ⚡ 최적값에 도달하면 조기 종료
                    if (best == M) break;
                }
                if (best == M) break;
            }
            if (best == M) break;
        }

        System.out.println(best);
    }
} 