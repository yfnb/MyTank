package gameFactory;

import com.*;

import java.awt.*;

public abstract class BaseTank {

    private int x;
    private int y;
    private static int SPEED = 5;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private TankFrame tf = null;
    private Group group;
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    Rectangle rect2 = new Rectangle(x, y, TankOne.WIDTH, TankOne.HEIGHT);

    private boolean living = true;
    FireStrategy defaultFireStrategy = new DefaultFireStrategy();
    FourDirFireStrategy fourDirFireStrategy = new FourDirFireStrategy();

    public BaseTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        tf.rectangles.add(rect2);
    }


    public Rectangle getRect2() {
        return rect2;
    }

    public void setRect2(Rectangle rect2) {
        this.rect2 = rect2;
    }

    public Group getGroup() {
        return group;
    }

    public void paint(Graphics g) {


        if (!living) {
            tf.tanks.remove(this);

            return;
        }

        //如果是敌方坦克，则方向随机
        if (group.equals(Group.BAD)) {
            moving = true;


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

        if (x > TankFrame.GAME_WIDTH - TankOne.WIDTH) {
            dir = Dir.LEFT;
        }
        if (x < 0) {
            dir = Dir.RIGHT;
        }
        if (y > TankFrame.GAME_HEIGHT - TankOne.WIDTH) {
            dir = Dir.UP;
        }
        if (y < TankOne.WIDTH / 2) {
            dir = Dir.DOWN;
        }


        getTankPhoto(g);


        if (!moving) {

            return;
        }


        move();
    }

    public void getTankPhoto(Graphics g) {
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


    public void fire() {


        if (group.equals(Group.BAD)) {

            int random = (int) (Math.random() * 30);

            if (random != 8) {
                return;
            }
        }

        if (group.equals(Group.BAD)) {
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

    public void setGroup(Group group) {
        this.group = group;
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
