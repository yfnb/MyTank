package com;

import util.ResourceMgr;

import java.awt.*;

public class Explode {



    private int x;
    private int y;
    private TankFrame tf;
    int index=0;

    private GameModel gm;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g){

        do{ g.drawImage(ResourceMgr.explodes.get(index++), x, y, null);} while (index<16);



    }

}
