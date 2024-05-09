package org.example.bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2206 {
    //N*M의 행렬 맵이 있어요
    //0은 이동 가능 1은 이동불가
    //1에서 N,M 위치로 가고파 최단 경로 가장 적은 칸수지난 것
    //** 시작 칸 끝나는 칸 포함
    // 만약 벽을 부수고 이동하는 것이 더 경로가 짧아지면 벽을
    //한개 부술 수 있음

    //내가 볼땐.. 모든 벽을 부수는 것도 아니고,
    // 뭐랄까 어떤 벽을 부수는게 최적인지 조건을 따져보야해

    //벽이 없다고 치고 한바퀴 돈거랑 벽이 있을 때 돈 거랑 비교
    //벽이 없다고 치고 돌았을 때 도달한 친구가 벽 1개만 부순거면 이친구 윈


    //탈출 불가능시 -1 출력
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int Y,X;
    static long[][] visited;
    static long[][] visitedBreakWall;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();
        int[][] road = new int[Y+1][X+1];
        visited = new long[Y+1][X+1];
        visitedBreakWall = new long[Y+1][X+1];

        //배열 초기화
        for(int i=1; i<=Y;i++){
            String input = sc.next();
            for(int j=1; j<=X;j++){
                road[i][j] = input.charAt(j-1) - '0';
            }
        }

        //Q도 한번만 돌아두댐 - 먼저 벽이 없다고 치고 돌기 -> 벽 만나면 한번만 부수도록
        //어차피 먼저 간놈이 한번 부쉈던, 안부쉇던 먼저 간놈이 있을 꺼임

        //이렇게 해보자 탐색을하면서, 벽을 만나면 그자리에서 멈춰
        // 그 멈춘 자리들을 시작점으로 다시 벽 못부수는 걸로 돌아 어? 괜찮은 생각인데?
        // visited는 초기화 하되, 벽 만난 자리의 visited는 기억해야함
        // 만약 벽을 안만나고, 골인 했다면 -> 첫 큐에서 이 값도 기억해 둬야함


        Queue<Position> q = new LinkedList();
        Queue<Position> sq = new LinkedList<>();
        q.offer(new Position(1,1));
         visited[1][1] = 1;

         //처음 Q돌리기 이때 벽 무조건 못지나가게 하고, 벽 만난 자리 기억하기

        //벽 안만나고 탈출했을 때
        boolean isEscaped = false;
        //벽 한번 부수고 탈출 했을 때
        boolean isEscaped2 = false;
        long result=0;
        long result2=0;

        while (!q.isEmpty()){
            Position now = q.poll();

            if(now.y == Y && now.x == X){
                isEscaped = true;
                result = visited[now.y][now.x];
                break;
            }

            for(int i=0; i<4; i++){
                int newY = now.y+dy[i];
                int newX = now.x+dx[i];
                if(!isBoundary(newY,newX)) continue;

                //벽 무조건 불통
                if(visited[newY][newX] == 0 && road[newY][newX] == 0){
                    visited[newY][newX] += visited[now.y][now.x]+1;
                    q.offer(new Position(newY,newX));

                    //한번만 부수고 저장 한번 부순놈은 저장 x
                }else if(road[newY][newX] == 1 && visitedBreakWall[newY][newX] == 0){
                    visitedBreakWall[newY][newX] += visited[now.y][now.x]+1;
                    sq.offer(new Position(newY,newX));
                }
            }
        }
        //

        //벽 한번 봐준 후 큐 돌기 근데 특수한 상황이 있음 정답 바로 옆에 벽 때문에
        // 뚫지 않아도 괜찮을 벽 뚫고 와서 이상한 값 넣는 경우 처리해야함
        // 이미 방문한 곳 다시 방문했을 때 더 값이 작다면 바꿔주자

        while (!sq.isEmpty()){
            Position now = sq.poll();

            if(now.y == Y && now.x == X){
                isEscaped2 = true;
                result2 = visitedBreakWall[now.y][now.x];
            }

            for(int i=0; i<4; i++){
                int newY = now.y+dy[i];
                int newX = now.x+dx[i];
                if(!isBoundary(newY,newX)) continue;

                //벽 무조건 불통
                if(visitedBreakWall[newY][newX] == 0 && road[newY][newX] == 0){
                    visitedBreakWall[newY][newX] += visitedBreakWall[now.y][now.x]+1;
                    sq.offer(new Position(newY,newX));
                }else if(visitedBreakWall[newY][newX] != 0 && road[newY][newX]==0){
                    long newtemp = visitedBreakWall[now.y][now.x] +1;
                    if(visitedBreakWall[newY][newX] > newtemp){
                        visitedBreakWall[newY][newX] = newtemp;
                    }
                }
            }
        }
        //
        if(!isEscaped && !isEscaped2){
            System.out.println(-1);
        }else if(!isEscaped && isEscaped2){
            System.out.println(result2);
        }else if(isEscaped && !isEscaped2){
            System.out.println(result);
        }else {
            System.out.println(Math.min(result,result2));
        }





    }

    static boolean isBoundary(int y, int x){
        return (x>0 && x<=X) && (y>0 && y<=Y);
    }

    static class Position{
        int y;
        int x;

        boolean isBreakWall;

        public Position(int y,int x){
            this.x =x;
            this.y =y;

        }
    }
}
