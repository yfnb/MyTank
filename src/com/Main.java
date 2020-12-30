package com;

import gameFactory.BaseTank;
import gameFactory.GameFactory;
import gameFactory.TwoSkinFactory;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = TankFrame.getInstance();

        while(true) {
            Thread.sleep(50);


            frame.repaint();
        }

    }

}
