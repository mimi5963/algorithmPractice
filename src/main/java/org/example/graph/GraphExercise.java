package org.example.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphExercise {

    public static void main(String[] args) {

        //인접행렬로 그래프 나타내는 방법
        //정점의 갯수와 간선의 갯수 입력
        int v = 10;
        int e = 10;
        int[][] adj = new int[v+1][v+1];

        //연결정보 입력
        for(int i=0; i<e;i++){
            int src = i;
            int dest = i;
            adj[src][dest] = 1;
            //무방향 그래프라면 역방향에 대해서도 작성
            // adj[dest][src] = 1;
        }


        //인접 리스트 간선기반 리스트

        List<Integer>[] graph = new List[v+1];
        for(int i=0; i<=v;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<e;i++){
            int src = i;
            int dest = i;
            graph[src].add(dest);
            //무방향이면 반대도 셋팅
        }

    }


    static class Node{
        int node;
        int cost;

        public Node(int node,int dist){
            this.node = node; //정점번호
            this.cost = dist;
        }
    }

}
