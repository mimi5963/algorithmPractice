package org.example.bruteforce;

import java.io.*;

public class Boj10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //모든 삼각수의 합으로 표현 가능한지 찾는 것
        // 3개의 삼각수의 합으로 표현 가능한가..  n(n+1)/2임

        //자연수 k가 3부터 1000까지 주어진대
        //삼각수를 모두 구해놓고 빼보자 T1부터
        // 제일 가까운 삼각수 부터
        // 5 1+1+3
        // t1 = 1, t2 = 3  -> 값은 4부터
        // 4 =
        // 일단 모든 자연수는 최대 3개의 삼각수의 합으로 표현 가능하대
        // 이말은 일단 삼각수로 무조건 표현 가능하다는 말
        // 4 t1,t1 ---> 본인보다 작은 삼각수 n까지
        // 그냥 무식하게 4-t1 = true인지 확인

        //삼각수를 담았다.

        int n = Integer.parseInt(br.readLine());


        while(n -- >0){
            //number를 받아
            int num = Integer.parseInt(br.readLine());
            //3개 삼각수로 더해지는지 검사
            boolean result = isTnumber(num);

            if(result == true){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }

            }

        bw.flush();
        bw.close();


    }

    private static boolean isTnumber(int num) {
        // 1 1 1 2 2 2는 있어도.. 무조건 뒤에 빼면 앞에게 보다 크넴?


        //4 => t1 t1 t2 //일단 무조건 3개로 해야댐
        //4 - 1 =
        //일단 처음 빼는 수
        int n =1;


        //처음 빼는 수 -> 처음 빼는 수가 지보다 클 때까지
        while(num >= getYureka(n)){

            int diff = num - getYureka(n); //한번 뺐어

            int k=1;

            //만약 5 -1  다음 빼기 찾으러 가야함
            //다음 빼는 수
            while(diff >= getYureka(k)){

                int diff2 = diff - getYureka(k);

                int j=1;

                while (diff2 >= getYureka(j)){

                    int diff3 = diff2 - getYureka(j);

                    if(diff3 == 0){
                        return true;
                    }

                    j++;

                }

                k++;
            }

            n++;
        }

        return false;
    }


    private static int getYureka(int num){
        return num*(num+1)/2;
    }
}
