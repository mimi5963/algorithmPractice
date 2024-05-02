package org.example.graph;

import java.util.*;

public class Boj1260T {
    static int n,m,v;
    static int[][] grap;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        grap = new int[n+1][n+1];
        check = new boolean[n+1];
        for(int i= 0; i<m ;i++){
            int src = sc.nextInt();
            int dst = sc.nextInt();
            grap[src][dst] = 1;
            grap[dst][src] =1;
        }
        dfs(v);
        System.out.println();
        //bfs
        check = new boolean[n+1];
        bfs(v);
    }


    static void dfs(int node){
        check[node] = true;
        System.out.print(node+" ");
        for(int i=1; i<=n; i++){
            if(grap[node][i] == 1 && !check[i]){
                dfs(i);
            }
        }
    }

    static Queue<Integer> q;
    static void bfs(int node){
        q  = new LinkedList<>();
        q.offer(node);
        check[node]  = true;

        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now+" ");
            for(int i =1 ; i <=n; i++){
                if(grap[now][i] ==1 && !check[i]){
                    q.offer(i);
                    check[i] = true;
                }
            }

        }
    }

    static Stack<Integer> st;
    static void stDFS(int node){
        st = new Stack<>();
        st.push(node);
        check[node] = true;

        while (!st.isEmpty()){
            int now = st.pop();
            System.out.print(now+ " ");
            for(int i=1;i<=n;i++){
                if(grap[now][i] == 1 && !check[i]){
                    st.push(i);
                    check[i]=true;
                }
            }
        }

    }
}
