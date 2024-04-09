package org.example.array;

import java.io.*;

public class Boj3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[1000001]; //수를 담는 배열

        String[] sinput = br.readLine().split(" ");

        int target = Integer.parseInt(br.readLine()); //쌍을 구할 숫자

        int cnt=0;

        for(int i=0; i<n;i++){
            arr[Integer.parseInt(sinput[i])] = true;
        }

        for(int i=1; i<1000001; i++){
            if(arr[i] == false) continue;
            int findIdx = target-i;
            if(findIdx > 0 && findIdx <= arr.length && arr[findIdx] == true && findIdx > i){
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
