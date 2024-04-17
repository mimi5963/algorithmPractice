package org.example.recursion;

import java.io.*;
import java.util.Arrays;


public class Boj15655 {
    static int n;
    static int m;

    static boolean isUsing[];
    static int[] numbers;

    static int[] output;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);


        isUsing = new boolean[n];
        output = new int[n];
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        recursiveCombination(0,0);
    }

    private static void recursiveCombination(int depth,int start){

        //Base Case
        if(depth == m){

            StringBuilder sb = new StringBuilder();


                for (int i = 0; i < m; i++) {

                    sb.append(output[i] + " ");
                }
                System.out.println(sb);



                return;


        }else{

            //Recursive case

            for(int i=start; i<numbers.length;i++){
                if(!isUsing[i]){

                    isUsing[i] = true;


                    output[depth] = numbers[i];

                    recursiveCombination(depth+1,i+1);


                    isUsing[i] = false;
                }
            }

        }



    }

}
