package algorithms.simulation;

public class 백준_브론즈2_Strfry {

    public static void main(String[] args) {
        System.out.println(isStrfry("ring", "gnir"));
    }

    public static boolean isStrfry(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] count = new int[26]; // 알파벳 소문자 a~z

        for (char ch : a.toCharArray()) count[ch - 'a']++;
        for (char ch : b.toCharArray()) count[ch - 'a']--;

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }


}
