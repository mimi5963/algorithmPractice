package org.example.recursion;

import java.io.*;
public class Boj2747 {
    private static int[] cache = new int[50];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        cache[1] = 1;
        cache[2] = 1;

        int result = fivo(n);

        System.out.println(result);

    }
    private static int fivo(int n){

        if(cache[n] != 0) return cache[n];

        cache[n] = fivo(n-1) + fivo(n-2);

        return cache[n];
    }
}
