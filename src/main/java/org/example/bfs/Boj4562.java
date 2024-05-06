package org.example.bfs;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj4562 {
    static int[] dy={-1,-2,-2,-1,1,2,2,1};
    static int[] dx ={-2,-1,1,2,2,1,-1,-2};


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();

        //boolean[][] check = new boolean[300][300]; // 방문 기록용
        //각 테스트 케이스 3개로 이루어짐
        // 첫줄에는 체스판의 한변의 길이 (체스판은 N*N)
        // 첫 칸은 나이트가 있는 칸이고, 두번째는 움직이려는 칸


        Queue<Knight> que = new LinkedList<>();

        while(n -- > 0){
          int l = sc.nextInt(); //주어진 체스판의 크기인데, 움직임 제약
          int nowy = sc.nextInt();
          int nowx = sc.nextInt();
          int targety = sc.nextInt();
          int targetx = sc.nextInt();
          if(nowy == targety && nowx == targetx){
              bw.write(0+"\n");
              continue;
          }
          int[][] map = new int[300][300]; //체스는 0~ l-1까지만 움직임, 방문 기록용
          que.offer(new Knight(nowy,nowx));

          while (!que.isEmpty()){
              Knight now = que.poll();

              for(int i=0; i<8;i++){
                  int newx = now.x+dx[i];
                  int newy = now.y+dy[i];

                  if(newx < 0 || newx >=l || newy <0 ||  newy>=l) continue;
                  if (map[newy][newx] == 0){
                      map[newy][newx] = map[now.y][now.x] +1;
                      que.offer(new Knight(newy,newx));
                  }
              }
          }

          bw.write(map[targety][targetx]+"\n");
        }

        bw.flush();
        bw.close();
    }

    static class Knight{
        int y;
        int x;
        public Knight(int y, int x){
            this.y =y;
            this.x = x;
        }
    }
}
