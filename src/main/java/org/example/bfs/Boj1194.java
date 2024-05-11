package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1194 {
    static int n,m;
    static int[][][] visited;
    static int[] dr ={-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] board;
    static char[] keys = {'a','b','c','d','e','f'};
    static char[] doors = {'A','B','C','D','E','F'};
    public static void main(String[] args) {
        //직사각형 미로 탈출

        // 빈칸은 . 언제나 이동
        // 벽은 절대 이동 불가
        // 열쇠 언제나 이동 -> 열쇠 잡음 a,b,c,d,f
        // 열쇠는 여러번 사용할 수 있음
        // 문은 열쇠가 있으면 지나갈 수 있음
        // 민식이는 빈 곳이고 서있는 곳은 0
        // 출구는 1임
        // 4방향밖에 못움직임
        // 아 ..........오케 가는길에 열쇠가 있을 수도 있고,
        //열쇠가 뒤에 있을 수도 있음
        // 열쇠 갯수 만큼 경우의 수가 있다고 볼까?
        // 오케 괜찮을 것 같음

        //key 갯수대로 했더니 문제 발생 b와 c 1나씩 가진 애들이 서로 진로 방해함

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n+1][m+1];
        visited = new int[n+1][m+1][22];//키 조합을 확인...
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

        while (!q.isEmpty()){
            Point now = q.poll();
            if(board[now.r][now.c] == '1'){
                //마지막에 1도 count 하기 떄문에 -1
                System.out.println(visited[now.r][now.c][now.keys]-1);
                return;
            }

            for(int i=0; i<4;i++){
                int nr = now.r+dr[i];
                int nc = now.c+dc[i];
                if(nr <=0 || nr >n || nc <=0 || nc >m) continue;

                char ch = board[nr][nc];

                //경우의 수 따져보자
                Point next = new Point(nr,nc,now.keys);
                next.sb.append(now.sb.toString());

                if(visited[nr][nc][now.keys] == 0 && ch != '#'){
                    //대문자인 경우 -> 키가 있어야 지나갈 수 있음
                    if(Character.isAlphabetic(ch) && Character.isUpperCase(ch)){
                        //문에 해당하는 키가 있으면 지나가기
                        for(char s : now.sb.toString().toCharArray()){
                            if( (s-'a')+'A' == ch){
                                visited[nr][nc][now.keys] = visited[now.r][now.c][now.keys]+1;
                                q.offer(next);
                            }
                        }
                        //이건 그냥 지나갈 수 있음
                    }else if(ch == '.' || ch =='0' || ch =='1'){
                        visited[nr][nc][now.keys] = visited[now.r][now.c][now.keys]+1;
                        q.offer(next);
                        //키인 경우 지나가긴 그냥 지나갈 수 있긴한데, 디멘션 하나 올려
                    }else if(Character.isAlphabetic(ch) && Character.isLowerCase(ch)){
                        //key가 중복가능하다함 근데 여러번 돌려 쓸 수 있어서, 키 이미 있는 경우엔 dimension 올릴 필요 없음

                        //key가 없어서 얻었으면
                        if(now.sb.toString().indexOf(ch) == -1){
                            next.keys = now.keys+(ch-'0');
                            next.sb.append(ch);
                            visited[nr][nc][next.keys] = visited[now.r][now.c][now.keys]+1;
                            q.offer(next);
                        }else{
                            visited[nr][nc][now.keys] = visited[now.r][now.c][now.keys]+1;
                            q.offer(next);
                        }
                    }
                }

            }
        }

        System.out.println(-1);


        //key수로 만 따지면 안됨.. key 조합을 덧셈으로 표현해서 디멘션을 늘려보자
        // 21
    }

    static class Point{
        int r;
        int c;
        int keys;
        StringBuilder sb = new StringBuilder();
        public Point(int r, int c, int keys){
            this.r = r;
            this.c = c;
            this.keys = keys;
        }
    }

    static class check{
        int r;
        int n;
        int de;

    }
}
