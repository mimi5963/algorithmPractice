package org.example;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String in1 = br.readLine();
//        String in2 = br.readLine();
        String in1 = "aabbcc";
        String in2 = "xxyybb";

        char[] cnt1 = new char[26];
        char[] cnt2 = new char[26];

        for(int i=0; i<in1.length();i++){
            cnt1[in1.charAt(i)-'a']++;
        }
        for(int i=0; i<in2.length();i++){
            cnt2[in2.charAt(i)-'a']++;
        }

        int ans = 0;
        for(int i=0; i<26;i++){

            if(cnt1[i] > cnt2[i]){
                ans += cnt1[i] - cnt2[i];
            }else if(cnt2[i] > cnt1[i]){
                ans += cnt2[i] - cnt1[i];
            }

        }

                bw.write(ans+"");
                bw.flush();
                bw.close();




        }
    }