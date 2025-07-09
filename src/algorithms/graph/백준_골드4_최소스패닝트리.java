package algorithms.graph;

import java.io.*;
import java.util.*;

// 🎯 그래프 문제: 최소스패닝트리 (백준 골드4)
// 💡 크루스칼 알고리즘과 Union-Find를 이용한 MST 구하기
// ⚡ 시간복잡도: O(E log E), 공간복잡도: O(V + E)
public class 백준_골드4_최소스패닝트리 {

    static int V, E;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    // 📝 Union-Find의 Find 연산 (경로 압축)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 📝 Union-Find의 Union 연산
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // Union-Find 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>(E);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
        
        // 📝 크루스칼 알고리즘: 간선을 가중치 순으로 정렬
        Collections.sort(edges);

        long mstWeight = 0;
        int count = 0;
        
        // 📝 간선을 하나씩 확인하며 사이클이 생기지 않으면 추가
        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                mstWeight += e.w;
                if (++count == V - 1) break; // V-1개 간선으로 MST 완성
            }
        }

        System.out.println(mstWeight);
    }
} 