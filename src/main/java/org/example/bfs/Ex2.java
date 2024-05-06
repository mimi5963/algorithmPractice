package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex2 {
    static int n,k;
    static Pos[] pos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        if(n == k){
            System.out.println(0);
            System.out.println(1);
            return;
        }
        pos = new Pos[100001];


        for (int i=0; i<=100000;i++){
            pos[i] = new Pos(i,0,0);
        }

        Queue<Pos> q = new LinkedList<>();
        Pos start = pos[n];
        //방법 1 올리기
        start.cnt=1;
        q.offer(start);

        while (!q.isEmpty()){
            Pos now = q.poll();
            int nowp = now.p;
            int[] dir = {nowp-1,nowp+1,nowp*2};

            for(int i=0; i<3;i++){
                int newp = dir[i];
                if(newp <0 || newp>100000)continue;
                //두가지 처리해야함 첫 방문 그 다음 방문
                //1. 첫 방문  time이 여기서 check역할
                // 첫 방문시에는 모두 cnt가 1
                if(pos[newp].time == 0){
                    pos[newp].time = now.time+1;
                    pos[newp].cnt = now.cnt;
                    q.offer(pos[newp]);
                //두번째 이상 방문 일단 time이 0이 아닌 경우!
                    //두번째 이상 방문일때는 q에 넣지 않으나,
                    // 다음 newp에 time이 지금 time+1과 같아야함
                }else if(pos[newp].time == now.time+1){
                    //새로운 최단 방문이다! 방문 횟수 추가
                    pos[newp].cnt+=now.cnt;
                }
            }
        }

        System.out.println(pos[k].time);
        System.out.println(pos[k].cnt);

    }

    static class Pos{
        int p;
        int time;
        int cnt;
        public Pos(int p,int time,int cnt ){
            this.p = p;
            this.time = time;
            this.cnt = cnt;
        }
    }
}
