package org.example.bfs;

import java.util.Scanner;

public class Boj7576 {
    static int n,m;
    static int[] dy ={-1,1,0,0};
    static int[] dx = {0,0-1,1};
    public static void main(String[] args) {

        //2종류 토마토
        // 하루 지나면 익은 토마토 근처 안익은 토마토가 익어
        // 토마토는 왼,오,앞,뒤 네방향
        //토마토 다 익는데 걸리는 시간을 알고 싶오

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] box = new int[n][m];
        boolean isRaw = false;
        boolean isripe = false;

        //배열 받기
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1 && isripe == false){
                    isripe = true;
                }
                if(box[i][j] == 0 && isRaw == false){
                    isRaw = true;
                }
            }
        }
        if(isripe == true && isRaw == false){
            System.out.println(0);
            return;
        }




    }
}
