package datastructures.heap;

import java.io.*;
import java.util.*;

// 🎯 자료구조 문제: 이중우선순위큐 (백준 골드2)
// 💡 TreeMap을 이용한 최대값/최소값 동시 삭제 가능한 우선순위큐
// ⚡ 시간복잡도: O(K log N), 공간복잡도: O(N)
public class 백준_골드2_이중우선순위큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine().trim());
        while (testCases-- > 0) {
            int operationsCount = Integer.parseInt(reader.readLine().trim());
            // 📝 TreeMap으로 정렬된 상태의 중복값 관리
            TreeMap<Integer, Integer> multiset = new TreeMap<>();

            for (int i = 0; i < operationsCount; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                char command = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    // 삽입: 값의 개수를 1 증가
                    multiset.put(value, multiset.getOrDefault(value, 0) + 1);

                } else if (!multiset.isEmpty()) {
                    // 📝 삭제: 최대값(1) 또는 최소값(-1) 하나 제거
                    int keyToRemove = (value == 1)
                            ? multiset.lastKey()  // 최대값
                            : multiset.firstKey(); // 최소값

                    int count = multiset.get(keyToRemove);
                    if (count > 1) {
                        multiset.put(keyToRemove, count - 1);
                    } else {
                        multiset.remove(keyToRemove);
                    }
                }
            }

            // 결과 출력
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

        System.out.print(output);
    }
} 