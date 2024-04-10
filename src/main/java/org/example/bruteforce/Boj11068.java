package org.example.bruteforce;

import java.io.*;

public class Boj11068 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while(n -- > 0){
            int num = Integer.parseInt(br.readLine());
            boolean result = isPa(num);

            if(result){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();


    }

    private static boolean isPa(int num) {

        int base=2;

        while(base <= 64){

            //일단 진법 변환
            String baseNume = getBaseNum(num,base);

            // 회문인지 검사
            int left =0;
            int right = baseNume.length()-1;

            while(left < right){
                if(baseNume.charAt(left) != baseNume.charAt(right)){
                    break;
                }
                left++;
                right--;
            }

            if(left >= right){
                return true;
            }

            base++;
        }

        return false;
    }

    private static String getBaseNum(int num, int base) {
        StringBuffer sb = new StringBuffer();
        while(num != 0){
            int reminder = num % base;
            if(reminder >9){
                sb.append((char)(55+reminder));
            }else{
                sb.append(reminder);
            }
            num /= base;
        }

        return sb.reverse().toString();
    }
}
