package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj5427T {
    static int [][] visited;
    static int [][] fire;
    static  int n,m;
    static int[] dr ={-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) {
        //탈출경로도 탐색, 불의 전파 경로도 탐색
        // 불의 경로를 먼저 탐색한다.
        // 불이 이동할 때 : 탈출 경로에 대해서 고려할 필요 없음
        // 탈출 할 때 : 현재 옮겨 붙은 불의 위치가 영향을 준다.
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0){

            n = sc.nextInt();
            m = sc.nextInt();
            visited = new int[m][n];
            fire = new int[m][n];

            //재환이 위치
            Queue<Point> q = new LinkedList<>();
            //불 위치
            Queue<Point> fireQ = new LinkedList<>();

            //불과 상근이 위치 초기화
            for(int i=0; i<m;i++){
                String line = sc.next();
                for(int j=0; j<n;j++){
                    char c = line.charAt(j);
                    if(c == '#'){
                        fire[i][j] = visited[i][j] = -1;
                    }else if(c == '@'){
                        q.add(new Point(i,j));
                        visited[i][j] = 1;
                    }else if(c == '*'){
                        fireQ.add(new Point(i,j));
                        fire[i][j] = 1;
                    }
                }
            }

            //불지르기
            while(!fireQ.isEmpty()){
                Point now = fireQ.poll();

                for(int i=0; i<4; i++){
                    int nr = now.r+dr[i];
                    int nc = now.c+dc[i];
                    if(isOutOfRange(nr,nc)) continue;
                    if(fire[nr][nc] ==0) {
                        fire[nr][nc] = fire[now.r][now.c] + 1;
                        fireQ.add(new Point(nr,nc));
                    }
                }
            }

            boolean isEscaped = false;

            while (!q.isEmpty()){
                Point now = q.poll();
                if(isExit(now.r,now.c)){
                    System.out.println(visited[now.r][now.c]);
                    isEscaped = true;
                    break;
                }

                for(int i=0; i<4; i++){
                    int nr = now.r+dr[i];
                    int nc = now.c+dc[i];
                    if(isOutOfRange(nr,nc)) continue;
                    if(visited[nr][nc] != 0) continue;
                    if(fire[nr][nc] == 0 || fire[nr][nc] > visited[now.r][now.c] +1){
                        visited[nr][nc] = visited[now.r][now.c] +1;
                        q.offer(new Point(nr,nc));
                    }
                }
            }

            if(!isEscaped){
                System.out.println("IMPOSSIBLE");
            }


        }

    }

    static boolean isOutOfRange(int r,int c){

        return r < 0 || r>= m || c<0 || c>=n;
    }
    static boolean isExit(int r,int c){

        return r == 0 || r == m-1 || c==0 || c==n-1;
    }

    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r =r;
            this.c =c;
        }
    }
}
