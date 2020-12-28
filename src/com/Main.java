package com;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = TankFrame.getInstance();

        Integer initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        for (int i = 1; i <= initTankCount; i++) {

            int x=  (int)(Math.random()*TankFrame.GAME_WIDTH);
            int y=(int)(Math.random()*TankFrame.GAME_HEIGHT);

            ((TankFrame) frame).tanks.add(new Tank(x,y,Dir.DOWN,Group.BAD, (TankFrame) frame));

        }




        while(true) {
            Thread.sleep(50);


            frame.repaint();
        }

    }

}
