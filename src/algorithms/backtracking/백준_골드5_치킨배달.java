package algorithms.backtracking;

import java.io.*;
import java.util.*;

// 🎯 백트래킹 문제: 치킨배달 (백준 골드5)  
// 💡 M개 치킨집 조합을 선택하여 최소 치킨거리 구하기
// ⚡ 시간복잡도: O(C(치킨집수, M) × 집수), 공간복잡도: O(집수 + 치킨집수)
public class 백준_골드5_치킨배달 {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minCityChickenDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 📝 집과 치킨집 좌표 분리 저장
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

        // M개 치킨집 조합 선택
        int[] comb = new int[M];
        selectChickens(0, 0, comb);

        System.out.println(minCityChickenDist);
    }

    // 📝 백트래킹으로 치킨집 조합 선택
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
            
            // 각 집에서 가장 가까운 치킨집까지의 거리
            for (int idx : comb) {
                int[] ch = chickens.get(idx);
                int dist = Math.abs(hx - ch[0]) + Math.abs(hy - ch[1]);
                if (dist < best) {
                    best = dist;
                }
            }
            sum += best;
            
            // 📝 가지치기: 이미 최소값을 넘으면 중단
            if (sum >= minCityChickenDist) {
                return;
            }
        }
        minCityChickenDist = sum;
    }
} 