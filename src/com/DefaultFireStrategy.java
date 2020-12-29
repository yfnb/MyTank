package com;

import gameFactory.BaseTank;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank tank) {
        TankFrame.getInstance().bullets.add(new BulletOne(tank.getX(), tank.getY(), tank.getDir(), tank.getGroup()));
    }


}
