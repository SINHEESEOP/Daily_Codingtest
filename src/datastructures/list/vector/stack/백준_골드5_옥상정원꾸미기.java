package datastructures.list.vector.stack;

import java.io.*;
import java.util.*;

public class 백준_골드5_옥상정원꾸미기 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }
            ans += stack.size(); // 현재 건물에서 보이는 이전 건물 수
            stack.push(h);
        }

        System.out.print(ans);
    }
}

