package org.example.roop;

public class RoopExam {

    public static void main(String[] args) {

        //공백을 만든다
        int number =5;

        // 다이아 두개
        for(int i=0; i<number;i++){
            //공백 출력
            for(int j=(number-1)-i; j>0;j--){
                System.out.print(" ");
            }

            for(int k=0; k<(i*2)+1;k++){
                System.out.print("*");
            }

            //역삼각형 공백
            for(int j=0; j<(number-1-i)*2;j++){
                System.out.print(" ");
            }

            //별 다시 출력
            for(int k=0; k<(i*2)+1;k++){
                System.out.print("*");
            }

            System.out.println();
        }

        //역삼각형 // x 0 = 7 x 1 ->5 3 2 1
        for(int i=0;i<number-1;i++){


            //공백
            for(int j=0; j<=i;j++){
                System.out.print(" ");
            }
            //별
            for(int k=(number-i-2)*2+1; k>0; k--){
                System.out.print("*");
            }
            //정방햑 공백
            for(int j=0;j<(i*2)+2;j++){
                System.out.print(" ");
            }
            //별
            for(int k=(number-i-2)*2+1; k>0; k--){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        //n줄에 출력?
        for(int i=0; i<number;i++){

            //공백
            for(int j=0; j<number-1-i;j++){

                System.out.print(" ");
            }
            //삼각형
            for(int k=0; k<i*2+1;k++){
                System.out.print("*");
            }

            //역삼각형
            for(int j=(number-1-i)*2; j>0;j--){
                System.out.print(" ");
            }

            //9부터시작하는 친구 삼각형 맨 밑도 9당 *
            for(int k=0; k<(number+i)*2-1;k++){
                System.out.print("*");
            }
            //역삼각형
            for(int j=(number-1-i)*2; j>0;j--){
                System.out.print(" ");
            }
            //삼각형
            for(int k=0; k<i*2+1;k++){
                System.out.print("*");
            }

            System.out.println();

        }

        System.out.println();


        //2n줄에 출력
        int n2 = number*2;
        for(int i=0; i<n2;i++){
            if(i<number){
                for(int j=0; j<n2*2-i-1;j++){
                    System.out.print(" ");
                }
                for(int k=0; k<(i*2)+1;k++){
                    System.out.print("*");
                }
            }else{
                //공백 출력
                for(int j=0; j<n2-i;j++){
                    System.out.print(" ");
                }
                //별 출력
                for(int k=0; k<(i-number)*2+1;k++){
                    System.out.print("*");
                }

                //역삼각혁 출력
                for(int j=(n2-i-1)*2;j>0;j--){
                    System.out.print(" ");
                }

                //끝부터 출력
                for(int k=0; k<i*2+1;k++){
                    System.out.print("*");
                }
                //역삼각혁 출력
                for(int j=(n2-i-1)*2;j>0;j--){
                    System.out.print(" ");
                }
                //별 출력
                for(int k=0; k<(i-number)*2+1;k++){
                    System.out.print("*");
                }

            }
            System.out.println();
        }

        System.out.println();

        //2-9
        for(int i=0; i<number+2;i++){

            for(int j=0;j<number+2;j++){
             if(i==0 || i==number+2-1){
                 System.out.print("$");
             }else if(j==0 || j==number+2-1){
                 System.out.print("$");
             }else{
                 System.out.print("*");
             }
            }
            System.out.println();
        }

        System.out.println();

        //2-10
        int n23 = 2*number+3;
        for(int i=0; i<n23;i++){

            if(i<number+2){

                for(int j=0; j<=i;j++){
                    if(j==0 || j==i){
                        System.out.print("*");
                    } else {
                        System.out.print("@");
                    }
                }

            }else{
                //13 i=7 -> 6
                for(int j=0;j<n23-i;j++){
                    if(j==0 || j==n23-i-1){
                        System.out.print("*");
                    } else {
                        System.out.print("@");
                    }
                }


            }
            System.out.println();
        }


        //1-8 1,3 and 2,2 and 3,1
        for(int i=1; i<=number;i++){
            for(int j=1; j<=number;j++){
                System.out.print(i+j-1+" ");
            }
            System.out.println();
        }

        System.out.println();

        //1-9
        for(int i=1; i<=number; i++){
            for(int j=1; j<=number;j++){
                System.out.print((i+j-2)%number+1+" ");
            }
            System.out.println();
        }

        System.out.println();
        //1-10
        int cnt=1;
        for(int i=0; i<number;i++){

            //공백출력
            for(int j=0; j<number-1-i;j++){
                System.out.print("#");
            }

            for(int k=0;k<=i;k++){
                if(cnt <=10){
                    System.out.printf("%d ",cnt++);
                }else
                    System.out.printf("%d ",cnt++);
            }

            System.out.println();
        }
    }
}
