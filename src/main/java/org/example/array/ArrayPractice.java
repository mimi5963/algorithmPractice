package org.example.array;

public class ArrayPractice {
    public static void main(String[] args) {

    }

    public static boolean eraseElement(int[] arr, int idx){
        if(idx >= arr.length){
            return false;
        }
        //앞으로 땡겨서 없애기 arr[i] = arr[i+1]
        for(int i=idx; i<arr.length;i++){
            arr[i] = arr[i+1];
        }
        return true;
    }

    public static boolean insertElement(int[] arr,int idx, int val){
        if(idx >= arr.length){
            return false;
        }
        for(int i=arr.length-2; i > idx;i--){
            arr[i] = arr[i-1];
        }
        arr[idx] = val;
        return true;
    }
}
