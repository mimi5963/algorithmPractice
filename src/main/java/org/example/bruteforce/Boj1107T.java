package org.example.bruteforce;

import java.util.Scanner;

public class Boj1107T {
    static boolean[] isBanButton;
    static int numLen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        numLen = (target+"").length();
        //고장난 버튼 모음
        isBanButton = new boolean[10]; // 금지된 버튼목록
        for(int i=0; i<n; i++){
            int b = sc.nextInt();
            isBanButton[b] = true;
        }
        int iniNum = 100;
        //두가지 검사 1번은 100보다 크거나 작을 때 100에서 +나 -를 눌렀을 때 더 빨리 가는 경우 <이건 얼마 안함
        int result1 = Math.abs(100-target);


        //두가지 방향으로 가장 가까운 N을 찾아야함 -> 여기서 나온 N은 Math.ABS 처리 할꺼 + len

        //증가 방향으로 찾기
        boolean flag = false;
        int find1 = target;
        int cnt =0;

        while (cnt < result1){
            //가장 가까운데 금지 안된 수로 이루어져 있는지 찾기
            flag = getNum(find1);
            if(flag) break;
            find1++;
            cnt++;
        }
        //find 부분이 잘못됨 못찾을 수도 있는거자너
        if(flag == true) {
            find1 = Math.abs(target - find1) + (find1 + "").length();
        }else{
            find1 = 500000;
        }
        //감소하는 방향으로 찾기
        cnt =0;
        flag = false;
        int find2 = target;
        while (cnt < result1){
            //가장 가까운데 금지 안된 수로 이루어져 있는지 찾기
            flag = getNum(find2);
            if(flag) break;
            find2--;
            if(find2 <0){
                find2 = 0;
            }
            cnt++;
        }
        if(flag == true) {
            find2 = Math.abs(target - find2) + (find2 + "").length();
        }else{
            find2 = 500000;
        }
        find1 = Math.min(find1,find2);

        System.out.println(Math.min(find1,result1));

    }

    private static boolean getNum(int find1) {
        String iniNum =find1+"";

        for(int i=0; i<iniNum.length();i++){
            if(isBanButton[Integer.parseInt(iniNum.charAt(i)+"")]){
                return false;
            }
        }


        return true;
    }


}
