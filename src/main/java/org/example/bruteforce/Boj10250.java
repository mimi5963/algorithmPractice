package org.example.bruteforce;

import java.io.*;

public class Boj10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0){
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int cus = Integer.parseInt(input[2]);



            //나중에 조정해보자  층수는 무조건 맞는데 호수가 문제임 ! 일단 완탐으로 바꾸자
            //층이 6개이고 방이 12개 10번째 손님 402호
            //10-6*1 =4 몫에 +1 방호수, 나머지가 층수 ?
            //72 - (30*2) 3호 12층 03호

            String result = getRoomNum(h,w,cus);

            bw.write(result+"\n");

        }

        bw.flush();
        bw.close();
    }

    private static String getRoomNum(int h, int w, int cus) {
        //1층부터 검사해서 h층까지 갔다가 다시 w++하고 다시 검사
        int cnt=1;
        for(int roomW =1 ;roomW <= w; roomW++){
            for(int roomH =1;roomH <= h; roomH++){
                if(cnt == cus){
                    String result = roomH+"";
                    result+= roomW > 9 ? roomW:"0"+roomW;
                    return result;
                }
                cnt++;
            }
        }
        return "false";
    }
}
