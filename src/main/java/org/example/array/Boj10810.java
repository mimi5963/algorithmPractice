package org.example.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj10810 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int num = Integer.parseInt(s[0]);
        int cm = Integer.parseInt(s[1]);
        int[] arr = new int[num];

        while (cm > 0){

            String[] input = br.readLine().split(" ");

            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);

            fillArray(i-1,j-1,k,arr);
            cm--;
        }

        Arrays.stream(arr).forEach((nums) -> {
            System.out.print(nums +" ");
        });

    }

    private static void fillArray(int i, int j, int k,int[] arr) {
        for(;i<=j;i++){
            arr[i] = k;
        }
    }
}
