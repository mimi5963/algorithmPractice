package org.example.bfs;

import java.util.*;

public class Boj1194TW {

    static int n,m;
    static int[][][] visited;
    static int[] dr ={-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] board;
    static char[] keys = {'a','b','c','d','e','f'};
    static char[] doors = {'A','B','C','D','E','F'};

    static int comnum=0;
    static Map<String, Integer> map = new HashMap<>();
    static char[] output;
    public static void main(String[] args) {
        //.과 key와 탈출구와 0민식이 위치는 항상 갈 수 있고


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n+1][m+1];
        visited = new int[n+1][m+1][64];



        //조합  초기화
        for(int i=1; i<=6;i++) {
            output = new char[i];
            getCom(0, 0, i);
        }



        Queue<Point> q = new LinkedList<>();
        // 배열 초기화
        for(int i=1;i<=n;i++){
            String input =sc.next();
            for(int j=1; j<=m;j++){
                char ch = input.charAt(j-1);
                if(ch == '0'){
                    q.offer(new Point(i,j,0));
                    visited[i][j][0] = 1;
                }
                board[i][j] = input.charAt(j-1);
            }
        }
    }

    static void getCom(int start, int depth, int end){
        if(depth == end){
            String keys="";
            for(int i=0; i<end;i++){
                keys += output[i];
            }
            comnum += 1;
            map.put(keys,comnum);


        }else{
            for(int i=start; i<6;i++){
                output[depth] = keys[i];
                getCom(i+1,depth+1,end);
            }
        }
    }
    static class Point{
        int r;
        int c;
        int keys; //조합번호 들어감
        StringBuilder sb = new StringBuilder();
        public Point(int r, int c, int keys){
            this.r = r;
            this.c = c;
            this.keys = keys;
        }


    }


}
