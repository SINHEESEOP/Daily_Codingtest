package datastructures.stack;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 프로그래머스_레벨1_같은숫자는싫어 {

    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));

    }

    private static int[] solution(int[] ints) {
        Stack<Integer> stack = new Stack<>();

        stack.push(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            if (stack.peek() == ints[i]) continue;
            stack.push(ints[i]);
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

}
