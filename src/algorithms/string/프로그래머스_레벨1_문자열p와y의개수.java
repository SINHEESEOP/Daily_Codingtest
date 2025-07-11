package algorithms.string;

public class 프로그래머스_레벨1_문자열p와y의개수 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("pPoooyY"));

//        "pPoooyY"	true
//        "Pyy"	false

    }


    static class Solution {

        int cntP;
        int cntY;

        boolean solution(String s) {
            String lower = s.toLowerCase();

            for (int i = 0; i < lower.length(); i++) {
                if (lower.charAt(i) == 'p') {
                    cntP++;
                }
                if (lower.charAt(i) == 'y') {
                    cntY++;
                }
            }
            return cntP == cntY;
        }

    }

}
