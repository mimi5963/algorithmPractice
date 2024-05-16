package org.example.dfs;

import java.util.Scanner;

public class Boj9466Two {
    static int[] student;
    static int[] visited;
    static int cnt=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc -- >0){
            int n  =sc.nextInt();
            student = new int[n+1];
            visited = new int[n+1];
            for (int i=1; i<=n;i++){
                student[i] = sc.nextInt();
            }

            int result = n;
            int cnt=0;
            for(int i=1; i<=n;i++){

                if(visited[i] == 0){
                    visited[i] = 1;
                    cnt += dfsInt(i);

                }
            }

            System.out.println(result - cnt);


            }





    }
    static int dfsInt(int node){
       int next = student[node];
       int cycle = 0;
       if(visited[next] == 0){
           visited[next]  = visited[node]+1;
           cycle = dfsInt(next);
       }else{
           cycle = visited[node] - visited[next] +1;
       }

       visited[node] = 100001;

       return cycle <0 ? 0:cycle;
    }
}
