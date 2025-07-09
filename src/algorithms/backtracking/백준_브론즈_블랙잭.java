package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭 {

    static int[] arr;
    static int N;
    static int M;
    static int MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];


        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (MAX < arr[i] + arr[j] + arr[k] && M >= arr[i] + arr[j] + arr[k]) {
                        MAX = arr[i] + arr[j] + arr[k];
                    };
                }
            }
        }

        System.out.println(MAX);
        br.close();
    }

}


class 블랙잭_리팩토링 {

    static int N;
    static int M;
    static int[] cards;
    static int best;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 카드 개수
        M = Integer.parseInt(st.nextToken()); // 목표 합

        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        best = 0;
        // 세 장의 카드를 모두 고르는 브루트포스
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M && sum > best) {
                        best = sum;
                    }
                    // 만약 best가 M과 같아지면 더 이상 클 수 없으므로 중단
                    if (best == M) break;
                }
                if (best == M) break;
            }
            if (best == M) break;
        }

        System.out.println(best);
    }

}
