package org.example.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj14500 {
    static int[][] board;
    static int r, c;

    public static void main(String[] args) {
        //테트로미노
        // 정사각형은 서로 겹치면 안된다.
        // 도형은 모두 연결됨
        // 정사각형은 변끼리 연결, 꼭짓점 연결 x
        // 모양이 총 5개

        //도형이 정해진다 4가지 모양
        //for문을 돌면서 board를 탐색한다.
            //도형의 첫번째 r,c를 입력 받는다.
            //각 도형의 특성에 맞게 r,c를 셋팅한다.
               // for문을 돌면서
                  // 가만있기부터 회전 시키면서 max를 검사한다.

                  //각 회전에는 대칭이 포함된다. 대칭값을 계산하고, 원복
                  // 대칭 값이 범위 내에 있을 떄 -> 계산 -> 원복
                  // 대칭 값이 범위를 벗어날 때 -> 원복

        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new int[r][c];

        //배열 입력 받기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        //배열을 각 모양을 돌려가면서 최대합 구하면됨
        // 일단 일자랑 사각형하자

        // 1자는 시작점을 기준으로 무조건 n ~ n+3까지임
        //

        for(int i=0; i<4; i++){

        }

    }

    static class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    abstract static class Shape{
        List<Point> pointList = new ArrayList<>();

        abstract public void setPoint(int startRow,int startCol);
        abstract public int decal();
        abstract public int rotation();

        public boolean isBound(){
            for (Point point : pointList) {
                if(point.r < 0 || point.r > r || point.c <0 || point.c > c)return false;
            }
            return true;
        }
        public int getValue(){
            int max =0;
            for (Point point : pointList) {
                max += board[point.r][point.c];
            }

            return max;
        }



    }


    static class Horizon extends Shape{

        @Override
        public void setPoint(int startRow,int startCol) {
            if(!super.pointList.isEmpty())pointList.clear();
            for(int i=0; i<4;i++){
                Point p1 = new Point(startRow+i,startCol);
                pointList.add(p1);
            }
        }

        @Override
        public int decal() {
            return getValue();
        }

        @Override
        public int rotation() {
            int[] dr ={2,1,0,-1};
            int max=0;
//            // + - - +   1,2,3,4
            int minus = 1;

            //4번 반복
            for(int i=0; i<4; i++){
                if(i == 0 || i==3){
                    minus = 1;
                }else minus =-1;

                //모두 돌리기
                for(int j=0; j<4;j++){
                    pointList.get(j).r += (dr[j]*minus);
                    pointList.get(j).c += (dr[j]*minus);
                }

                if(!isBound())continue;
                max = Math.max(max,getValue());
            }


            return max;


        }
    }

    static class Square extends Shape{

        @Override
        public void setPoint(int startRow, int startCol) {
            int[] dr = {0,0,1,1};
            int[] dc = {0,1,1,0};

            if(!super.pointList.isEmpty())pointList.clear();

            for(int i=0; i<4; i++){
                Point p1 = new Point(startRow+dr[i],startCol+dc[i]);
                pointList.add(p1);
            }
        }

        @Override
        public int decal() {
            return getValue();
        }

        @Override
        public int rotation() {
            return getValue();
        }
    }


    static class sh1 extends Shape{

        @Override
        public void setPoint(int startRow, int startCol) {
            int[] dr = {0,1,2,2};
            int[] dc = {0,0,0,1};
            if(!super.pointList.isEmpty())pointList.clear();
            for(int i=0; i<4; i++){
                Point p1 = new Point(startRow+dr[i],startCol+dc[i]);
                pointList.add(p1);
            }
        }

        @Override
        public int decal() {
            return 0;
        }

        @Override
        public int rotation() {
            return 0;
        }
    }
}
