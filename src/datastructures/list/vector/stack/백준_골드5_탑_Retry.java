package datastructures.list.vector.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_골드5_탑_Retry {

    static class Tower {
        int index, height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayDeque<Tower> aq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            Tower tower = new Tower(i + 1, Integer.parseInt(st.nextToken()));

            while (!aq.isEmpty() && aq.peek().height <= tower.height) aq.pop();
            list.add(aq.isEmpty() ? 0 : aq.peek().index);
            aq.push(tower);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(" ");
            }
        }
    }

}
