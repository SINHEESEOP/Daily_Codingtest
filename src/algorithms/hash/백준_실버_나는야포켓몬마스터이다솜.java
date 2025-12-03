package algorithms.hash;

import java.io.*;
import java.util.*;

public class 백준_실버_나는야포켓몬마스터이다솜 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 핵심1. 번호 조회일시 배열에서 조회
        String[] pokemons = new String[N + 1];
        
        // 핵심2. 이름 조회일시 해시맵에서 조회
        Map<String, Integer> indexMap = new HashMap<>(N * 2);

        // 포켓몬 이름 입력
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pokemons[i] = name;
            indexMap.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        // 질의 처리
        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            if (Character.isDigit(q.charAt(0))) {
                // 숫자일 경우 인덱스로 이름 조회
                int idx = Integer.parseInt(q);
                sb.append(pokemons[idx]);
            } else {
                // 이름일 경우 인덱스 조회
                sb.append(indexMap.get(q));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}

class HashMap_하나만써서풀기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 이름 ↔ 번호 양방향 매핑을 하나의 HashMap으로 처리
        HashMap<String, String> map = new HashMap<>(N * 2);

        // 포켓몬 입력, 이름→번호, 번호→이름 모두 저장
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            String idx = Integer.toString(i);
            map.put(name, idx);
            map.put(idx, name);
        }

        StringBuilder sb = new StringBuilder();
        // 질의 처리
        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            sb.append(map.get(q)).append('\n');
        }

        System.out.print(sb);
    }
}
