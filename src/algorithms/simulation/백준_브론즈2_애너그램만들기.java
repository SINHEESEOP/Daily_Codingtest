package algorithms.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_브론즈2_애너그램만들기 {

    static int[] arr = new int[26];
    static int[] arr2 = new int[26];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (char ch : br.readLine().toCharArray()) {
            arr[ch - 'a'] += 1;
        }

        for (char ch : br.readLine().toCharArray()) {
            arr2[ch - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0 && arr2[i] != 0) {
                cnt += arr2[i];
            } else if (arr2[i] == 0 && arr[i] != 0) {
                cnt += arr[i];
            } else if (arr[i] != arr2[i]) {
                cnt += Math.abs(arr[i] - arr2[i]);
            }
        }

        System.out.println(cnt);

    }

    public class 애너그램_더좋은코드 {

        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String a = br.readLine();
                String b = br.readLine();

                int[] alpha = new int[26]; // 소문자 a~z

                // 첫 번째 문자열에서 각 알파벳 개수 +
                for (char ch : a.toCharArray()) alpha[ch - 'a']++;
                // 두 번째 문자열에서 각 알파벳 개수 -
                for (char ch : b.toCharArray()) alpha[ch - 'a']--;

                int ans = 0;
                // 각 알파벳의 차이의 절댓값 합산
                for (int count : alpha) {
                    ans += Math.abs(count);
                }

                System.out.println(ans);
            }
        }

    }
}
