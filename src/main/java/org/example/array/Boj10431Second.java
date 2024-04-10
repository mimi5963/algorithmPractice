package org.example.array;

import java.io.*;
import java.util.Arrays;

public class Boj10431Second {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int classnum = 1;
        while(n-- >0){
            String[] sInput = br.readLine().split(" ");
            int[] intArray = getIntArray(sInput);
            int result = getBackPathNum(intArray);
            System.out.println(Arrays.toString(intArray));
            bw.write(classnum+" "+result+"\n");
            classnum++;
        }

        bw.flush();
        bw.close();

    }

    private static int getBackPathNum(int[] intArray) {

        // 뒤로 밀기 미는 끝 위치 i = len -1 부터 i+1 = i 로 밀면 됨 타겟 위치 t까지 가야 t+1에 t가 저장되고 t 자리 남는다
        // 1 2 3 4 5 6
        int result=0;
        for(int i=0; i<intArray.length;i++){
            //앞으로 돌면서 나보다 큰놈 찾기
            for(int j=0; j<i;j++){
                //큰놈이 있으면 자리 바꿔야함
                if(intArray[j] > intArray[i]){
                    int temp = intArray[i];
                    for(int k=i; k>j;k--){
                        intArray[k] = intArray[k-1];
                        result++;
                    }
                    intArray[j] = temp;
                }
            }
        }
        return result;
    }

    private static int[] getIntArray(String[] sInput) {
        //칸은 한칸 덜 , 숫자는 끝까지 받아야함
        int[] arr = new int[sInput.length-1];
        for(int i=1; i<sInput.length;i++){
            arr[i-1] = Integer.parseInt(sInput[i]);
        }
        return arr;
    }
}
