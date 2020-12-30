package com;

import gameFactory.BaseBullet;
import gameFactory.BaseTank;
import gameFactory.OneSkinFactory;
import gameFactory.TwoSkinFactory;

public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(BaseTank tank) {
        Dir[] values = Dir.values();
        for (int i = 0; i <values.length ; i++) {
            BaseBullet bullet = TwoSkinFactory.getInstance().getBullet(tank.getX(), tank.getY(), values[i], tank.getGroup());
            GameModel.getInstance().bullets.add(bullet);
        }

    }


}
