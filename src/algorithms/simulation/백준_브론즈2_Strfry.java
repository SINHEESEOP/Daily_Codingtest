package algorithms.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 백준_브론즈2_Strfry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            String a = input[0];
            String b = input[1];

            if (isStrfry(a, b)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    public static boolean isStrfry(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] count = new int[26];

        for (char ch : a.toCharArray()) count[ch - 'a']++;
        for (char ch : b.toCharArray()) count[ch - 'a']--;

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
