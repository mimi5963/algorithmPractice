package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697 {
    static int n,k;
    static int[] dx = {-1,1,2};
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new int[100000+1];

        if(n == k){
            System.out.println(0);
            return;
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(n);

        while (!que.isEmpty()){
            int now = que.poll();

            for(int i=0; i<3;i++){
               int nextStep;
               if(i<2) nextStep = now + dx[i];
               else nextStep = now * dx[i];

               if(nextStep <0 || nextStep > 100000) continue;

               if(visited[nextStep] == 0){
                   visited[nextStep] = visited[now]+1;
                   que.offer(nextStep);
               }

            }
        }

        System.out.println(visited[k]);

    }
}
