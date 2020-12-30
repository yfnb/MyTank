package com;

import gameFactory.BaseTank;
import gameFactory.GameFactory;
import gameFactory.TwoSkinFactory;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = TankFrame.getInstance();

        Integer initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        BaseTank baseTank=null;
        for (int i = 1; i <= initTankCount; i++) {

            int x=  (int)(Math.random()*TankFrame.GAME_WIDTH);
            int y=(int)(Math.random()*TankFrame.GAME_HEIGHT);

            TwoSkinFactory twoSkinFactory=TwoSkinFactory.getInstance();
            baseTank=   twoSkinFactory.getTank(x,y,Dir.DOWN,Group.BAD,GameModel.getInstance());

           GameModel.getInstance().tanks.add(baseTank);

        }


        while(true) {
            Thread.sleep(50);


            frame.repaint();
        }

    }

}
