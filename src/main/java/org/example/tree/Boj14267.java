package org.example.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj14267 {
    static int V;
    static Node[] grap;

    public static void main(String[] args) throws IOException {
        //모든 칭찬에는 수치
        // 수치가 부하한테 전의됨
        // 직원수 n 끝이 없음..
        // m 10만 칭찬 횟수
        // m줄에는 칭찬 번호i 수치 w
        // n명의 직속 상사의 번호가 주어짐
        // 직속상사 번호는 자신보다 작으며
        // 사장은 1이어서 상사 없음 -1
        //

        //1번부터 n번까지 칭찬 정도를 출력하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        grap = new Node[V + 1];

        //칭찬을 셋팅해 m 만번
        // 그 다음 다시 칭찬을 셋팅해

        //방향이 있고 그걸 알려줘
        //Node에 본인 칭찬 받은거랑
        // 부하직원 리스트를 두면
        //n번 따로 하고, m+m

        //먼저 배열과 List초기화
        for (int i = 1; i <= V; i++) {
            Node node = new Node();
            node.number = i;
            grap[i] = node;
        }

        //상사 정보 넣기 트리만들기 방향 알려줌!
        //현재 i가 직원 arr[i]는 상사번호
        int arrCnt = 1;
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 2; i <= V; i++) {
            grap[arr[arrCnt++]].child.add(grap[i]);
        }
        //초기 칭찬 셋팅해
        while (m-- > 0) {
            String[] sinput = br.readLine().split(" ");
            int employee = Integer.parseInt(sinput[0]);
            int cheerUp = Integer.parseInt(sinput[1]);
            grap[employee].cheerUp += cheerUp;
        }

        //내리 사랑 셋팅
        downLove(1);

        //출력용
        for (int i = 1; i <= V; i++) {
            bw.write(grap[i].cheerUp + " ");
        }
        bw.flush();
        bw.close();


    }

    private static void downLove(int root) {

        for (Node ch : grap[root].child) {
            ch.cheerUp += grap[root].cheerUp;
            downLove(ch.number);
        }
    }

    static class Node {
        int number;
        int cheerUp;
        List<Node> child;

        public Node() {
            child = new ArrayList<>();
            cheerUp = 0;
        }
    }
}
