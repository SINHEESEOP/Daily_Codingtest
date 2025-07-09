package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 문자열내림차순정하기 {

    public static void main(String[] args) {

        System.out.println(solution("Zbcdefg"));

    }

    private static String solution(String s) {
        String[] split = s.split("");

        List<String> list = new ArrayList<String>(Arrays.asList(split));

        Collections.sort(list);
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

}
