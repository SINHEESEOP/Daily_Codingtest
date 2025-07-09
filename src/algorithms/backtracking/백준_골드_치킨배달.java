package baekjoon.gold;

import java.io.*;
import java.util.*;

// 시간초과 정답 확인.
public class 치킨배달 {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minCityChickenDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 입력 받으며 집과 치킨집 좌표 분리 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    houses.add(new int[]{i, j});
                } else if (v == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        // M개 치킨집 조합을 위한 인덱스 배열
        int[] comb = new int[M];
        selectChickens(0, 0, comb);

        System.out.println(minCityChickenDist);
    }

    // 치킨집 조합 선택
    static void selectChickens(int start, int depth, int[] comb) {
        if (depth == M) {
            computeCityDist(comb);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            comb[depth] = i;
            selectChickens(i + 1, depth + 1, comb);
        }
    }

    // 선택된 M개 치킨집으로 도시 치킨 거리 계산
    static void computeCityDist(int[] comb) {
        int sum = 0;
        for (int[] house : houses) {
            int hx = house[0], hy = house[1];
            int best = Integer.MAX_VALUE;
            for (int idx : comb) {
                int[] ch = chickens.get(idx);
                int dist = Math.abs(hx - ch[0]) + Math.abs(hy - ch[1]);
                if (dist < best) {
                    best = dist;
                }
            }
            sum += best;
            // 이미 현재 합이 최소값을 넘으면 더 계산할 필요 없음
            if (sum >= minCityChickenDist) {
                return;
            }
        }
        minCityChickenDist = sum;
    }
}

