package org.example.bruteforce;

import java.util.Scanner;

public class Boj1476 {

    public static void main(String[] args) {
        //지구 태양 달
        // E,S,M
        // 1~15 E, 1~28 S, 1~19 M
        // 1년은 준규 나라에서는 1 1 1
        // 1년이 지날때 세수 모두 1씩 증가


        //세수는 모두 1씩 증가
        Scanner sc = new Scanner(System.in);
        int TE = sc.nextInt();
        int TS = sc.nextInt();
        int TM = sc.nextInt();

        int[] arr2 = new int[]{TE,TS,TM};
        int[] arr =new int[]{1,1,1};
        int cnt =1;

        while (!isEnd(arr2,arr)){
            arr[0] = arr[0]+1 >15 ? 1:arr[0]+1;
            arr[1] = arr[1]+1 >28 ? 1:arr[1]+1;
            arr[2] = arr[2]+1 >19 ? 1:arr[2]+1;
            cnt++;
        }

        System.out.println(cnt);

    }

    private static boolean isEnd(int[] arr2, int[] arr) {

        for(int i=0; i<3;i++){
            if(arr2[i] != arr[i]) return false;
        }
        return true;
    }
}
