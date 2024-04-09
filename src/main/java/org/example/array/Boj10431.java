package org.example.array;

import java.io.*;


public class Boj10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int c = 1;


        while(n -- > 0){

            String[] input = br.readLine().split(" ");

            int[] result = getArray(input);
            bw.write(c+" "+getCount(result)+"\n");
            c++;
        }

        bw.flush();
        bw.close();


    }

   private static int getCount(int[] arr){
        int count =0;
        //오름차순 정렬이 목적이고, 나보다 큰 놈중 작은 놈 앞에 서야해
       // 그럼 그냥 앞뒤로만 비교하고, 작은놈 찾으면 그놈을 정렬시키면되는겨
       for(int i=0; i<arr.length;i++){

            if(i>0 &&arr[i-1] > arr[i]){
                int findMinHeightIdx = getIdx(arr,i);
                count += swapPos(arr,findMinHeightIdx,i);
            }
       }

        return count;
   }

    private static int swapPos(int[] arr, int findMinHeightIdx, int k) {
        int cnt = 0;
        int temp = arr[k];
        // 1 2 3 4 5
        for(int i = k-1; i>=findMinHeightIdx;i--){
            arr[i+1] = arr[i];
            cnt++;
        }
        arr[findMinHeightIdx] = temp;
        return cnt;
    }

    private static int getIdx(int[] arr, int k){
        int result =0;
        //본인보다 큰놈중에 제일 작은놈 앞에서부터 검사
        for(int i=0; i<k;i++){
            if(arr[i] > arr[k]){
                result = i;
                break;
            }
        }
        return result;
   }

    private static int[] getArray(String[] input) {

        int[] arr = new int[input.length-1];
        for(int i =1; i<input.length;i++){
            arr[i-1] = Integer.parseInt(input[i]);
        }

        return arr;
    }
}
