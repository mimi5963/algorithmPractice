package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2606 {

    static int n;
    static int m;
    static int[][] grap;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        grap = new int[n+1][n+1];
        check = new boolean[n+1];

        //입력받기
        for(int i=0; i<m;i++){
            String[] sinput = br.readLine().split(" ");
            int n1 = Integer.parseInt(sinput[0]);
            int n2 = Integer.parseInt(sinput[1]);

            grap[n1][n2] = 1;
            grap[n2][n1] = 1;
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        check[1]= true;

        int sum = -1;
        while(!que.isEmpty()){

            int node = que.poll();
            sum++;

            for(int i=1;i<grap.length;i++){
                if(grap[node][i] == 1 && !check[i]){
                    que.offer(i);
                    check[i] = true;
                }
            }

        }

        System.out.println(sum);



    }
}
