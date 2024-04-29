package org.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj15681T {
    static List<Integer>[] tree;
    static boolean[] check;
    static int[] sum;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int q = sc.nextInt();
        check = new boolean[n + 1];
        sum = new int[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        sum[r] = getSum(r);

        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            System.out.println(sum[u]);
        }


    }

    public static int getSum(int root) {
        if (sum[root] != 0) return sum[root];
        check[root] = true;
        int result = 1;
        for (int child : tree[root]) {
            if (!check[child]) {
                result += getSum(child);
            }
        }

        //축약 문장 가능!
        return sum[root] = result;
    }
}
