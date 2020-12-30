package com;

import gameFactory.BaseTank;

import java.awt.*;

/**
 * 各种游戏物体的父类
 */
public abstract class GameObject {
    int x,y;
    int WIDTH,HEIGHT;

    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public  void die(){

        GameModel.getInstance().getObjects().remove(this);
//        if(this instanceof BaseTank myTank = GameModel.getInstance().getMyTank();
//        {
//            System.out.println("主站坦克死了");
//            GameModel.getInstance().myTankDie();
//
//        }

    };
}
