package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj9466 {
    static int n,t;
    static int[] arr;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] arrSorted;
    static int cnt;
    public static void main(String[] args) throws IOException {
        // 플젝 팀워 제한 x
        // 한팀도 가능
        // 학생 -> 학생 선택
        // 자기 가신 선택 가능
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());


        while (t -- > 0){
            n = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arrSorted = new int[n];
            for(int i=0; i<n;i++){
                arrSorted[i] = i+1;
            }

            graph = new List[n+1];
            visited = new boolean[n+1];

            //그래프 초기화
            for(int i=1; i<=n ;i++){
                graph[i]= new ArrayList<>();
            }

            //관계 잇기 방향그래프임 -> 그래프 잇기
            for(int i=0; i<n;i++){
                int target = arr[i];
                int src = arrSorted[i];
                graph[src].add(target);
            }

            //dfs로 방향 그래프 찾아내기

            int result = n;
            for(int i=0; i<n; i++){
                int src = arrSorted[i];
                if(!visited[src]){
                    cnt=0;
                    int val = dfs(src);
                    if(val == src){
                        result -= cnt;
                        visited[src] = true;
                    }
                }
            }

            System.out.println(result);
        }
    }
    public static int dfs(int node){

            int nodeVal = 0;
             for(Integer i : graph[node]){
                 if(!visited[i]) {
                    visited[i] = true;
                    cnt++;
                    nodeVal = dfs(i);
                    visited[i] = false;
                 }
             }

             if(nodeVal == 0){
                 return node;
             }else{
                 return nodeVal;
             }

    }
}
