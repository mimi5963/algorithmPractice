package org.example.bruteforce;

import java.io.*;
import java.util.Arrays;

public class Boj3085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] carr = new char[n][n];
        int i=0;
        while(i<n){
            String input = br.readLine();
            //일단 배열 채우고
            fillArray(carr,input,i,n);
            i++;
        }

        int result = findMaxCandy(carr,n);

        System.out.println(result);
    }

    private static int findMaxCandy(char[][] carr,int n) {
        int[] resultRight = new int[4];
        int[] resultDown = new int[4];
        //C.P,Z,Y 임
        //0,1,2,3
        String color = "CPZY";


        //정리 진행 방향은 오른쪽 (x+), 아님 아래(y+) 동시에 하지말고 나누자
        // 오른쪽 진행방향일 경우 -> CPZY순서로 찾아 ->
            //다음문자가 같지 않을 경우
           // 위(y-)나 아래(y+) 먼저 같은 문자 있는지 검색 없으면 x+ -> 계속진행
          //  각각 가장 많은 캔디 리턴
         //y-1,y+1,x+1검사시 n을 넘는지 안넘는지 체크
        // 아래 진행방향
        //다음문자가 같지 않을 경우
        // 양 옆에서 먼저 찾고 (x+,x-), 없으면 진행방향(y+)탐색 가져와서 더하기

        // 두 경우 모두 진행방향에서 캔디를 가져와서 자리를 바꾼 경우 더 나아갈 수 없음으로 break;

        int cnt = 0;

        //한개 문자씩 검색 아 한번밖에 못바꾸지
        while(cnt < 4) {
            char ch = color.charAt(cnt);
            int right = 0;
            int down = 0;

            //오른쪽 검사
            for (int y = 0; y < n; y++) {
                int max=0;
                boolean swap = false;
                for(int x=0; x<n ; x++){

                    if(carr[y][x] == ch){
                        max++;
                    }else if(carr[y][x] != ch && max >0 && swap==false){
                        swap = true;
                        if(y-1 >0 && carr[y-1][x] == ch){
                            max++;
                        }else if(y+1 <n && carr[y+1][x] == ch){
                            max++;
                        }else {
                            if(x+1 < n && carr[y][x+1] == ch){
                                max++;
                            }
                            break;
                        }
                    }
                }
                // 최대 값으로 채워 주기
                right = right > max ? right:max;
            }



            //아래 진행방향 검사
            for (int x = 0; x < n; x++) {
                int max=0;
                boolean swap = false;
                for(int y=0; y<n ; y++){

                    if(carr[y][x] == ch){
                        max++;
                    }else if(carr[y][x] != ch && max >0 && swap==false){
                        swap = true;
                        if(x-1 >0 && carr[y][x-1] == ch){
                            max++;
                        }else if(x+1 <n && carr[y][x+1] == ch){
                            max++;
                        }else {
                            if(y+1 < n && carr[y+1][x] == ch){
                                max++;
                            }
                            break;
                        }
                    }
                }
                // 최대 값으로 채워 주기
                down = down > max ? down:max;
            }

            resultRight[cnt] = right;
            resultDown[cnt] = down;

            cnt++;
        }

        Arrays.sort(resultRight);
        Arrays.sort(resultDown);

        return resultRight[3] > resultDown[3] ? resultRight[3]:resultDown[3];

    }

    public static void fillArray(char[][] arr,String input,int i,int n){
        for(int j=0; j<n;j++){
            arr[i][j] = input.charAt(j);
        }
    }
}
