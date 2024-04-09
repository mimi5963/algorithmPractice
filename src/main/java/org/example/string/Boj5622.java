package org.example.string;

import java.io.*;

public class Boj5622 {
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int result =0;

        for(char c : input.toCharArray()) {
                int diff = (c - 'A')/3+2;

                 if(c == 'S' || c == 'V' || diff > 9){
                    diff--;
                }
                result += diff+1;
        }

        System.out.print(result);
    }

}
