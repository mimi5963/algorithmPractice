package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj14442 {
    static int n;
    static int m;
    static int k;
    static int[][][] visited;
    static int[][] board;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
       //아 그게 틀린게 아닌가봄?
        visited = new int[n+1][m+1][k+1];
        board = new int[n+1][m+1];

        for(int i=1 ; i<=n;i++){
            String input =sc.next();
            for(int j=1; j<=m;j++){
                board[i][j] = input.charAt(j-1)-'0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        Point start = new Point(1,1,0);
        q.offer(start);
        visited[1][1][0] = 1;

        while (!q.isEmpty()){
            Point p = q.poll();
            if(p.r == n && p.c == m){
                System.out.println(visited[p.r][p.c][p.k]);
                return;
            }

            for(int i=0; i<4;i++){
                int nr = p.r+dr[i];
                int nc = p.c+dc[i];
                if(nr<=0 || nr>n || nc <=0 || nc > m) continue;

                //방문 할 수 있는 경우
                if(visited[nr][nc][p.k] == 0){
                    //벽이 없는 경우
                    if(board[nr][nc] == 0){
                        visited[nr][nc][p.k] += visited[p.r][p.c][p.k]+1;
                        q.offer(new Point(nr,nc, p.k));
                    }
                    //벽이 있는 경우 부순 횟수가 10 이하
                    else if(board[nr][nc] != 0 && p.k < k && visited[nr][nc][p.k+1] == 0){
                        visited[nr][nc][p.k+1] += visited[p.r][p.c][p.k]+1;
                        q.offer(new Point(nr,nc,p.k+1));
                    }
                }
            }

        }
        System.out.println(-1);
    }

    static class Point{
        int r;
        int c;
        int k;
        public Point(int r, int c, int k){
            this.r = r;
            this.c = c;
            this.k =k;
        }
    }
}
