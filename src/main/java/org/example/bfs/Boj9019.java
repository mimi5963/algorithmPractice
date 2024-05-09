package org.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj9019 {
    static String[] DSLR = {"D", "S", "L", "R"};

    public static void main(String[] args) {

        //네개의 명령어 DSLR을 이용한 계산기
        // 레지스터는 0~1만 미만 저장
        // 각 명령어는 저장된 n을 다음과 같이 변환
        // n의 자리수릇 d1,d2,d3,d4
        // ((d1*10+d2)*10+d3)*10+d4
        // D: n을 두배로 값이 9999보다 크면 만으로 나눈 나머지
        // S: n 에서 1을 뺀것 0이면 9999가 저장
        //L은 자릿수 회전 첫번째 자릿수를 마지막으로 보냄
        //R은 마지막 자릿수를 처음으로 보냄


        //주어진 DSLR명령어로
        //A에서 B로 바꾸는데 최소 실행 명령어
        // 자릿수에 0이 포함된 것 주의
        //이건 R일때만 주의하면 될 듯

        //어떤연산을 해왔는지 저장해야함
        Scanner sc = new Scanner(System.in);
        //4방향 그거랑 같아 그냥 방향만 다르고, 숫자만 이상할 뿐
        //

        int t = sc.nextInt();
        while (t-- > 0) {
            int init = sc.nextInt();
            int target = sc.nextInt();
            boolean[] check = new boolean[10000];


            Register register = new Register(init);
            check[init] = true;


            Queue<Register> q = new LinkedList<>();
            q.offer(register);

            String result = "";
            while (!q.isEmpty()) {
                Register now = q.poll();
                if (now.num == target) {
                    System.out.println(now.sb.toString());
                    break;
                }
                int[] cal = new int[4];
                cal[0] = (now.num * 2) % 10000;
                cal[1] = (now.num - 1) < 0 ? 9999 : now.num - 1;
                cal[2] = getLeft(now.num);
                cal[3] = getRight(now.num);

                for (int i = 0; i < 4; i++) {
                    int newNum = cal[i];
                    if (!check[newNum]) {
                        Register register1 = new Register(newNum);
                        register1.sb.append(now.sb.toString() + DSLR[i]);
                        check[newNum] = true;
                        q.offer(register1);
                    }

                }
            }


        }

    }

    private static int getRight(int now) {
//        //각수를 나눈 몫 1000에면 1000자리에서 0일껄?
//        //i를 만부터해서 10씩 나누기하면서 내려와 -> 제일 먼저 i가 반응한 곳이
//        // 자릿수 -> 자릿수 .. 뒤 5부터 시작해서 나누면 되겠군
//        // 그럼 자릿수 나오고, 각 first 부터 끝까지 나온다 말이쥐?
//        // right면 맨 끝자리를 앞으로 끌고와
//        //자릿수 기준으로 연산하면됨
//        //result는 0인데 for문 돌 때마다 10씩 곱한거에 자릿수 더하기자나
//        int[] divide = new int[6];
//        int dnum = 10000;
//        int length = 0;
//        int result = 0;
//        for (int i = 5; i > 0; i--) {
//            divide[i] = now / dnum;
//            now %= dnum;
//            //자릿수 찾기
//            if (length == 0 && divide[i] != 0) {
//                length = i;
//            }
//            dnum /= 10;
//        }
//
//        //숫자 자리 바꾸기 d4,d1,d2,d3 1234 -> 4,3,2,1에 저장
//        int d1 = divide[1];
//        for (int i = 2; i <= length; i++) {
//            divide[i - 1] = divide[i];
//        }
//        divide[length] = d1;
//
//
//        int start = length;
//        //숫자 다시 조합
//        for (int i = 0; i < length; i++) {
//            result *= 10;
//            result += divide[start];
//            start--;
//        }
        int n = now%10;
        int k = n*1000;
        int j = k+now/10;

        return (now % 10) * 1000 + now / 10;
    }

    private static int getLeft(int now) {
//        //각수를 나눈 몫 1000에면 1000자리에서 0일껄?
//        //i를 만부터해서 10씩 나누기하면서 내려와 -> 제일 먼저 i가 반응한 곳이
//        // 자릿수 -> 자릿수 .. 뒤 5부터 시작해서 나누면 되겠군
//        // 그럼 자릿수 나오고, 각 first 부터 끝까지 나온다 말이쥐?
//        // right면 맨 끝자리를 앞으로 끌고와
//        //자릿수 기준으로 연산하면됨
//        //result는 0인데 for문 돌 때마다 10씩 곱한거에 자릿수 더하기자나
//        int[] divide = new int[6];
//        int dnum = 10000;
//        int length = 0;
//        int result = 0;
//        for (int i = 5; i > 0; i--) { // 1234가 4321로 저장됨  4가 1 자릴수대로 저장했음
//            divide[i] = now / dnum;
//            now %= dnum;
//            //자릿수 찾기
//            if (length == 0 && divide[i] != 0) {
//                length = i;
//            }
//            dnum /= 10;
//        }
//
//        //숫자 자리 바꾸기 d2,d3,d4,d1 1234 -> 4,3,2,1에 저장 4 3 2 1 -> 1 4 3 2
//        int d1 = divide[length];
//        for (int i = length - 1; i > 0; i--) {
//            divide[i + 1] = divide[i];
//        }
//        divide[1] = d1;
//
//
//        int start = length; //맨 끝자리부터 합침
//        //숫자 다시 조합
//        for (int i = 0; i < length; i++) {
//            result *= 10;
//            result += divide[start];
//            start--;
//        }
//
//        return result;
//        // return (now % 1000) * 10 + now / 1000;
        return (now % 1000) * 10 + now / 1000;
    }

    static class Register {
        int num;
        StringBuilder sb = new StringBuilder();

        public Register(int n) {
            this.num = n;
        }
    }

}
