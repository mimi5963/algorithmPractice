package org.example.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj5427 {
    static int[] dh = {-1, 1, 0, 0};
    static int[] dw = {0, 0, -1, 1};
    static int[][] svi; //상근이 자리
    static int[][] fvi; //불 자리
    static int w;
    static int h;

    public static void main(String[] args) throws IOException {

        //벽은 visited를 -1로

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = sc.nextInt();
        Deque<Point> q;

        while (testCase-- > 0) {

            w = sc.nextInt();
            h = sc.nextInt();

            svi = new int[h][w];
            fvi = new int[h][w];
            q = new LinkedList<>();


            //배열 초기화
            for (int i = 0; i < h; i++) {
                String input = sc.next();
                for (int j = 0; j < w; j++) {

                    char ch = input.charAt(j);

                    if (ch == '#') {
                        fvi[i][j] = -1;
                        svi[i][j] = -1;
                    }
                    if (ch == '*') {
                        //불자리 확인~~
                        Point fire = new Point(i, j, true);
                        q.addFirst(fire);
                        fvi[i][j] = 1;
                    }
                    if (ch == '@') {
                        Point s = new Point(i, j, false);
                        q.add(s);
                        svi[i][j] = 1;
                    }
                }
            }


            //시작하자마자. 탈출 가능한가? 체크해봐야겠다. 불이 안났고, 상근이 위치에서 탈출가능


            //BFS
            //Q진행하면서, 탈출 가능한지 아닌지도 검사 하자..

            boolean flag = false;
            int result = 0;
            while (!q.isEmpty() && !flag) {
                Point p = q.poll();


                //불일 때랑 상근이일 때랑 나누어 처리한다.

                for (int i = 0; i < 4 && !flag; i++) {
                    int newH = p.h + dh[i];
                    int newW = p.w + dw[i];


                    if (p.isFire) {
                        //불일떄
                        if (newW < 0 || newW >= w || newH < 0 || newH >= h) continue;

                        if (fvi[newH][newW] != -1 && fvi[newH][newW] == 0) {
                            fvi[newH][newW] = fvi[p.h][p.w] + 1;
                            q.offer(new Point(newH, newW, true));
                        }

                    } else {


                        //불쌍한 상근이
                        //갈 수 없는 자리
                        //불 visted +1 자리 (방문 한 적 없지만, 곧 불 날 자리) -> 불이 안났거나 +1초 이후에 불날 자리는 가두댐
                        //불 visted랑 상근이 visited가 같은 자리 (불이 난 자리)
                        if (newW < 0 || newW >= w || newH < 0 || newH >= h) {
                            result = svi[p.h][p.w];
                            flag = true;
                        } else if (svi[newH][newW] != -1 && svi[newH][newW] == 0) {

                              if (fvi[newH][newW] == 0 || fvi[newH][newW] - svi[p.h][p.w] > 1) {
                                svi[newH][newW] = svi[p.h][p.w] + 1;
                                q.offer(new Point(newH, newW, false));
                                result = svi[newH][newW];
                            }
                        }
                    }
                }
            }

            if (flag) bw.write(result + "\n");
            else bw.write("IMPOSSIBLE\n");
        }

        bw.flush();
        bw.close();

        //탈출했는지 못했는지는, 마지막 상근이의 위치들을 기준으로
        // 동서남북으로 진행했을 때, 배열의 위치를 벗어날 수 있으면 탈출,아니면 불가
        // 그러므로 마지막 출력은 가장 큰 시간 +1
    }

    static class Point {
        int h;
        int w;
        boolean isFire;

        public Point(int y, int x, boolean isFire) {
            this.h = y;
            this.w = x;
            this.isFire = isFire;
        }
    }
}
