package org.example.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1236 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res =0;

        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);



        int xresult=0;
        int yresult=0;
        boolean[] yboolean = new boolean[w];
        while(h-- > 0){

            String sinput = br.readLine();

            if(sinput.indexOf("X") <0) xresult++;

            for (int i=0; i<w;i++){
                if(sinput.charAt(i) == 'X') yboolean[i] = true;
            }
        }

        for(int i=0; i<w;i++){
            if(yboolean[i] != true) yresult++;
        }

        System.out.println(xresult > yresult ? xresult:yresult);

        //모든 행과 열에 경비원이 있었음 좋겠대 ! 행과 열에 경비원 수 저장해서, 큰



    }
}
