package gameFactory;

import com.*;
import util.ResourceMgr;

import java.awt.*;

public abstract class BaseTank  extends GameObject{
    private static int SPEED = 5;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private int oldX;
    private int oldY;


    private boolean living = true;
    FireStrategy defaultFireStrategy = new DefaultFireStrategy();
    FourDirFireStrategy fourDirFireStrategy = new FourDirFireStrategy();

    private GameModel gm=GameModel.getInstance();

    public BaseTank(int x, int y, Dir dir, Group group, GameModel gm) {
        setX(x);
        setY(y);
        this.dir = dir;
        this.gm = gm;
        setGroup(group);
        setHEIGHT(ResourceMgr.tankD.getHeight());
        setWIDTH(ResourceMgr.tankD.getWidth());
    }





    @Override
    public void paint(Graphics g) {


        if (!living) {
            gm.getObjects().remove(this);
            return;
        }

        //如果是敌方坦克，则方向随机
        if (getGroup().equals(Group.BAD)) {
            moving = true;

            fire();


            double random = Math.random();
            if (random > 0.95) {

                int ddir = (int) (Math.random() * 4) + 1;
                switch (ddir) {
                    case 1:
                        dir = Dir.LEFT;
                        break;
                    case 2:
                        dir = Dir.RIGHT;
                        break;
                    case 3:
                        dir = Dir.UP;
                        break;
                    case 4:
                        dir = Dir.DOWN;
                        break;
                }


            }


        }

        if (getX() > TankFrame.GAME_WIDTH - getWIDTH()) {
            dir = Dir.LEFT;
        }
        if (getX() < 0) {
            dir = Dir.RIGHT;
        }
        if (getY() > TankFrame.GAME_HEIGHT - getHEIGHT()) {
            dir = Dir.UP;
        }
        if (getY() < getWIDTH() / 2) {
            dir = Dir.DOWN;
        }


        getTankPhoto(g);


        if (!moving) {

            return;
        }
        oldX=getX();
        oldY=getY();
        move();
    }

    public int getOldX() {
        return oldX;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public void getTankPhoto(Graphics g) {
        int x=getX();
        int y=getY();
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.goodTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.goodTankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.goodTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.goodTankD, x, y, null);
                break;
        }
    }

    public void move() {


        switch (dir) {
            case UP:
                setY(getY()-SPEED);
                break;
            case DOWN:
                setY(getY()+SPEED);
                break;
            case LEFT:
                setX(getX()-SPEED);
                break;
            case RIGHT:
                setX(getX()+SPEED);
            default:
                break;
        }
    }


    public void fire() {

        if (getGroup().equals(Group.BAD)) {

            int random = (int) (Math.random() * 30);

            if (random != 8) {
                return;
            }
        }

        if (getGroup().equals(Group.BAD)) {

            defaultFireStrategy.fire(this);
        } else {
            fourDirFireStrategy.fire(this);
        }


    }

    public void die() {

        living = false;

    }


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {

        this.dir = dir;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
