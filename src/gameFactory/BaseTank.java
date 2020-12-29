package gameFactory;

import com.Dir;
import com.Group;

import java.awt.*;

public abstract class BaseTank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private Group group;
    private boolean moving ;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        System.out.println("moving:"+moving);
        this.moving = moving;
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
        System.out.println("调用父类方法");
        System.out.println("&&&&&"+dir);
        System.out.println(this);
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public abstract void paint(Graphics g);

    public abstract void fire();

    public abstract void move();
}
