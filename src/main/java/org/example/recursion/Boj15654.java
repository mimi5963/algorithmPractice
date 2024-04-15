package org.example.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj15654 {
    private static List<String> resultList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        // 숫자담기
        int[] arr = new int[n];
        String[] numbers = br.readLine().split(" ");

        for(int i=0;i<numbers.length;i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }
        //정렬
        Arrays.sort(arr);

        //사전순으로 출력해야함.. 완전 순열 그 잡채

    }

    private static void recus(int[] arr, int n, int k){


        //핵심은
        //  4->3->2->1자리로 가서 1

        // 2 2  1,2   1 2 2 1   이걸 k번 하는거임 n-1씩 내려가는 걸
        //for(int i=0; i<n; i++){
        //    for(int j=0; j<n;j++){
                //if( i == j) continue;
        //      arr[i] +" " + arr[j]
        //    }
        // }

        //n의 수만큼 출력한다.
        //n-1에서 한다
        //k번 반복
        // 4 3 12 ->
        //n-1번쨰 출력한 걸 ~-> 맨 뒤부터 채운다고 보면 됨 k-1졸라 갈겨서
        // 0~n까지 출력하는 것을 k번 반복 댑스 한번 내려갈 수록 쓸 수 있는 값이 -1씩줄어들어
        //근데 그건 전체적인거긴하잖슴? 아 모르겟어



        return;
    }

}
