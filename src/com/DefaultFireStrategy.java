package com;

import gameFactory.BaseBullet;
import gameFactory.BaseTank;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank tank) {
        BaseBullet baseBullet=new BulletOne(tank.getX(), tank.getY(), tank.getDir(), tank.getGroup());
        GameModel.getInstance().getObjects().add(baseBullet);
    }


}
