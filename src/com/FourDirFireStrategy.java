package com;

import gameFactory.BaseTank;

public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(BaseTank tank) {
        Dir[] values = Dir.values();
        for (int i = 0; i <values.length ; i++) {
            TankFrame.getInstance().bullets.add(new BulletOne(tank.getX(), tank.getY(),values[i], tank.getGroup()));
        }

    }


}
