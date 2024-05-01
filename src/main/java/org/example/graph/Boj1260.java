package org.example.graph;

import java.io.*;
import java.util.*;

public class Boj1260 {
    static int V;
    static int M;

    static List<Integer>[] grep;
    static boolean[] check;

    static boolean[] dcheck;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int root = Integer.parseInt(input[2]);
        grep = new List[V + 1];
        check = new boolean[V + 1];
        dcheck = new boolean[V+1];
        //값 넣기
        for (int i = 1; i <= V; i++) {
            grep[i] = new ArrayList<>();
        }

        //간선 연결
        for (int i = 0; i < M; i++) {
            String[] sinput = br.readLine().split(" ");
            int n1 = Integer.parseInt(sinput[0]);
            int n2 = Integer.parseInt(sinput[1]);
            grep[n1].add(n2);
            grep[n2].add(n1);
        }
        //간선들 정렬해줘야함
        for(int i=1;i<=V;i++){
            Collections.sort(grep[i]);
        }


        //dfs 수행하기
        RecursiveDfs(root);





        bw.write("\n");

        //BFS 수행 하기
        Queue<Integer> que = new LinkedList();
        que.offer(root);
        check[root] = true;
        while (!que.isEmpty()) {

            //맨 처음 레벨
            int peek = que.peek();

            bw.write(peek + " ");

            que.poll();
            //Collections.sort(grep[peek]);
            //peek에 해당하는 노?선? 간?선에 연결하기
            for (int i : grep[peek]) {
                if(!check[i]) {
                   check[i] = true;
                    que.offer(i);
                }
            }

        }

        bw.flush();
        bw.close();


    }

    private static void RecursiveDfs(int node) throws IOException {
        //node연결이 아님
        if(dcheck[node]){
            return;
        }else{
            dcheck[node] = true;
            bw.write(node+" ");
            for(int i : grep[node]){
                RecursiveDfs(i);
            }
        }


    }
}
