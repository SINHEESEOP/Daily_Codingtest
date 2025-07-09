package algorithms.sorting;

import java.io.*;
import java.util.*;

// 🎯 정렬 문제: 나이순정렬 (백준 실버5)
// 💡 안정 정렬을 이용한 나이순 정렬 (같은 나이면 입력 순서 유지)
// ⚡ 시간복잡도: O(N log N), 공간복잡도: O(N)
public class 백준_실버5_나이순정렬 {

    static List<Person> people;
    static List<Person> copyPeople;

    static class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());
        people = new ArrayList<>(count);
        copyPeople = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people.add(new Person(age, name));
            copyPeople.add(new Person(age, name));
        }

        // 📝 머지 정렬로 안정성 보장
        mergeSort(0, count - 1);

        for (Person p : people) {
            writer.write(p.age + " " + p.name);
            writer.newLine();
        }
        writer.flush();
    }

    private static void mergeSort(int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;

        int midIdx = (startIdx + endIdx) / 2;

        mergeSort(startIdx, midIdx);
        mergeSort(midIdx + 1, endIdx);
        merge(startIdx, endIdx, midIdx);
    }

    private static void merge(int startIdx, int endIdx, int midIdx) {
        for (int i = startIdx; i <= endIdx; i++) {
            copyPeople.set(i, people.get(i));
        }

        int left = startIdx;
        int right = midIdx + 1;
        int idxM = startIdx;

        while (left <= midIdx && right <= endIdx) {
            if (copyPeople.get(left).age <= copyPeople.get(right).age) {
                people.set(idxM++, copyPeople.get(left++));
            } else {
                people.set(idxM++, copyPeople.get(right++));
            }
        }

        while (left <= midIdx) {
            people.set(idxM++, copyPeople.get(left++));
        }
    }
} 