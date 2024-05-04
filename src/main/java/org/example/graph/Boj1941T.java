package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj1941T {
    static int[] students = new int[25];
    static boolean[] check = new boolean[25];

    static boolean[] comCheck = new boolean[25];

    static int[] output = new int[7];

    static List<Integer> pick = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        //입력 받기 이다솜파는 1 아니면 0
        for(int i=0; i<5;i++){
            String str = sc.next();
            for(int j=0; j<5; j++){
                if(str.charAt(j) == 'S'){
                    students[cnt] = 1;
                }else {
                    students[cnt] = 0;
                }
                cnt++;
            }
        }

        int princess = nextCombination(0);
        System.out.println(princess);

        conb(0,0);
    }

    static void conb(int start, int depth){
        if(depth == 7){
            for(int i=0; i<7; i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=start;i<25;i++){
                output[depth] = students[i];
                conb(start+1,depth+1);
            }
        }
    }


    static int nextCombination(int num){
        //BASE CASE
        if(pick.size() == 7){

            //이다솜파의 인원이 4명 이상인지?
            int cnt =0;
            for(int i=0; i<7; i++){
                if(students[pick.get(i)] == 1) cnt++;
            }

            //이다솜파가 4명 미만이라 쓸모 없다.
            if(cnt < 4) {
                return 0;
            }

            //모두 인접해있는지 검사한다.
            for(int i=0; i<7;i++){
                check[i] = false;
            }

            //이다솜파의 조합 인정
            if(dfs(0) == 7 )return 1;


            return 0;

            //여기서 이다솜인지 뭔지 구현
        }else {

            if(num >= 25) return 0;

            //RecursiveCase

            //조합의 개수
            int ret = 0;
            //studentNum번째 학생을 포함하지 않는 경우
            ret += nextCombination(num+1);

            //studentNum번째 학생을 포함하는 경우
            pick.add(num);
            ret += nextCombination(num+1);
            //탐색이 끝나면 빼주기
            pick.remove(pick.size()-1);

            return ret;
        }
    }

    static int dfs(int stduentNum){
        int count =1;
        check[stduentNum] = true;
        int me = pick.get(stduentNum);
        for(int i=1; i<7;i++){
            int you = pick.get(i);
            if(!check[i] && isFriend(me,you)){
                count += dfs(i);
            }
        }
        return count;
    }

    static boolean isFriend(int a, int b){
        int diff = Math.abs(a-b);
        int max = Math.max(a,b);

        if(diff == 1 && max% 5 != 0) return true;
        if(diff == 5) return true;

        return false;
    }
}
