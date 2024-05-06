package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex {
    static int n,k;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        //시간 넘겨 줄 배열 선언
        check = new int[100001];


        if(n == k) {
            System.out.println(0);
            return;
        }

        //-1,+1 혹은 2*x해서 동생의 위치까지 감
        // 둘은 0 혹은 100000사이에 위치
        Queue<Integer> que = new LinkedList<>();
        que.offer(n);

        while (!que.isEmpty()){
            int now = que.poll();
            int[] dir = {now-1,now+1,now*2};

            for(int i=0; i<3;i++){
                int newpos = dir[i];
                if(newpos < 0 || newpos > 100000) continue;
                if(check[newpos] == 0){
                    check[newpos] = check[now]+1;
                    que.offer(newpos);
                }
            }

        }

        System.out.println(check[k]);

    }
}
