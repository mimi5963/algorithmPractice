package org.example.string;

import java.io.*;

public class Boj11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input =null;
        while((input = br.readLine())!=null){
            bw.write(input+"\n");

        }

        bw.flush();
        bw.close();

    }
}
