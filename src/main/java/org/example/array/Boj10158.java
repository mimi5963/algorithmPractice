package org.example.array;

import java.io.*;

public class Boj10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dem = br.readLine().split(" ");
        int w = Integer.parseInt(dem[0]);
        int h = Integer.parseInt(dem[1]);

        String[] initPo = br.readLine().split(" ");
        int x = Integer.parseInt(initPo[0]);
        int y = Integer.parseInt(initPo[1]);

        int totalTime = Integer.parseInt(br.readLine());

        int xSame=0;
        int ySame=0;

        int xMaxDiff = w-x;
        int yMaxDiff = h-y;

        int xminDiff = w+xMaxDiff;
        int yminDiff = h+yMaxDiff;

        int xpos=x;
        int ypos =y;

        while(true){
            if(xSame >= totalTime && totalTime<= xMaxDiff){
                    xpos = x+(xMaxDiff - totalTime);
                    break;
            }else if(xMaxDiff < totalTime && xminDiff >= totalTime){
                    xpos = w -(xminDiff - totalTime);
                    break;
            }
            xSame += 2*w;
            xMaxDiff += 2*w;
            xminDiff += 2*w;
        }

        while(true){
            if(ySame >= totalTime && totalTime<yMaxDiff){
                xpos = x+(yMaxDiff - totalTime);
                break;
            }else if(yMaxDiff <= totalTime && yminDiff < totalTime){
                xpos = w -(yminDiff - totalTime);
                break;
            }
            ySame += 2*h;
            yMaxDiff += 2*h;
            yminDiff += 2*h;
        }

        //x(t) = x(t+2w) = x(t+4w)
        //12
        //초기 x 좌표 4 -> 12초 후에도 4 -> 2w ->+2씩 로 같은 좌표존재 방향도 같은건 2^n승
        // 12 -8 = 4  4칸남아            - >4-4 =0
        // 8 - 8 = 0  0칸남아            ->같은자리
        // 12 -4 = 8              -> 8-5 = 3
        // 8 - 4 =4               -> 4-3 =1
        //경계면 좌우 운동, y좌표도 위아래 운동
        //4,1에서 시작했다. 8번 움직여 8번 동안
        //시작에서 경계면 까지 거리 빼고 경계면으로 나눈 나머지 ?
        // 시작점에서 끝 경계면까지 거리를 전체 시간에서 뺀거를 경계면의 %임


        //0초,12초에 4, 2초 14초에 6, 8초 20초에 0  -> 초 기준으로 계속 2*w씩 더해가면서 생각해면
        //0초에 8초에 1, 3초 - 11초에 4, 7초 - 15초에 0
        //사이 0 4 7 > 넘어가고 8 11 15 1구간에선 남은시간만큼 + 2구간에선 남은시간만큼 끝에서 -


        System.out.println(xpos+" "+ypos);







    }
}
