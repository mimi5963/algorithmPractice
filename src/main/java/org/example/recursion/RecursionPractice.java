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

//        cache[1] =1;
//        cache[2] =1;
//
//        fivoList.add(1);
//        fivoList.add(1);
//         int result = fivo(10);
//         fivo2(10);
//        System.out.println(result);

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int results = RecurSum(arr,arr.length-1);

        System.out.println(results);

        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9},{10}};

//        for(int i=0; i<arr2.length;i++){
//            for(int j=0; j<arr2[i].length;j++){
//                System.out.println(arr2[i][j]);
//            }
//        }

      //  twoForPrint(arr2,arr2.length,arr2[0].length);

        int i = RecursiveBinarySearch(arr, 0, arr.length - 1, 2);

        System.out.println(i);

//        int recursiveTwoSum = twoForSum(arr2,arr2.length);
//
        //for(int i=0 ;i < arr.length-1; i++)


        char arrch [] = "abc".toCharArray();

        // a,b,c,d
        // 4C2 = ab, ac, ad ,ba bc bd, ca,cb,cd 등
        // a, b c d ----> (1)a,b,c,d   (2) 앞에꺼 제외한 n-1개 출력

        //right가 무조건 고정인 이유는 마지막 출력 때문

        RecurPermutatoins(arrch,0,2);

    }

//    private static int twoForSum(int[][] arr2, int length) {
//    }


    private static void RecurPermutatoins(char[] arr, int left, int right){
        if(left == right){
            for(int i =0; i<right; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }else{

            //힌트
            // - for, swap() 재귀호출
            // 같은 변수끼리도 swap()가능
            // right는 고정

            //ABC 교환
            //재귀호출

            //for문으로 재귀를 불러봐?
            // 그럼 원하는 횟수만큼 swap하고

            //길이만큼  -> 이건 무조건임
//            for(int i=0; i<arr.length;i++){
//                //swap
//                swap(arr,0,i);
//                RecurPermutatoins(arr,left+1,right);
//                swap(arr,i,0);
//            }


            if(left == 0){
                //swap 호출() // fixed 된게 없다는 뜻
                //여기서 for문을 하나씩 돌려서 1씩 올리는거 처음에 무죠껀
                for(int i=0; i<arr.length;i++){
                    swap(arr,left,i);
                    //이제 고정된거 1나 있는채로 옮겨감
                    RecurPermutatoins(arr,left+1,right);
                    swap(arr,i,left);
                }
            }else{

                //여기서 출력
                for(int i=0; i<arr.length;i++){
                    swap(arr,left,i);
                    RecurPermutatoins(arr,left+1,right);
                    swap(arr,i,left);
                }


            }






            //다 한다음에 스왑 호출
        }
    }

    private static void swap(char[] arr,int target, int source){

        char temp = arr[target];
        arr[target] = arr[source];
        arr[source] =temp;



    }

    private static void  twoForPrint(int[][] arr, int n, int k ) {
        if(n < 0 || k<0) {
            return;
        }
        twoForPrint(arr, n-1,k);
        int i = arr[n].length;
        twoForPrint(arr,n,i-1);
        System.out.println(arr[n][k]);
    }

    private static int RecurSum(int[] arr, int i) {

        if(i == 0){
            return arr[0];
        }
        int sum  = arr[i] + RecurSum(arr,i-1);
        return sum;
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

//    private static int forFico(int n){
//       int pre1 = 1; //0
//       int pre2 = 1; //1
//       int result = 0;
//       for(int i=2; i<n;i++){
//           result = pre1 + pre2;
//           pre1 = pre2;
//           pre2 = result;
//       }
//    }

    private static int BinarySearch(int[] arr, int n, int target){
        int left = 0;
        int right = arr.length-1;


        while(left <= right){
            int mid = (left + right) /2 ;
           if(target < arr[mid]){
               right = mid -1;
           } else if (target > arr[mid]) {
               left = mid +1;
           }else{
               return mid;
           }
        }


        return -1;
    }

    private static int RecursiveBinarySearch(int[] arr, int left, int right, int target){
        int result = -1;
        if(left <= right){
            int mid = (left + right) / 2;

            if(target < arr[mid]){
             int leftValue =  RecursiveBinarySearch(arr,left,mid-1,target);
             result  = leftValue < result ? result : leftValue;
            }else if(target > arr[mid]){
             int rightValue =  RecursiveBinarySearch(arr,mid+1,right,target);
             result = rightValue < result ? result : rightValue;
            }else{
                return mid;
            }

        }

        return result;
    }


}
