package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BoJ9019TWO {
     static char[] DSLR={'D','S','L','R'};
    public static void main(String[] args) {
        // 레지스터는 0이상 10,000미만 수
        //DSLR
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test -- >0){
            int start = sc.nextInt();
            int target = sc.nextInt();
            boolean[] visited = new boolean[10000];
            Queue<Register> q = new LinkedList<>();
            q.offer(new Register(start));
            visited[q.peek().num] = true;
            while (!q.isEmpty()){
                Register now = q.poll();

                if(now.num == target){
                    System.out.println(now.sb.toString());
                    break;
                }

                int[] dsrl = {now.getD(), now.getS(),now.getL(),now.getR()};
                for(int i=0; i<4;i++){
                    int nextnum = dsrl[i];
                    if(!visited[nextnum]){
                        Register newregister = new Register(nextnum);
                        newregister.sb.append(now.sb.toString()+DSLR[i]);
                        q.offer(newregister);
                        visited[nextnum] = true;
                    }
                }
            }
        }
    }

    static class Register{
        int num;
        StringBuilder sb = new StringBuilder();
        public Register(int n){
            this.num = n;
        }

        public int getD(){
            return (2*num)%10000;
        }
        public int getS(){
            return num > 0 ? num-1:9999;
        }
        public int getL(){
           //맨 첫번째 자리수 얻어야함 1234 / 1000  -> 1
            // 2340 + 1  -> 뒤에 자릿수는 1234 % 1000 234*10 => 2340 + 1
            return (this.num%1000)*10+(this.num/1000);
        }

        public int getR(){
            //맨 마지막 자리 수 1234 -> 4를 얻어야함  4123
            // 1234%10 -> 4 *1000 = 4000
            // 나머지 123은 1234 / 10 = 123
            return (this.num%10)*1000+(this.num/10);
        }
    }
}
