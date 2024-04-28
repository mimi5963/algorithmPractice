package org.example.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Boj15681 {
    static List<Integer>[] grap;
    static boolean check[];
    static int[] subNodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        //정점의 수
        int V = Integer.parseInt(input[0]);
        //트리 루트의 번호
        int R = Integer.parseInt(input[1]);
        //쿼리 수
        int Q = Integer.parseInt(input[2]);

        grap = new List[V+1];
        check = new boolean[V+1];
        subNodes = new int[V+1];
        for(int i=1; i<= V;i++){
            grap[i] = new ArrayList<>();
        }


        String[] Einput;
        for(int i=2; i<=V;i++){
            Einput = br.readLine().split(" ");


            int node1 = Integer.parseInt(Einput[0]);
            int node2 = Integer.parseInt(Einput[1]);

            grap[node1].add(node2);
            grap[node2].add(node1);
        }

        setParent(R);

        while (Q -- > 0){
            int root = Integer.parseInt(br.readLine());
            bw.write(subNodes[root]+"\n");
        }
        bw.flush();
        bw.close();

    }

    static int setParent(int root){
        int sum =0;
        if(check[root]){
            return 0;
        }else{
            check[root] = true;

            for(int i : grap[root]){
                if(!check[i]){
                    sum += setParent(i);
                }
            }
        }
        subNodes[root] = sum+1;
        return sum+1;
    }

//    static int getSubtreeSize(int root){
//        int sum=0;
//        //BASE CASE -> 본인에 자식이 없으면 알아서 끝남
//        for(Node i : grap[root]){
//            //RECURSIVE CASE 부모가 root와 같다면.. sum++하고 내려감
//            if(i.parent == root){
//
//               sum+=getSubtreeSize(i.val);
//            }
//        }
//
//
//        return sum+1;
//    }


//    static class Node{
//        int val;
//        int parent;
//
//    }
}
