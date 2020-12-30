package gameFactory;

import com.*;

import java.awt.*;

public abstract class BaseBullet {
    private int x;
    private int y;
    private static int SPEED = 8;
    private GameModel gm=GameModel.getInstance();
    private Dir dir;
    private boolean living = true;
    private Group group;
    public static int WIDTH = ResourceMgr.goodBulletD.getWidth();
    public static int HEIGHT = ResourceMgr.goodBulletD.getHeight();
    private Graphics g;
    Rectangle rect1 = new Rectangle(x, y, WIDTH, HEIGHT);



    public BaseBullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        gm.rectangles.add(rect1);

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public void paint(Graphics g) {
        this.g=g;
        int x1; //子弹的实际为止，从坦克的中心位置打出；
        if (!living) {
            gm.bullets.remove(this);
        }


        x1 = x + ResourceMgr.tankWidth / 2 - ResourceMgr.bulletWidth / 2;


        getBulletPhoto(g, x1);

        move();
    }

    public void getBulletPhoto(Graphics g, int x1) {
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

        if (x < 0 || y < 0 || x > gm.GAME_WIDTH || y > gm.GAME_HEIGHT) {
            living = false;
        }

    }


    public void collideWide(BaseTank tank) {
        rect1.setBounds(x,y,WIDTH,HEIGHT);

        //  rect2 = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
        Rectangle rect2 = tank.getRect2();
        rect2.setBounds(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);

        if(group.equals(tank.getGroup())){
            return;
        }

        if (rect1.intersects(rect2)) {
            tank.die();
            this.die();
            Explode ex=new Explode(x,y,gm);
            gm.explodes.add(ex);
            ex.paint(g);


        }
    }

    private void die() {
        living = false;
    }
}
