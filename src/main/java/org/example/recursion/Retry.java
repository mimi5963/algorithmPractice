package org.example.recursion;

import java.io.*;
import java.util.Arrays;

public class Retry {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] output;
    static boolean[] check;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

         N = Integer.parseInt(input[0]);
         M = Integer.parseInt(input[1]);

         output = new int[N];
        check = new boolean[N];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //정렬 -> 사전순으로 출력
        Arrays.sort(arr);
        //RecursivePermutation2(0);
        //recursiveComb(0,0);
       // recursivePermutation3(0);
        recursiveCombination2(0,0);
        bw.flush();
        bw.close();
    }
    private static void RecursivePermutation2(int depth) throws IOException{
        //BASE CASE
        if(depth == M){
            for(int i=0; i<M;i++){
                bw.write(output[i]+" ");
            }
            bw.write("\n");
        }else{

            //RECURSIVE CASE

            for(int i=0; i<N;i++){
                if(!check[i]){
                    check[i] = true;
                    output[depth] = arr[i];
                    RecursivePermutation2(depth+1);
                    check[i] = false;
                }
            }


        }
    }

    static void recursiveComb(int next, int depth) throws IOException {

        //BASE CASE
        if(depth == M){
            for(int i=0; i<M;i++){
                bw.write(output[i]+" ");
            }
            bw.write("\n");
        }else{

        //RECURSIVE CASE
        //어차피 사전순으로 정렬 1 2 3 4 5 -> 무조건 자신보다 뒤 순서랑 짝지으면 됨
        // 1 3 OK 3 1 X
        //다음으로 선택될 수는 자기 자신보다 앞에 있다
            // 1 -> for문 시작점을 next에 담아서 호출시마다 i+1해준다!
            //
        for(int i=next; i<N;i++){
            if(!check[i]){
                check[i] = true;
                output[depth] = arr[i];
                recursiveComb(i+1,depth+1);
                check[i] = false;
            }
        }


        }


    }

    private static void recursivePermutation3(int depth) throws IOException {
        //BASE CASE
        if(depth == M){
            for(int i=0; i<M;i++){
                bw.write(output[i]+" ");
            }
            bw.write("\n");
        }else{

            //RECURSIVE CASE

            for(int i=0; i<N;i++){

                    output[depth] = arr[i];
                    RecursivePermutation2(depth+1);

            }


        }
    }

    private static void recursiveCombination2(int next, int depth) throws IOException {
        //BASE CASE
        if(depth == M){
            for(int i=0; i<M;i++){
                bw.write(output[i]+" ");
            }
            bw.write("\n");
        }else{

            //RECURSIVE CASE
            //어차피 사전순으로 정렬 1 2 3 4 5 -> 무조건 자신보다 뒤 순서랑 짝지으면 됨
            // 1 3 OK 3 1 X
            //다음으로 선택될 수는 자기 자신보다 앞에 있다
            // 1 -> for문 시작점을 next에 담아서 호출시마다 i+1해준다!
            //
            for(int i=next; i<N;i++){

                    output[depth] = arr[i];
                    recursiveComb(i,depth+1);


            }


        }
    }

}
