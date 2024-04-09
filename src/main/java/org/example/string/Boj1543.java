package org.example.string;

import java.io.*;

public class Boj1543 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sor = br.readLine();
        String tar = br.readLine();

        String replaced = sor.replace(tar,"");
        int lengths = sor.length() - replaced.length();
        int count = lengths/tar.length();
        bw.write(count+"");
        bw.flush();
        bw.close();

    }
}
