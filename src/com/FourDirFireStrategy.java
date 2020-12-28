package com;

public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank tank) {
        Dir[] values = Dir.values();
        for (int i = 0; i <values.length ; i++) {
            TankFrame.getInstance().bullets.add(new Bullet(tank.getX(), tank.getY(),values[i], tank.getGroup()));
        }

    }
}
