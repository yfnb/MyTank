package com;

import gameFactory.BaseBullet;
import util.ResourceMgr;

import java.awt.*;

public class BulletTwo extends BaseBullet {


    public BulletTwo(int x, int y, Dir dir, Group group) {
        super(x, y, dir, group);
    }

    @Override
    public void getBulletPhoto(Graphics g, int x1) {
        Color color = g.getColor();
        g.setColor(Color.RED);

        switch (this.getDir()) {
            case LEFT:
                g.drawImage(ResourceMgr.badBulletL, x1, this.getY(), null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.badBulletR, x1, this.getY(), null);
                break;
            case UP:
                g.drawImage(ResourceMgr.badBulletU, x1, this.getY(), null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.badBulletD, x1, this.getY(), null);
                break;
        }

        g.setColor(color);
    }
}
