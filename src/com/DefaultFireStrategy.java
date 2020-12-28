package com;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        TankFrame.getInstance().bullets.add(new Bullet(tank.getX(), tank.getY(), tank.getDir(), tank.getGroup()));
    }
}
