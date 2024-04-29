package org.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj14267T {
    static int[] like;
    static int[] parent;
    static List<Integer>[] tree;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        parent = new int[n+1];
        like = new int[n+1];
        tree = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
            parent[i] = sc.nextInt();
            if(parent[i] == -1) continue;
            tree[parent[i]].add(i);
        }

        for(int i=0; i<m;i++){
            int employee = sc.nextInt();
            int point = sc.nextInt();

            like[employee] += point;

        }
        next(1);
        for(int i=1; i<=n;i++){
            System.out.println(like[i]+" ");
        }

    }

    public static void next(int node){
        for(int child : tree[node]){
            like[child] += like[node];
            next(child);
        }
    }

}
