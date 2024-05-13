package org.example.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Boj15451 {
    static int t,n;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] arr;
    static int[] arrSorted;
    public static void main(String[] args) throws IOException {
        //1 ~ N 까지 N개로 이루어진 수녕ㄹ
        // 2 <= N <= 1000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t -- > 0){

            n = Integer.parseInt(br.readLine());
            visited = new boolean[n+1];
            graph = new List[n+1];
            for(int i=1; i<=n ;i++){
                graph[i]= new ArrayList<>();
            }

            //배열 초기화
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //배열 정렬
            arrSorted = new int[n];
            for(int i=0; i<n;i++){
                arrSorted[i] = i+1;
            }


            //관계 잇기 방향그래프임 -> 그래프 잇기
            for(int i=0; i<n;i++){
                int target = arr[i];
                int src = arrSorted[i];
                graph[src].add(target);
            }

            //dfs로 방향 그래프 찾아내기
            int cnt=0;
            for(int i=0; i<n; i++){
                int src = arrSorted[i];
                if(!visited[src]) {
                    dfs(src);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }





        //visited 써서 for문 돌면서 하나씩 가삼
        //방문 안했으면, 다시 감 -> 시작점만 가지고 가자 -> 다음꺼 방문 못하고
        // 그러면 for문으로 만들면 쫌...
    }

    public static void dfs(int node){

        for(Integer i : graph[node]){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }

    }
}
