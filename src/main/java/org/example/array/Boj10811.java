package org.example.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj10811 {
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int cnt = Integer.parseInt(s[0]);
        int[] arr = new int[cnt];
        for(int i=1; i<=cnt; i++){
            arr[i-1] = i;
        }

        int tc = Integer.parseInt(s[1]);

        while(tc > 0){

            String[] input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            swapArr(arr,i-1,j-1);
            tc--;
        }

        Arrays.stream(arr).forEach((i)->{
            System.out.print(i+" ");
        });
    }

    private static void swapArr(int[] arr, int i, int j) {
       while(i<=j){
           int temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
           i++;
           j--;
       }
    }
}
