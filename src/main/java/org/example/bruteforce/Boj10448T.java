package org.example.bruteforce;

import java.io.*;

public class Boj10448T {

    static boolean[] isEurekaNumber = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        //이렇게 테스트 케이스마다 바뀌는 변수가 아닌 상수들은 따로 관리
        // 삼각수와 유레카 넘버 둘다 테스트케이스마다 바뀌는 수가 아님




        int n = Integer.parseInt(br.readLine());
        preprocess();
        while(n-->0){
            int num = Integer.parseInt(br.readLine());
            //여기서 검사
        }


    }

    //테스트 케이스마다 변하는 것과 변하지 않는 것을 구분하고 전처리!
    private static void preprocess(){
        int[] triangleNumbers = new int[50];
        int tcnt=0;
        boolean[] isSumOfY = new boolean[1001];
        for(int i=0; ; i++){
            int triangleNumber = i* (i+1)/2;
            if(triangleNumber >= 1000)break;
            triangleNumbers[tcnt++] = triangleNumber;
        }

//        for(int i=0; i<tcnt;i++){
//            for(int j=0; j<tcnt;j++){
//                for(int k=0; k<tcnt;k++){
//                    int sum = triangleNumbers[i]+triangleNumbers[j]+triangleNumbers[k];
//                    if(sum <= 1000) isEurekaNumber[sum] = true;
//                }
//            }
//        }

        //범위가 정해진 3개의 수의 합일 때 두개의 합에 하나를 더해서 푸는 스킬
        for(int i=0; i<tcnt;i++){
            for(int j=0; j<tcnt;j++){
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if(sum <= 1000) isSumOfY[triangleNumbers[i]+triangleNumbers[j]] = true; //두개의 삼각수로 이루어진 배열
            }
        }

        for(int i=1; i<=1000;i++){
            if(!isSumOfY[i])continue; //i가 삼각수 두개의 합인지 확인하고
            for(int j=0; j<tcnt; j++){
                int sum = i+triangleNumbers[j]; //i+삼각수
                if(sum <= 1000) isEurekaNumber[sum] = true;
            }

        }


    }
}
