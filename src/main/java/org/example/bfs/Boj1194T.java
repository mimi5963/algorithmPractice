package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1194T {
    static int n,m;
    static char[][] maze;
    static int[][][] distance;
    static int[] dr ={-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static final int DOOR = 1;
    static final int KEY = 2;
    static final int EXIT =3;
    static final int WALL = 4;
    static final int NONE = 5;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new char[n][m];
        distance = new int[n][m][1<<6];
        Queue<Point> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            String input =sc.next();
            for(int j=0; j<m;j++){
                char ch = input.charAt(j);
                if(ch == '0'){
                    q.offer(new Point(i,j,0));
                    distance[i][j][0] = 1;
                }
                maze[i][j] = input.charAt(j);
            }
        }

        while (!q.isEmpty()){

            Point now = q.poll();


            for(int i=0; i<4; i++){
                int nr = now.r+dr[i];
                int nc = now.c+dc[i];
                if(nr <0 || nr >=n || nc <0 || nc >=m) continue;

                int next = maze[nr][nc];

                switch (getType(next)){
                    case WALL->{
                        continue;
                    }
                    case NONE->{
                        if(distance[nr][nc][now.key] == 0){
                            distance[nr][nc][now.key] = distance[now.r][now.c][now.key]+1;
                            q.offer(new Point(nr,nc,now.key));
                        }
                    }
                    case KEY ->{
                       int nextKey = now.key | 1<<(next-'a');
                       if(distance[nr][nc][nextKey] == 0){
                           distance[nr][nc][nextKey] = distance[now.r][now.c][now.key]+1;
                            q.offer(new Point(nr,nc,nextKey));
                       }
                    }
                    case DOOR -> {
                        next -= 'A';
                        //key를 가지고 있으면,
                        if((1<<next & now.key) == 0)continue;
                        if(distance[nr][nc][now.key] == 0) {
                            distance[nr][nc][now.key] = distance[now.r][now.c][now.key] + 1;
                            q.offer(new Point(nr, nc, now.key));
                        }
                    }
                    case EXIT -> {
                        System.out.println(distance[now.r][now.c][now.key]);
                        return;
                    }
                }


            }


        }

        System.out.println(-1);

    }

    static int getType(int c){
        if (c == '#') return WALL;
        else if (c == '.' || c == '0') return NONE;
        else if (c >= 'a' && c <= 'f') return KEY;
        else if (c >= 'A' && c <= 'F') return DOOR;
        else if (c == '1') return EXIT;
        else return -1;
    }

   static class Point{
        int r,c,key;
        public Point(int r, int c, int k){
            this.r = r;
            this.c = c;
            this.key =k;
        }
    }

}
