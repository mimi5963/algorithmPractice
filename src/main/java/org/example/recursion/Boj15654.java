package org.example.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Boj15654 {
    private static List<ResultString> resultList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM  = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        //배열 채우기
        int[] arr;
        String[] numbers = br.readLine().split(" ");
        arr = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();

        //사전순서를 위해 한번
        Arrays.sort(arr);

        RecursivePermutation(arr,0,M);

        //resultList를 함 정렬해
        resultList.sort((o1,o2)->{
            int[] arr1 = Arrays.stream(o1.result.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr2 = Arrays.stream(o2.result.split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=0; i<arr1.length;i++){
                if(arr1[i] == arr2[i]) continue;
                return arr1[i] - arr2[i];
            }
            return 0;
        });

        for(int i=0; i<resultList.size();i++){
            bw.write(resultList.get(i).result+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void swap(int[] arr,int target, int source){
        // 10, 5 교환
        // 15
        // arr[source] = 15 - 5 => 10
        // arr[target] = 15 - 10 = 5;
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }



    private static void RecursivePermutation(int[] arr, int left, int right) {

        if(left == right){
            StringBuilder sb = new StringBuilder();
            ResultString rs = new ResultString();
            for(int i=0; i<right;i++){
                sb.append(arr[i] +" ");
            }
            rs.result = sb.toString();
            rs.noBlank = rs.result.replaceAll(" ","");
            resultList.add(rs);
        }else{
            for(int i=left; i<arr.length;i++){
                swap(arr,left,i);
                RecursivePermutation(arr,left+1,right);
                swap(arr,left,i);
            }
        }



    }
    static class ResultString{
        String noBlank;
        String result;
    }

}
