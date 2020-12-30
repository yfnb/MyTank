package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class ResourceMgr {
    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;


    public static BufferedImage tankL, tankD, tankU, tankR, tank2;
    public static BufferedImage goodBulletL, goodBulletD, goodBulletU, goodBulletR;
    public static BufferedImage badBulletL, badBulletD, badBulletU, badBulletR;
    public static int tankWidth = 0;
    public static int bulletWidth = 0;
    public static ArrayList<BufferedImage> explodes = new ArrayList<>(16);


    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tank2 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));


            //faaf
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);


            goodBulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            goodBulletL = ImageUtil.rotateImage(goodBulletU, -90);
            goodBulletR = ImageUtil.rotateImage(goodBulletU, 90);
            goodBulletD = ImageUtil.rotateImage(goodBulletU, 180);


            badBulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            badBulletL = ImageUtil.rotateImage(badBulletU, -90);
            badBulletR = ImageUtil.rotateImage(badBulletU, 90);
            badBulletD = ImageUtil.rotateImage(badBulletU, 180);


            tankWidth = tankD.getWidth();
            System.out.println(tankWidth);
            bulletWidth = goodBulletD.getWidth();
            System.out.println(bulletWidth);


            //爆炸图片加载
            for (int i = 1; i <= 16; i++) {
                explodes.add(ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + i + ".gif")));

            }

            System.out.println("爆炸图片数量" + explodes.size());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
