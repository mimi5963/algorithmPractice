package org.example.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Retry {
    static List<Integer>[] gra;
    static int[] parents;
    static boolean[] check;
    static int V;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        V = Integer.parseInt(br.readLine());
        int n = V-1;

        //부모노드정보 저장용
        parents = new int[V+1];
        //방문 체크용
        check = new boolean[V+1];

        gra = new List[V+1];
        //그래프 초기화
        for(int i=1; i<=V;i++){
            gra[i] = new ArrayList<>();
        }
        //루트 노드는 무조건 1임
        //트리는 순환이 없는 무방향이라고 생각해요
        while(n-- >0){
            String[] input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            //연결 관계 초기화
            gra[n1].add(n2);
            gra[n2].add(n1);
        }

        //1번이 root
        setParent(1);
        for(int i=2; i<=V;i++){
            bw.write(parents[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
    static void setParent(int node){
        //BASE CASE
        if(check[node]){
            return; // 이미 부모 노드를 찾은 친구들은 돌아가
        }else{
            //RECURSIVE CASE
             check[node] = true;
            for(int i : gra[node]){
                if(!check[i]) {
                    parents[i] = node;
                    setParent(i);
                }
            }
        }

    }
}
