package org.example.string;

import java.io.*;

public class Boj1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().toUpperCase();
        int maxCnt = -1;
        char reAlp = '?';
        for(char alp = 'A'; alp <='Z' ; alp++){
            int alpCount = getCountAlp(input,alp);
            if(maxCnt < alpCount){
                reAlp = alp;
                maxCnt = alpCount;
            } else if (maxCnt == alpCount) {
                reAlp ='?';
            }
        }
        bw.write(reAlp+"");
        bw.flush();
        bw.close();
    }

    private static int getCountAlp(String input, char alp) {
        int val =0;
        for(int i=0; i<input.length();i++){
            if(input.charAt(i) == alp) val++;
        }
        return val;
    }
}
