package org.example.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Boj2817t {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfc = Integer.parseInt(br.readLine());
        int staff = Integer.parseInt(br.readLine());
        //int fivePercent = numOfc * 0.05;

        List<VotedStaff> staffList = new ArrayList<>();
        List<Score> scoreList = new ArrayList<>();

        while(staff -- >0){
            String[] nameAndVote = br.readLine().split(" ");
            String name = nameAndVote[0];
            int voted = Integer.parseInt(nameAndVote[1]);
            if(voted >= numOfc*0.05){
                //스테프 만들기
                VotedStaff st = new VotedStaff();
                st.name=name;
                //스태프 저장
                staffList.add(st);
                //점수 저장 - 1열로
                for(int i=1; i<=14;i++){
                    Score sc = new Score();
                    sc.st = st;
                    sc.sc = (double) voted/i;
                    scoreList.add(sc);
                }
            }

        }

        getCoint(scoreList);

        staffList.sort((o1,o2) -> {
           return o1.name.compareTo(o2.name);
        });

        staffList.forEach(s ->{
            System.out.println(s.name+" "+s.coin);
        });

    }

    private static void getCoint(List<Score> scoreList) {

        sortScoreList(scoreList);


        for(int i=0; i<14;i++){
           Score sc =  scoreList.get(i);
           sc.st.coin++;
        }
    }

    private static void sortScoreList(List<Score> scoreList) {

        scoreList.sort((o1, o2) -> {
            if(o2.sc > o1.sc){
                return 1;
            }else if(o1.sc == o2.sc){
                return 0;
            }else{
                return -1;
            }
        });

    }

    static class VotedStaff {
        String name;
        int coin=0;

    }

    static class Score{
        VotedStaff st;
        double sc;
    }

}
