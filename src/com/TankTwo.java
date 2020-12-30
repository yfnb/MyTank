package com;

import gameFactory.BaseTank;
import util.ResourceMgr;

import java.awt.*;

public class TankTwo extends BaseTank {


    public TankTwo(int x, int y, Dir dir, Group group, GameModel gm) {
        super(x, y, dir, group, gm);
    }

    @Override
    public void getTankPhoto(Graphics g) {
        switch (this.getDir()) {
            case LEFT:
                g.drawImage(ResourceMgr.badTankL, this.getX(), this.getY(), null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.badTankR,  this.getX(), this.getY(), null);
                break;
            case UP:
                g.drawImage(ResourceMgr.badTankU,  this.getX(), this.getY(), null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.badTankD, this.getX(), this.getY(), null);
                break;
        }
    }


}
