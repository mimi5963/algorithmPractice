package org.example.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj7576 {
    static int n,m;
    static int[] dy ={-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] box;
    static int[][] check;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //익은토마토는 1, 안익은거 0, 없는거 -1  -> 0일때만 가서1로
        //최소일은 본인 +1해가는거 알쥐~? 최소일 수 궁금
        //처음부터 모두 익으면 0, 토마토 모두 익을 수 x면 -1
        //-> 얘는 완탐 or 처음부터 검사


        //배열 크기 입력 받기
        n = sc.nextInt(); //열
        m = sc.nextInt(); //행
        check = new int[m][n];
        box = new int[m][n];
        Queue<Tomato> queue = new LinkedList<>();
        //배열을 초기화 하면서, 처음부터 1이었던 친구들 알고 있어야함
        // 모두 익은 것검사
        boolean isRaw = false;
        boolean isRipe = false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                int t1 = sc.nextInt();

                box[i][j] = t1;

                //Queue에 미리 저장 이미 1인 것이 출발점
                if(t1 == 1){

                    Tomato tomato = new Tomato(i,j);
                    queue.offer(tomato);
                }

                //모두 익은건지 아닌지 검사
                if(t1 == 0 && !isRaw){
                    isRaw = true;
                }
                if(t1 == 1 && !isRipe){
                    isRipe = true;
                }
            }
        }

        if(isRipe && !isRaw) {
            System.out.print(0);
            return;
        }



        //BFS를 돌아 -> 쭉 돌면 채워진다!
        while (!queue.isEmpty()){
            Tomato toma = queue.poll();

            for(int i=0; i<4; i++){
                int newY = toma.y + dy[i];
                int newX = toma.x + dx[i];

                if(newX < 0 || newX >=n || newY <0 || newY >= m) continue;

                if(box[newY][newX] == 0 && check[newY][newX] == 0){
                    check[newY][newX] = check[toma.y][toma.x] +1;
                    queue.offer(new Tomato(newY,newX));
                }
            }
        }

        int minDate=0;
        //마지막으로 check배열을 돌면서 배열안에 최소값 찾기
        boolean flag = false;
        for(int i=0; i<m;i++){
            if(flag) break;
            for(int j=0; j<n;j++){

                int date = check[i][j];
                int ini = box[i][j];

                if(date == 0 && ini == 0){
                  flag = true;
                }

                if(minDate < date){
                    minDate = date;
                }
            }
        }

        if(flag){
            System.out.println(-1);
            return;
        }

        System.out.println(minDate);


    }
    //2차원 배열 bfs 특징! row,col을 기억하는 class 필요
    static class Tomato{
        int y;
        int x;

        public Tomato(int y, int x){
            this.y = y;
            this.x = x;
        }

    }
}
