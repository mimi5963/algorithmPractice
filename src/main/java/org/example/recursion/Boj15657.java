package org.example.recursion;

import java.io.*;
import java.util.Arrays;

public class Boj15657 {

    static int n;
    static int m;
    static int[] numbers;
    static int[] output;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        output = new int[n];
        numbers  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        RecursiveCombinationWithItSelf(0,0);

        bw.flush();
        bw.close();


    }

    private static void RecursiveCombinationWithItSelf(int depth,int start) throws IOException {

        if(depth == m){

            for(int i=0; i<m;i++){
                bw.write(output[i]+" ");
            }
            bw.write("\n");

        }else{

            for(int i=start; i<n; i++){
                output[depth] = numbers[i];
                RecursiveCombinationWithItSelf(depth+1,i);
            }



        }



    }



}
