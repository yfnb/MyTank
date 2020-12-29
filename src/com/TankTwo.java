package com;

import gameFactory.BaseTank;

import java.awt.*;

public class TankTwo extends BaseTank {


    public TankTwo(int x, int y, Dir dir, Group group, TankFrame tf) {
        super(x, y, dir, group, tf);
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
