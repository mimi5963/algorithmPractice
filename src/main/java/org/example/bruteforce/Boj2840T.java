package org.example.bruteforce;

import java.io.*;

public class Boj2840T {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int curIndex = 0;

        while (n-- > 0){
            int step = Integer.parseInt(br.readLine());
            int nextIndex = curIndex;
            for(int i =0; i< step; i++){
                nextIndex -= 1;
                if(nextIndex < 0) nextIndex = n-1;
            }

            int nextIndex2 = ((curIndex - step) % n +n)%n; //N의 주기를 가지는 환형구조는 %N의 인덱스를 통해 조정 가능 JAVA음수 모듈러는
            //음수 나머지 반환함 주의 -N+1에서 N-1의 범위 -> %n모듈러  뒤에 +n %n이 있는 이유임
            //음수 포함한 환형구조에서 인덱스 관리 0 -2 -3%3 (0,0,0) -

            curIndex = nextIndex;
        }



    }
}
