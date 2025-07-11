package algorithms.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class 백준_실버_수찾기 {

    static int N;
    static int M;
    static List<Integer> arrList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new java.io.InputStreamReader( System.in ) );
        N = Integer.parseInt( br.readLine() );
        StringTokenizer st = new StringTokenizer( br.readLine() );
        arrList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrList.add( Integer.parseInt( st.nextToken() ) );
        }

        Collections.sort(arrList);

        M = Integer.parseInt( br.readLine() );
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt( st.nextToken() );

            if (Collections.binarySearch(arrList, a) < 0) {
                System.out.println(0);
            } else System.out.println(1);

        }

    }

}
