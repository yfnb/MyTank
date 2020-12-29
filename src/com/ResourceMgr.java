package com;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class ResourceMgr {



     public static    BufferedImage tankL,tankD,tankU,tankR,tank2;
     public static    BufferedImage bulletL,bulletD,bulletU,bulletR;
     public static int tankWidth=0;
     public static int bulletWidth=0;
     public static ArrayList<BufferedImage> explodes=new ArrayList<>(16);




      static  {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tank2 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));



            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));

            tankWidth=tankD.getWidth();
            System.out.println(tankWidth);
            bulletWidth=bulletD.getWidth();
            System.out.println(bulletWidth);


            //爆炸图片加载
            for (int i = 1; i <=16 ; i++) {
                explodes.add(ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+i+".gif"))) ;

            }

            System.out.println("爆炸图片数量"+explodes.size());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }







}
