package org.example.bruteforce;

import java.util.Scanner;

public class Boj1107 {
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
        int result1 = getMinNum1(target,iniNum);


        //그냥 숫자 눌러서 빨리 가능 경우
        int result2  = getMinNum2(target) + numLen;


        System.out.println(Math.min(result1,result2));



    }

    private static int getMinNum2(int target) {
        //ban아닌 놈들 중에 가장 가까운 것
        String iniNum =target+"";
        int tempNum=0;
        //절댓값이 제일 작은게 제일 가까운 숫자임
        int base=(int)Math.pow(10,numLen-1); //1자리 10부터
        int len=0;


        int[] numArr = new int[numLen];
        //배열에 숫자 담기
        for(int i=0; i<numLen;i++){
           numArr[i] = Integer.parseInt(iniNum.charAt(i)+"");
        }

        for(int i=0; i<numArr.length;i++){
            tempNum *=10;
            tempNum += findNum(numArr[i]);
        }

        return getMinNum1(target,tempNum);
    }


    //modi와 가장 가까운 버튼 찾기
    private static int findNum(int modi) {

        int minDis = 10;
        int resultidx=-1;

        for(int i=0; i<=9;i++){
            if(!isBanButton[i]){
                int dis = Math.abs(modi - i);
                if(dis < minDis){
                    minDis = dis;
                    resultidx = i;
                }
            }
        }
        return resultidx;
    }

    private static int getMinNum1(int target, int iniNum) {
        int cnt = 0;

        while (target != iniNum) {

            if (target > iniNum) {
                iniNum++;
                cnt++;
            } else if (target < iniNum) {
                iniNum--;
                cnt++;
            }

        }
        return cnt;
    }
}
