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
        //그럼 check를 배열말고 다른걸로하면 쫌 빠르지않나.
        //아하 아니다 dfs를 수행하면서, 수를 저장하자 이게 V랑 같아야 다 돌았으
        int sum =1;
        int sub =1;
        //root도 없네
        //그러 ㅁ그냥 1부터 하지뭐
        while(sub != n){
            
        }

    }
}
