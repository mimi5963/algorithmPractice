package org.example.tree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj11725T {
    public static List<Integer>[] tree;
    public static boolean[] check;
    public static int[] parents;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        tree = new ArrayList[n+1];
        check = new boolean[n+1];
        parents = new int[n+1];
        for(int i=0; i<n+1;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1;i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            tree[node1].add(node2);
            tree[node2].add(node1);
        }
        find(1);
        for(int i=2; i<=n; i++){
            bw.write(parents[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void find(int node){
        //생각해보니 그렇네 base 역할을 tree[node].size가 함
        check[node] = true;
        for(int i=0; i<tree[node].size();i++){
            int child = tree[node].get(i);
            if(!check[child]){
                parents[child] = node;
                find(child);
            }
        }
    }
}
