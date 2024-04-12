package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3085T {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] candy = new char[n][n];
        int cnt=0;
        //사탕이 들어있는 배열을 먼저 입력받는다.
        int inputCount = n;
        while(inputCount -- >0){
            String input = br.readLine();
            candy[cnt++] = input.toCharArray();
        }

        //행 방향 진행하면서 한 줄 사탕
        int[] rightMax = new int[4];

        //열 방향 한 줄 사탕
        int[] downMax = new int[4];

        char[] color = {'C','P','Z','Y'};

        //행방향으로 진행하면서 사탕을 찾기
        for(int i=0; i<4; i++){
            //문자 선택 지점
            char ch = color[i];

            findRightMax(candy,ch,rightMax,n,i);
            findDownMax(candy,ch,downMax,n,i);

        }

        arraySort(downMax);
        arraySort(rightMax);

        System.out.println(downMax[0] > rightMax[0] ? downMax[0]:rightMax[0]);

    }

    private static void arraySort(int[] array) {

        for(int i=0; i<array.length;i++){
            for(int j=0; j<i;j++){
                if(array[j] < array[i]){
                    int temp = array[i];
                    for(int k=i; k>j;k-- ){
                        array[k] = array[k-1];
                    }
                    array[j] = temp;
                    break;
                }
            }
        }

    }

    private static void findDownMax(char[][] candy, char ch, int[] downMax, int n, int i) {
        for(int x =0; x<n; x++){
            boolean swap = false;
            int cnt =0;
            for(int y=0; y<n; y++){
                //현재 위치가 같은 문자라면 ++
                if(candy[y][x] == ch){
                    cnt++;
                }else{
                    // 다른 문자인 경우
                    if(!swap){

                        if(isBound(x+1,y,n)&&candy[y][x+1] == ch){
                            //오른쪽에서 찾기
                            cnt++;
                            swap = true;
                        }else if(isBound(x-1,y,n) && candy[y][x-1] == ch){
                            //왼쪽에서 문자 찾기
                            cnt++;
                            swap = true;
                        }else{
                            //다음 위치에서 문자 찾기
                            if(isBound(x,y+1,n) && candy[y+1][x] == ch){
                                cnt++;
                                if(downMax[i] < cnt){
                                    downMax[i] = cnt;
                                }
                                cnt=0;

                            }else {
                                break;
                            }

                        }


                    }else{
                        if(downMax[i] < cnt){
                            downMax[i] = cnt;
                        }
                        //한칸 뒤로간다는 말은 다음 위치도 여기서 시작
                        y--;
                        if(isBound(x,y,n) && candy[y][x] == ch){
                            cnt=1;
                        }else{
                            cnt=0;
                        }
                        swap = false;
                    }
                }

            }
            if(downMax[i] < cnt){
                downMax[i] = cnt;
            }


        }
    }

    private static void findRightMax(char[][] candy, char ch, int[] rightMax, int n,int i) {

        for(int y =0; y<n; y++){
            boolean swap = false;
            int cnt =0;
            for(int x=0; x<n; x++){
                //현재 위치가 같은 문자라면 ++
                if(candy[y][x] == ch){
                    cnt++;
                }else{
                    // 다른 문자인 경우
                    if(!swap){

                        if(isBound(x,y-1,n)&&candy[y-1][x] == ch){
                            //위에서 문자 찾기
                           cnt++;
                            swap = true;
                        }else if(isBound(x,y+1,n) && candy[y+1][x] == ch){
                            //아래에서 문자 찾기
                            cnt++;
                            swap = true;
                        }else{
                            //다음 위치에서 문자 찾기
                            if(isBound(x+1,y,n) && candy[y][x+1] == ch){

                                cnt++;
                                if(rightMax[i] < cnt){
                                    rightMax[i] = cnt;
                                }
                                cnt=0;
                            }else {
                                break;
                            }

                        }


                    }else{
                        if(rightMax[i] < cnt){
                            rightMax[i] = cnt;
                        }
                        //한칸 뒤로간다는 말은 다음 위치도 여기서 시작
                        x--;
                        if(isBound(x,y,n) && candy[y][x] == ch){
                            cnt=1;
                        }else{
                            cnt=0;
                        }
                        swap = false;
                    }
                }

            }
            if(rightMax[i] < cnt){
                rightMax[i] = cnt;
            }


        }

    }

    private static boolean isBound(int x, int y, int n){
        return (x>=0 && x<n) && (y>=0 && y<n);
    }
}
