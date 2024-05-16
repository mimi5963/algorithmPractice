package org.example.bruteforce;


import java.util.Scanner;

public class Boj3085T {


        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++)
                map[i] = sc.next().toCharArray();

            // 전체 맵 다 탐색함 한번 교환할 때 마다, 따라서, 모든 사탕을 교환할 필요는 없고
            // 이미 교환해본 건 또 교환할 필요 없음
            // visited로 처리해도 상관없겠다만, 이런 2차원 배열에서는 증가하는 방향으로만 교환하면 visited 없이
            // 해결 가능하다
            int ans = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    // swap right
                    if (j + 1 < N) {
                        swapCandy(map, i, j, i, j + 1);
                        ans = Math.max(ans, calcScore(map));
                        swapCandy(map, i, j, i, j + 1);
                    }
                    // swap below
                    if (i + 1 < N) {
                        swapCandy(map, i, j, i + 1, j);
                        ans = Math.max(ans, calcScore(map));
                        swapCandy(map, i, j, i + 1, j);
                    }
                }
            System.out.println(ans);
        }


    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }
    public static int calcScore(char[][] map) {
        int N = map.length;
        int maxScore = 0;
        // 가장 긴 연속 column 길이 찾기
        for (int r = 0; r < N; r++) {
            int scr = 1;
            for (int c = 1; c < N; c++) {
                if (map[r][c] == map[r][c - 1]) scr++;
                else {
                    maxScore = Math.max(maxScore, scr);
                    scr = 1;
                }
            }
            maxScore = Math.max(maxScore, scr);
        }
        // 가장 긴 연속 row 길이 찾기
        for (int c = 0; c < N; c++) {
            int scr = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r - 1][c]) scr++;
                else {
                    maxScore = Math.max(maxScore, scr);
                    scr = 1;
                }
            }
            maxScore = Math.max(maxScore, scr);
        }
        return maxScore;
    }
}