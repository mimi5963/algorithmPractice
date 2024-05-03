package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj2573 {
    static int r;
    static int c;
    static int[][] arr;
    static boolean[] check;
    static BingSan[] grap;
    static int numOfV=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] colrow = br.readLine().split(" ");
        r = Integer.parseInt(colrow[0]);
        c = Integer.parseInt(colrow[1]);
        arr = new int[r][c];
        check = new boolean[r*c];
        grap = new BingSan[r*c];
        //그래프 정점의 갯수는 r*c고 이어질 수 있는 애들은 4개까지
        //동서남북으로 이어져 있다.


        //매번 dfs나 bfs로 이어진지 안이어진지 검사
        //1년씩 고고
        //빙산의 행과 열 높이를 저장하자
        //1년에 한번씩 줄여 - 배열에도 0 넣고, grap에서 찾아서 0해줘야함

        //처음에 총 연결된 빙산의 갯수를 저장하고
        // 매년 줄어들 때 총 갯수도 빼준 다음에 분리된건지 검사해야함

        //300 * 300 이라 완탐해서 갯수 카운트는 상관없음
        // 이건 그냥 돌릴게
        // bfs나 dfs 시작점은 for문 돌면서 찾는게 맞다
        // 그리고 연결된 갯수랑 남은 빙산 갯수 일치 해야함



        //배열 입력 받기
        for(int i=0; i<r;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        //초기 1회 초기화
        for(int i=0; i<r;i++){
            for(int j=0; j<c;j++){

                if(arr[i][j] == 0) continue;

                int number = j+(i*c);
                BingSan bing = new BingSan();
                bing.height = arr[i][j];
                bing.number = number;
                grap[number] = bing;
            }
        }

        //연결 초기 1회
        for(int i=0;i<grap.length;i++){
            if(grap[i] == null) continue;

            int up = i-c;
            int down = i + c;
            int left = i-1;
            int right = i+1;

            if(checkBoundary(up) && grap[up] != null){
                grap[i].child.add(grap[up]);
            }
            if(checkBoundary(down) && grap[down] != null){
                grap[i].child.add(grap[down]);
            }
            if(checkBoundary(left) && grap[left] !=null){
                grap[i].child.add(grap[left]);
            }
            if(checkBoundary(right) && grap[right] != null){
                grap[i].child.add(grap[right]);
            }

        }

        int age= 0;
        int totalBing=0;
        while (true){
            age++;

            //빙산 줄이기
            happyNewYear();

            // 빙산 갯수 카운트
            totalBing = sumOfBingSan();
            if(totalBing == 0){
                //0될때까지 연결 유지된거임 걍
                System.out.print(0);
                break;
            }
            // 빙산 dfs 연결 갯수 한번 카운트 하고
            int nods=0;
            numOfV = 0;
            check = new boolean[r*c];
           hi:for(int i=0; i<r; i++){
                for(int j=0; j<c;j++){
                    if(arr[i][j] > 0){
                        dfs(j+(i*c));
                        break hi;
                    }
                }
            }
            // 빙산 갯수랑 연결된 갯수 확인해서 다르면 년도, 혹시 빙산이 다 0이 되면 중간에 break
            if(totalBing != numOfV){
                System.out.print(age);
                break;
            }

        }


    }

    private static void dfs(int node){
        if(check[node]){
            return;
        }else{
            check[node] = true;
            numOfV++;
            for(BingSan bi: grap[node].child){
                if(!check[bi.number] && !bi.dead){
                    dfs(bi.number);
                }
            }
        }
    }

    private static void happyNewYear() {
        int[][] cntarr = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(arr[i][j] > 0) {
                    int cnt =0;
                    //동
                    if(checkArrBoundary(j+1,i) && arr[i][j+1] <=0){
                        cnt++;
                    }
                    //서
                    if(checkArrBoundary(j-1,i) && arr[i][j-1] <= 0){
                        cnt++;
                    }
                    //남
                    if(checkArrBoundary(j,i+1) && arr[i+1][j] <= 0){
                        cnt++;
                    }
                    //북
                    if(checkArrBoundary(j,i-1) && arr[i-1][j] <= 0){
                        cnt++;
                    }
//                    int result = arr[i][j] - cnt;
//                    arr[i][j] = result;
//                    if(result  <= 0) {
//                        grap[j + (i * c)].dead = true;
//                    }
                    cntarr[i][j] = cnt;
                }
            }
        }

        for(int i=0; i<r;i++){
            for(int j=0; j<c;j++){
                if(cntarr[i][j] == 0) continue;
                arr[i][j] -=cntarr[i][j];
                if(arr[i][j] <=0){
                    grap[j + (i * c)].dead = true;
                }
            }
        }
    }

    static int sumOfBingSan(){
        int sum=0;
        for(int i=0; i<r;i++){
            for(int j=0; j<c;j++){
                if(arr[i][j] > 0){
                    sum++;
                }
            }
        }
        return sum;
    }

    static boolean checkBoundary(int x){
        return x>=0 && x<r*c;
    }

    static boolean checkArrBoundary(int x, int y){
        return (x>=0 && x<c) && (y>=0 && y<r);
    }

    static class BingSan{
        int height;
        boolean dead = false;

        int number;
        List<BingSan> child = new ArrayList<>();
    }
}
