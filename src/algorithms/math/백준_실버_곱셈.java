package algorithms.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_실버_곱셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a =  Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c =  Integer.parseInt(st.nextToken());

        System.out.println(recursion(a, b, c));
    }


    private static long recursion(long a, long b, long c) {
        if (b == 1) return a % c;

        long result = recursion(a, b/2, c);
        if (b % 2 == 0) {
            return (result * result) % c;
        }
        return  (result * result % c) * a % c;
    }
}
