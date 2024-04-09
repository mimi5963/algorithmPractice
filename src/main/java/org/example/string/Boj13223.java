package org.example.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj13223 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] start = br.readLine().split(":");
        String[] end = br.readLine().split(":");

        int startSecond = getSecond(start);
        int endSecond = getSecond(end);

        int diff = endSecond - startSecond;
        if(diff <= 0){
            diff += 24*3600;
        }

        getTime(diff);
    }

    public static int getSecond(String[] tar){

        return (Integer.parseInt(tar[0])*3600)+(Integer.parseInt(tar[1])*60)+(Integer.parseInt(tar[2]));
    }

    public static void getTime(int diff){


        int h = diff / 3600;

        int m = (diff % 3600) / 60;

        int s = (diff % 3600) % 60;

        System.out.printf("%02d:%02d:%02d",h,m,s);


    }

}
