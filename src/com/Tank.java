package com;

import java.awt.*;

public class Tank {

    private int x;
    private int y;
    private static int SPEED = 10;
    private Dir dir;
    private boolean moving=false;

    public Tank(int x, int y, Dir dir,boolean moving) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.moving = moving;
    }


    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {


        g.fillRect(x, y, 50, 50);

        if(moving){
            return;
        }

        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
            default:
                break;
        }
    }

    public void setMainDir(boolean bDown, boolean bUp, boolean bLeft, boolean bRight) {
        moving=true;
        if (bDown) {
            dir = Dir.DOWN;
        }
        if (bUp) {
            dir = Dir.UP;
        }
        if (bLeft) {
            dir = Dir.LEFT;
        }
        if (bRight) {
            dir = Dir.RIGHT;
        }
    }

}
