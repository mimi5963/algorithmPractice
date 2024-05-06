package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj12851 {
    static int n,k;

    static boolean[] visited; //최초 방문 체크
    static int[] dir = {-1,1,2};
    static Position[] pos = new Position[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[100001];

        for(int i=0; i<=100000;i++){
            pos[i] = new Position(i,0);
        }
        if(n == k){
            System.out.println(0);
            System.out.println(1);
        }


        //min time을 저장하고, now.에 다음이 k인데, 시간 +1 도 min이면 cnt++;


        Queue<Position> q = new LinkedList<>();
        q.offer(pos[n]);
        visited[n] = true;

        while (!q.isEmpty()){

           Position now = q.poll();

            for(int i=0; i<3; i++){
                //새로 갈 좌표
                int newP = now.num;

                if(i<2){
                    newP += dir[i];
                }else{
                    newP *= dir[i];
                }
                if(newP<0 || newP >100000) continue;

                Position p1 = pos[newP];
                //최초 방문시만 초기화함 time
                if(!visited[newP]){
                    p1.time = now.time+1;
                    q.offer(p1);
                    visited[newP] = true;
                //다음 모든 방문 시
                }else if(now.time+1 == p1.time){
                    p1.cnt = now.cnt+1;
                }
            }
        }
        System.out.println(pos[k].time);
        System.out.println(pos[k].cnt);

    }

    static class Position{
        int num;
        int cnt=1;
        int time;
        public Position(int num, int time){
            this.num = num;
            this.time = time;
        }
    }

}
