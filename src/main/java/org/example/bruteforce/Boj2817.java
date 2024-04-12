package org.example.bruteforce;

import java.io.*;
import java.util.*;

public class Boj2817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfc = Integer.parseInt(br.readLine());
        int staff = Integer.parseInt(br.readLine());
        int fivePercent = (int)(numOfc * 0.05);

        List<VotedStaff> list = new ArrayList<>();

        //5%넘는지 확인하고, 1부터 14까지 나눈거 저장
        while(staff -- > 0 ){
            String[] sinput = br.readLine().split(" ");
            String st = sinput[0];
            int voted = Integer.parseInt(sinput[1]);
            if(voted >= fivePercent ){
                float[] divied = getArray(voted);
                VotedStaff vo = new VotedStaff();
                vo.dived = divied;
                vo.name = st;
                list.add(vo);
            }
        }


        getCoin(list);


        list.sort(new Comparator<VotedStaff>() {
            @Override
            public int compare(VotedStaff o1, VotedStaff o2) {

              return o1.name.compareTo(o2.name);
            }
        });

        for (VotedStaff votedStaff : list) {
            System.out.println(votedStaff.name +" "+votedStaff.coin);
        }
        //아 모든 점수 집합을 검사하면서 1번쨰로 값이 큰,2번쨰로 값이 큰

    }

    private static float[] getArray(int voted){
        float[] array = new float[14];
        for(int i=0; i<14; i++){
            array[i] = (float) voted/(i+1);
        }
        return array;
    }

    private static void getCoin(List<VotedStaff> list){
        int idx=0;
        int maxIdx=0;
        while(idx ++ < 14){



            for(int i=0; i<list.size();i++){
                VotedStaff v1 = list.get(i);
                VotedStaff max = list.get(maxIdx);
                if(max.dived[max.pos] < v1.dived[v1.pos]){
                    maxIdx = i;
                }
            }
            //하나씩 내려가면서 가장 큰 값 가진 스태프의 pos ++ 하고, 코인 올려줌
            VotedStaff maxStaff = list.get(maxIdx);
            maxStaff.up();
            maxStaff.coin++;
        }


    }
    static class VotedStaff {
        String name;
        float[] dived;

        int coin=0;

        int pos=0;

        public void up(){
            if(pos < dived.length-1){
                pos++;
            }
        }
    }
}
