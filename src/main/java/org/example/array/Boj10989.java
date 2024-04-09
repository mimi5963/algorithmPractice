package org.example.array;

import java.io.*;

public class Boj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int[] narr = new int[10001];
        //10이란 숫자까지 담고 싶으면 11을 만들어야 0~10까지 있는거거둔? 랭쓰는 11이고

        //이게 터질 수 있지
        while (n -- > 0){
            int val = Integer.parseInt(br.readLine());
            //이거 터질 수 있다.
            narr[val]++;
        }

        //1부터 10까지 보는겨 -> 여기는 터질리가 없어 말이안됌
        for(int i=1; i<narr.length;i++){
            int num = narr[i];
            if(num == 0){
                continue;
            }
            for(int j=0; j<num;j++){
                bw.write(i+"\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
