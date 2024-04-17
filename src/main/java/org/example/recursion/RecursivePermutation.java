package org.example.recursion;

public class RecursivePermutation {

    public static void main(String[] args) {
        char[] arr =  "abc".toCharArray();

        RecurPermutatoins(arr,0,3);

        //재귀호출은 while문과 매우 유사해
        // base 조건과 메인 로직 , 재귀 로직 이렇게 이루어짐
        // 호출 되었을 때 하는것, 재귀 로직은 다시 호출해서 while문 종료 하듯이 index 조정하고 하는 역할

    }

    public static void RecurPermutatoins(char[] arr, int left, int right ){

        //호출 종료 로직
        if(left == right){
            for(int i=0; i< right; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }else{

                for(int i = left; i<arr.length;i++){
                    swap(arr,left,i);
                    RecurPermutatoins(arr,left+1,right);
                    swap(arr,left,i);
                }
        }
            //처음에 한번 바꾸는건 무조건 일어나는 일이자너



    }


    public static void swap(char[] arr, int s, int t){
        char temp = arr[s];
        arr[s] = arr[t];
        arr[t] = temp;
    }



}
