package test;

import java.util.Random;

public class RandomTest {


    public static void main(String[] args) {
        randomTest();
    }

    public static void randomTest(){

        Math.random();

        //不加种子以当前时间为种子，加种子，则每次的输入结果一样
        Random random=new Random();
        int sum=0;
        int max=1000000;
        for (int i = 0; i <max ; i++) {
            int a=random.nextInt(100);
          //  System.out.print(a+",");
            if(a>50){
                sum++;
                
            }
        }

        double ratio = (double)sum / max;
        System.out.println();

        System.out.println(ratio);

        //random.nextInt好事Math.random都是伪随机数，所发生的的概率在区间内均匀分布
    }

}
