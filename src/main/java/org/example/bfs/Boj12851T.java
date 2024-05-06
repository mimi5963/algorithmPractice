package org.example.bfs;

import java.util.*;

public class Boj12851T {

        static int n,k;
        static int[] dx = {-1,1,2};
        static int[] visited;

        static int[] count;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            k = sc.nextInt();
            visited = new int[100001];
            count = new int[100001];
            if(n == k){
                System.out.println(0);
                System.out.println(1);
                return;
            }

            Queue<Integer> que = new LinkedList<>();
            que.offer(n);
            count[n] =1;
            //최소 시간 구하기
            while (!que.isEmpty()){
                int now = que.poll();

                for(int i=0; i<3;i++){
                    int nextStep;
                    if(i<2) nextStep = now + dx[i];
                    else nextStep = now * dx[i];

                    if(nextStep <0 || nextStep > 100000) continue;

                    if(visited[nextStep] == 0){
                        visited[nextStep] = visited[now]+1;
                        count[nextStep] = count[now];
                        que.offer(nextStep);
                    }else if(visited[nextStep] == visited[now]+1){
                        count[nextStep] += count[now];
                    }

                }
            }



            //방법의 수 구하기 재귀로 해보까? 조합
            System.out.println(visited[k]);
            System.out.println(count[k]);

        }



}
