package org.example.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecursionPractice {
    private static List<Integer> fivoList = new ArrayList<>();
    private static int[] cache = new int[50];
    public static void main(String[] args) throws IOException {

//        recursionPrint1(5);
//        recursionPrint2(5);

       // fivoList.add(0);

        cache[1] =1;
        cache[2] =1;

        fivoList.add(1);
        fivoList.add(1);
         int result = fivo(10);
         fivo2(10);
        System.out.println(result);

    }

    private static int fivo2(int i) {

        //먼저 재귀 호출해서 값을 가져와야함
        if(fivoList.size() > i){
            return fivoList.get(i);
        }else{
            //재귀호출해서 결과 저장해두는데 잘 생각하면, fivo2(n-1)이 타고 올라오면서 어느정도 계산함
            //4부터는 i-2 = get(2)해서 바로 가져온다..
           int fivoVal = fivo2(i-1) + fivo2(i-2);
            fivoList.add(fivoVal);
        }
        //최종으로 리턴할 것
        return fivoList.get(i-1) + fivoList.get(i-2);
    }

    private static int fivo3(int n){
        //Base
        if(n==1 || n==2) return 1;
        if(cache[n] !=0 ) return cache[n];

        //Recursive
        cache[n] = fivo3(n-1) + fivo3(n-2);
        return cache[n];
    }

    private static int fivo(int n) {
        if(n <= 0){
            return 0;
        } else if (n <=2) {
            return 1;
        }
        return fivo(n-1) + fivo(n-2);
    }

    private static void recursionPrint1(int n){
        if(n == 0) return;
        System.out.println(n);
        recursionPrint1(n-1);
    }
    private static void recursionPrint2(int n){
        if(n == 0) return;

        recursionPrint2(n-1);
        System.out.println(n);

    }
}
