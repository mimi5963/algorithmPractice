package org.example.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15654T {
    static int n,m;
    static int[] numbers;
    static boolean[] check;
    static int[] output;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        check = new boolean[n];
        output = new int[n];

        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        RecursivePermutation(0);
    }

    public static void RecursivePermutation(int depth){

        //baseCase
        if(depth == m){
            StringBuilder sb = new StringBuilder();
            // todo : 출력
            for(int i=0; i<m; i++){
                sb.append(output[i] +" ");
            }
            System.out.println(sb);
            return;
        }

        //recursive case

        for(int i=0; i<n;i++){
            if(!check[i]){
                check[i] = true;
                output[depth] = numbers[i];
                RecursivePermutation(depth+1);
                check[i] = false;
            }
        }


    }
}
