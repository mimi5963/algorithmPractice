package org.example.dfs;

import java.util.Scanner;

public class Boj10451T {
    static int[] nextNode;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc -- > 0){
            int n = sc.nextInt();
            nextNode = new int[n+1];
            visited = new boolean[n+1];

            for(int i=1; i<=n; i++){
                nextNode[i] = sc.nextInt();
            }

            int cnt=0;
            for(int i=1; i<=n;i++){
                if(!visited[i]){
                    dfs(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int node){
        visited[node] = true;
        if(!visited[nextNode[node]]){
            dfs(nextNode[node]);
        }
    }
}
