package org.example.bruteforce;

import java.io.*;
import java.util.Arrays;

public class Boj1730 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] result = new char[n][n];
        String input = br.readLine();
        String sinput = input == null ? "" : input;

        //일단 전부 .으로 채우기
        for(int i=0; i<n;i++){
            Arrays.fill(result[i],(char)46);
        }

        //첫 시작 위치
        int x =0;
        int y =0;


        for(char ch : sinput.toCharArray()){

            //판화를 벗어나는 입력은 무시한다!
            int commandX=x;
            int commandY=y;

            if(ch == 'U'){
                commandY--;
            }else if(ch == 'D'){
                commandY++;
            }else if(ch == 'R'){
                commandX++;
            }else if(ch == 'L'){
                commandX--;
            }

            //판화를 벗어나지 않는 입력임을 확인 x,y는 이전이고 command는 움직인 것
            if(commandX < 0 || commandX >= n || commandY < 0 || commandY >= n){
                continue;
            }

            // 입력에 알맞은 char 가져오기
           char putChar = getPutChar(ch);

            //일단 다음 경로는 무조건 이걸로 해두기

            putchar(commandX,commandY,putChar,result);
            putchar(x,y,putChar,result);
            x=commandX;
            y=commandY;
        }


        for(int i=0; i<n;i++){
            String resultString="";
            for(int j=0; j<n;j++){

                resultString += result[i][j];
            }
            System.out.println(resultString);
        }

    }




    private static char getPutChar(char ch) {
        char result =(char)45;

        if(ch == 'U' || ch == 'D'){
            result = (char)124;
        }

        return result;
    }

    private  static  boolean isBound(int x,int y, int n){
        return (x >= 0 && x < n) && (y >= 0 && y < n) ;
    }

    private static void putchar(int x, int y, char putChar, char[][] result){
        if(result[y][x] == putChar || result[y][x] ==(char)46){
            result[y][x] = putChar;
        }else{//그게 아니라면 43
            result[y][x] =(char)43;
        }
    }
}
