package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2206T {
    static int n,m;
    static int[][] board;
    static int[][][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n+1][m+1];
        visited = new int[n+1][m+1][2];

        for(int i=1; i<=n; i++){
            String line = sc.next();
            for(int j=1; j<=m;j++){
                board[i][j] = line.charAt(j-1) -'0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1,1,0));
        visited[1][1][0] = 1;

        while (!q.isEmpty()){
            Point now = q.poll();
            if(now.r == n && now.c ==m){
                System.out.println(visited[now.r][now.c][now.isBroken]);
                return;
            }

            for(int i=0; i<4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr <=0 || nr > n || nc<=0 || nc >m) continue;
                if(visited[nr][nc][now.isBroken] == 0){
                    if(board[nr][nc] == 0){
                        visited[nr][nc][now.isBroken] = visited[now.r][now.c][now.isBroken]+1;
                        q.add(new Point(nr,nc,now.isBroken));
                    }
                    //벽을 부술 수 있다면 부숴
                    else if(board[nr][nc] == 1 && now.isBroken == 0){
                        visited[nr][nc][1] = visited[now.r][now.c][now.isBroken] +1;
                        q.add(new Point(nr,nc,1));
                    }
                }
            }

        }

        System.out.println(-1);

    }


    static class Point{
        int r,c;
        int isBroken;
        public Point(int r, int c, int b){
            this.r = r;
            this.c = c;
            this.isBroken = b;
        }
    }
}
