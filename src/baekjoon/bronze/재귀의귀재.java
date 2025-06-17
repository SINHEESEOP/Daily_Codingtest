package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재귀의귀재 {

    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            System.out.println(isPalindrome(br.readLine()) + " " + cnt);
            cnt = 0;
        }

    }

    private static int isPalindrome(String s) {
        return recursion(0, s.length() - 1, s);
    }

    private static int recursion(int preIndex, int postIndex, String s) {
        cnt++;
        if (preIndex >= postIndex) return 1;
        if (s.charAt(preIndex) != s.charAt(postIndex)) return 0;
        return recursion(preIndex + 1, postIndex - 1,  s);
    }

}
