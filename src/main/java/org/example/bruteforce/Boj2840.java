package org.example.bruteforce;

import java.io.*;
import java.util.Arrays;

public class Boj2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sinput = br.readLine().split(" ");

        int n = Integer.parseInt(sinput[0]);
        int k = Integer.parseInt(sinput[1]);

        char[] charr = new char[n];
        Arrays.fill(charr,'?');
        //화살표 현재 위치
        int pos = 0;
        boolean flag = true;
        char ch = ' ';
        while(k -- > 0){
            String[] turnInput = br.readLine().split(" ");
            //글자가 변한 횟수
            int s = Integer.parseInt(turnInput[0]);
            ch = turnInput[1].charAt(0);

            //변화한 화살표 위치
            pos = getPos(pos,s,n);

            if(charr[pos] != ch && charr[pos] != '?'){
                flag = false;
                break;
            }else{
                charr[pos] = ch;
            }

        }
        boolean isNotdup = isDup(charr);

        if(flag && isNotdup){
            String result = new String(charr);
            int idx = result.indexOf(ch);
            int lastIdx = result.length()-1;
            int cnt = idx;
            while(cnt >= 0){
                bw.write(result.charAt(cnt));
                cnt--;
            }
            while (lastIdx > idx){
                bw.write(result.charAt(lastIdx));
                lastIdx--;
            }

        }else{
            bw.write("!");
        }

        bw.flush();
        bw.close();

    }

    private static boolean isDup(char[] charr) {
        int cnt =1;
        for(int i=0;i<charr.length-1;i++){
            for(int j=i+1;j<charr.length;j++){
                if( (charr[i] != '?' && charr[j] !='?') && charr[i] == charr[j]){
                    cnt++;
                }
            }
        }

        if(cnt >=2){
            return false;
        }

        return true;
    }

    private static int getPos(int pos, int s, int i) {
        return (pos+s) %i;
    }
}
