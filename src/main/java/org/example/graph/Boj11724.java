package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj11724 {
    static int n;
    static int m;
    static List<Integer>[] gr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sinput = br.readLine().split(" ");
        n = Integer.parseInt(sinput[0]);
        m = Integer.parseInt(sinput[1]);
        check = new boolean[n+1];
        gr = new List[n+1];

        //list 초기화
        for(int i=1; i<=n;i++){
            gr[i] = new ArrayList<>();
        }

        //간선 연결
        for(int i=0; i<m;i++){
            String[] values = br.readLine().split(" ");
            int n1 = Integer.parseInt(values[0]);
            int n2 = Integer.parseInt(values[1]);
            gr[n1].add(n2);
            gr[n2].add(n1);
        }

        //dfs함 수행
        //끝나서 돌아올꺼아녀? check배열 함 확인
        // 아직 비었어? 안비었어? 그럼 갈겨


        int sub =0;
        //root도 없네

        //check[i] == true 면 그냥 가고 false 면 dfs 한번 쓱 돌아
        //모두 수행한거면 check가 모두 true여야함
        //중간에 연결 끊긴거면 또 돌게 되어 있다. 이거 다해봐야 n번 1000임
        for(int i=1; i<=n;i++){
            if(check[i])continue;
            else{
                sub++;
                dfs(i);
            }
        }

        System.out.println(sub);
    }
    static void dfs(int node){
        check[node] = true;
        for(int i : gr[node]){
            if(!check[i]){
                dfs(i);
            }
        }
    }
}
