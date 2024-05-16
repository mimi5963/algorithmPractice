package org.example.bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Boj3085 {

    static int[] dy = {0,-1,1,0,0};
    static int[] dx ={0,0,0,-1,1};
    static int n;
    static char[][] board;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();

         board = new char[n][n];

        for(int i=0; i<n;i++){
            String input = sc.next();
            for(int j=0; j<n;j++){
                board[i][j] = input.charAt(j);
            }
        }

        //bfs로 gkskTLr rkeh rhoscksgdmsrj dkslsrk?
        //어차피 완탐이니까
        //함수로 쭉 나열하는 형태로가자
        int maxLen=1;
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                int maxCandy = getMaxCandy(i,j);

                maxLen = Math.max(maxLen,maxCandy);
            }
            if (maxLen == n){break;}
        }

        System.out.println(maxLen);

    }

    private static int getMaxCandy(int y, int x){
        int max=0;

        for(int i=0; i<5;i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(!isBoundary(ny,nx))continue;

            //바운더리 안에 있으면, 좌표 바꾸기
           swap(y,x,ny,nx);

           int right = 0;
           int down = 0;


           right = Math.max(right,getMaxRight(y, x));
           down = Math.max(down,getMaxDown(y, x));


            max = Math.max(max, right > down ? right: down);
           //다시 자리바꾸기
           swap(y,x,ny,nx);
        }
        return max;
    }

    private static int getMaxDown(int y, int x) {
        int cnt =1;
        int temp=0;
        for(int i=0; i<n-1;i++){
            if(board[i][x] == board[i+1][x]){
                   cnt++;
            }else{
                temp = Math.max(temp,cnt);
                cnt=1;
            }

        }
        temp = Math.max(temp,cnt);
        return temp;
    }

    private static int getMaxRight(int y, int x) {
        int cnt =1;
        int temp=0;
        for(int i=0; i<n-1;i++){
            if(board[y][i] == board[y][i+1]){
                cnt++;
            }else{
                temp = Math.max(temp,cnt);
                cnt=1;
            }

        }
        temp = Math.max(temp,cnt);
        return temp;
    }

    private static void swap(int y, int x, int ny, int nx){
        char temp = board[y][x];
        board[y][x] = board[ny][nx];
        board[ny][nx] = temp;
    }

    private static boolean isBoundary(int y, int x){
        return (x >=0 && x<n) && (y>=0 && y<n);
    }

}
