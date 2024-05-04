package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Boj1941 {
    static int n=5;
    static char[][] charr = new char[n][n];
    static int totalResult=0;
    static boolean[] check;



    static Member[] grap = new Member[n*n];
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int cnt=0;
        for(int i=0; i<n;i++){
           String input = br.readLine();
           for(int j=0; j<n;j++){
               charr[cnt][j] = input.charAt(j);
           }
           cnt++;
        }

        //1회 초기화
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                Member m1 = new Member();
                m1.born = charr[i][j];
                m1.sitNumber = memberSit(i,j);
                grap[m1.sitNumber] = m1;
            }
        }

        //경우의 수 검사의 재귀
        //7명의 여학생
        // 7명 자리는 서로 가로 세로에 인접
        // 반드시 이다솜파일 필요는 없어
        // 적어도 7공주에 4명은 이다솜파

        //좌우만 가능

        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){

                chainSevenPrincess(i,j,1);
            }
        }

        //bfs풀이 일단
        System.out.println(totalResult);

    }

    static void chainSevenPrincess(int i, int j, int members){
        if(members == 7){
            //bfs돌아
            //조합이 같으면 한번만 저장하려고



            int root = memberSit(i,j);
            check = new boolean[n*n];
            Queue<Integer> memberQueue = new LinkedList<>();
            memberQueue.offer(root);
            int isBornS=0;
            check[root] = true;

            while (!memberQueue.isEmpty()){
                Integer sitNumber = memberQueue.poll();
                Member member = grap[sitNumber];
                if(member.born == 'S'){
                    isBornS++;
                }

                for(Member m : member.memberList){
                    if(!check[m.sitNumber]){
                        memberQueue.add(m.sitNumber);
                        check[m.sitNumber] = true;
                    }
                }

            }


            if(isBornS >= 4){
                totalResult++;
            }

        }else{
           Member m = grap[memberSit(i,j)];
           int up = memberSit(i-1,j);
           int down = memberSit(i+1,j);
           int right = memberSit(i,j+1);
           int left = memberSit(i,j-1);
           int current = memberSit(i,j);
            //상
            if(boundary(i-1,j) && up > current){
               Member newOne = grap[memberSit(i-1,j)];
               m.memberList.add(newOne);
               newOne.memberList.add(m);

               //재귀
                chainSevenPrincess(i-1,j,members+1);

                //호출 종료 후 연관관계 끊기
                newOne.memberList.remove(m);
                m.memberList.remove(newOne);

            }
            //하
            if(boundary(i+1,j) && down > current){
                Member newOne = grap[memberSit(i+1,j)];
                m.memberList.add(newOne);
                newOne.memberList.add(m);
                //재귀
                chainSevenPrincess(i+1,j,members+1);

                //호출 종료 후 연관관계 끊기
                newOne.memberList.remove(m);
                m.memberList.remove(newOne);
            }
            //좌
            if(boundary(i,j-1) && left > current){
                Member newOne = grap[memberSit(i,j-1)];
                m.memberList.add(newOne);
                newOne.memberList.add(m);
                //재귀
                chainSevenPrincess(i,j-1,members+1);

                //호출 종료 후 연관관계 끊기
                newOne.memberList.remove(m);
                m.memberList.remove(newOne);
            }
            //우
            if(boundary(i,j+1) && right > current){
                Member newOne = grap[memberSit(i,j+1)];
                m.memberList.add(newOne);
                newOne.memberList.add(m);
                //재귀
                chainSevenPrincess(i,j+1,members+1);

                //호출 종료 후 연관관계 끊기
                newOne.memberList.remove(m);
                m.memberList.remove(newOne);
            }
        }
    }

    static int memberSit(int i, int j){
        return (i*n)+j;
    }

    static boolean boundary(int i, int j){
        return (i>=0 && i<n) && (j>=0 && j<n);
    }
    static boolean memberBoundary(int i){
        return i>=0 && i<(n*n);
    }
    static class Member{
        char born;
        int sitNumber;

        boolean isIn = false;
        List<Member> memberList = new ArrayList<>();

        Member next;

    }
}
