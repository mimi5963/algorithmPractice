package org.example.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2178 {
    static int n;
    static int m;
    static int[][] arr;

    static boolean[][] check;
    static int[] dy = {-1,1,0,0}; //상하좌우 순
    static int[] dx = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sinput = br.readLine().split(" ");
        n = Integer.parseInt(sinput[0]);
        m = Integer.parseInt(sinput[1]);
        arr = new int[n][m];
        check = new boolean[n][m];
        //배열 초기화
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m;j++){
                arr[i][j] = Integer.parseInt(s.charAt(j)+"");
            }
        }
        //bfs를 돌아
        Queue<Road> queue = new LinkedList<>();
        Road r1 = new Road(0,0,1);
        check[r1.row][r1.col] = true;
        queue.offer(r1);
        boolean flag = true;

        while(flag){
            Road r = queue.poll();

            for(int i=0; i<4;i++){
                int y = r.row+dy[i];
                int x = r.col+dx[i];

                if(isBoundary(y,x) && !check[y][x] && arr[y][x] !=0){
                    if(y == n-1 && x == m-1){
                        flag = !flag;
                        System.out.println(r.cnt+1);
                    }else {
                        check[y][x] = true;
                        Road road = new Road(y, x, r.cnt + 1);
                        queue.offer(road);
                    }
                }
            }

        }

    }

    static boolean isBoundary(int y, int x){
        return (y>=0 && y<n) && (x>=0 && x<m);
    }

    static class Road{
        int row;
        int col;

        int cnt;
        public Road(int row,int col,int cnt){
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

}
