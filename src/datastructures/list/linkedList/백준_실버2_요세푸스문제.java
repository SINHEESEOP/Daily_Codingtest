package datastructures.list.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 문제 풀이 접근 방식
 * - 대표적인 링크드리스트 + 원형큐의 원리를 활용하는 문제이다.
 *
 * 이유.
 * 간단하다. 리스트에서 삭제가 자주 일어난다면 배열이 아닌 링크드리스트가 좋다.
 * 조회가 중요하다면, 당연히 인덱스로 조회가 가능한 배열이나, 해쉬테이블이 좋다.
 */

public class 백준_실버2_요세푸스문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
           list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;

        while (!list.isEmpty()) {
            index = (index + k - 1) % list.size(); // 원형 순회
            sb.append(list.remove(index));

            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }

}
