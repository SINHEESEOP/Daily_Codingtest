package baekjoon.gold;

import java.io.*;
import java.util.*;

public class 이중우선순위큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder   output = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine().trim());
        while (testCases-- > 0) {
            int operationsCount = Integer.parseInt(reader.readLine().trim());
            TreeMap<Integer, Integer> multiset = new TreeMap<>();

            // 1) 연산 처리
            for (int i = 0; i < operationsCount; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                char command = st.nextToken().charAt(0);
                int  value   = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    // 삽입: 값의 개수를 1 증가
                    multiset.put(value, multiset.getOrDefault(value, 0) + 1);

                } else if (!multiset.isEmpty()) {
                    // 삭제: 최대값 또는 최소값 하나 제거
                    int keyToRemove = (value == 1)
                            ? multiset.lastKey()
                            : multiset.firstKey();

                    int count = multiset.get(keyToRemove);
                    if (count > 1) {
                        multiset.put(keyToRemove, count - 1);
                    } else {
                        multiset.remove(keyToRemove);
                    }
                }
            }

            // 2) 결과 출력 준비
            if (multiset.isEmpty()) {
                output.append("EMPTY\n");
            } else {
                int maxKey = multiset.lastKey();
                int minKey = multiset.firstKey();
                output.append(maxKey)
                        .append(' ')
                        .append(minKey)
                        .append('\n');
            }
        }

        // 3) 전체 결과 출력
        System.out.print(output);
    }
}