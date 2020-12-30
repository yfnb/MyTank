package gameFactory;

import com.*;
import util.ResourceMgr;

import java.awt.*;

public abstract class BaseBullet extends GameObject {
    private static int SPEED = 8;
    private GameModel gm = GameModel.getInstance();
    private Dir dir;
    private boolean living = true;

    private Graphics g;


    public BaseBullet(int x, int y, Dir dir, Group group) {
        setX(x);
        setY(y);
        this.dir = dir;
        setGroup(group);
        setHEIGHT(ResourceMgr.goodBulletD.getHeight());
        setWIDTH(ResourceMgr.goodBulletD.getWidth());
    }



    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public void paint(Graphics g) {
        this.g = g;
        int x1; //子弹的实际为止，从坦克的中心位置打出；
        if (!living) {
            gm.getObjects().remove(this);
        }


        x1 = getX() + ResourceMgr.tankWidth / 2 - ResourceMgr.bulletWidth / 2;


        getBulletPhoto(g, x1);

        move();
    }

    public void getBulletPhoto(Graphics g, int x1) {
        int y = getY();
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.goodBulletL, x1, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.goodBulletR, x1, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.goodBulletU, x1, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.goodBulletD, x1, y, null);
                break;
        }
    }

    private void move() {
        switch (dir) {
            case UP:
                setY(getY() - SPEED);
                break;
            case DOWN:
                setY(getY() + SPEED);
                break;
            case LEFT:
                setX(getX() - SPEED);
                break;
            case RIGHT:
                setX(getX() + SPEED);
            default:
                break;
        }

        int x = getX();
        int y = getY();

        if (x < 0 || y < 0 || x > gm.GAME_WIDTH || y > gm.GAME_HEIGHT) {
            living = false;
        }

    }

}
