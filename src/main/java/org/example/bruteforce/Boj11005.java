package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11005 {
    public static void main(String[] args) throws IOException {
        //10 -> A
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer buffer = new StringBuffer();

        String[] numAndBase = br.readLine().split(" ");
        long num = Long.parseLong(numAndBase[0]);
        int base = Integer.parseInt(numAndBase[1]);

        while(num != 0){
            int reminder = (int)(num%base);
            if(reminder >9){
                buffer.append((char)(55+reminder));
            }else {
                buffer.append(reminder);
            }
            num /=base;
        }

        System.out.println(buffer.reverse());

    }
}
