package org.example.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Boj11725 {

    static Node[] nodeArr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        //각 노드들이 가지는 자식들 저장할 List
        //List<Node>[] linked = new ArrayList[n+1];
        // 각 노드들 저장할 배열
         nodeArr = new Node[n+1];


        //미리 만들지 말고 그때 그때 연결
        // 노드를 저장하되, 일렬로 번호순으로 할래
        // 일단 쭉 저장한 다음 무조건 1이 부모니까
        // 1부터 child node 쭉쭉 찾아가면서 prent 업데이트
        int cnt = n-1;

        for(int i=1; i<=n; i++){
            Node node =  new Node();
            node.val = i;
            nodeArr[i] = node;
        }

        while(cnt -- >  0){
            String[] sinput =br.readLine().split(" ");
            int v = Integer.parseInt(sinput[0]);
            int k = Integer.parseInt(sinput[1]);
            nodeArr[v].linked.add(nodeArr[k]);
            nodeArr[k].linked.add(nodeArr[v]);
        }

        setParent(nodeArr[1]);

        for(int i=2; i<=n;i++){
            bw.write(nodeArr[i].prentNo+"\n");
        }

        bw.flush();
        bw.close();

    }

    private static void setParent(Node target) {

        //Base Case
        if(target == null){
            return;
        }else{

         for(Node child : target.linked){
             if(child.prentNo != 0){
                 continue;
             }else {
                 child.prentNo = target.val;
             }
             setParent(child);
         }

        }
    }

    private static class Node{
        int prentNo = 0;
        List<Node> linked = new ArrayList<>();

        int val;

    }
}
