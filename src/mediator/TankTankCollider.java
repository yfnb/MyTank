package mediator;

import com.Dir;
import com.Explode;
import com.GameObject;
import com.TankFrame;
import gameFactory.BaseBullet;
import gameFactory.BaseTank;

import java.awt.*;

public class TankTankCollider implements Collider {
    private GameObject o1;
    private GameObject o2;
    Rectangle rect1 = new Rectangle();
    Rectangle rect2 = new Rectangle();

    @Override
    public boolean collide(GameObject o1, GameObject O2) {

        this.o1 = o1;
        this.o2 = o2;

        if ((o1 instanceof BaseTank) && (o2 instanceof BaseTank)) {


            return (collideWide());
        }

        return false;
    }

    @Override
    public boolean collideWide() {
        rect1.setBounds(o1.getX(), o1.getY(), o1.getWIDTH(), o1.getHEIGHT());
        rect2.setBounds(o2.getX(), o2.getY(), o2.getWIDTH(), o2.getHEIGHT());
        if (rect1.intersects(rect2)) {
            Dir dir1 = ((BaseTank) o1).getDir();
            Dir dir2 = ((BaseTank) o2).getDir();

            switch (dir1) {

                case LEFT:
                    ((BaseTank) o1).setDir(Dir.RIGHT);
                    break;
                case RIGHT:
                    ((BaseTank) o1).setDir(Dir.LEFT);
                    break;
                case UP:
                    ((BaseTank) o1).setDir(Dir.DOWN);
                    break;
                case DOWN:
                    ((BaseTank) o1).setDir(Dir.UP);
                    break;

            }

            switch (dir2) {

                case LEFT:
                    ((BaseTank) o2).setDir(Dir.RIGHT);
                    break;
                case RIGHT:
                    ((BaseTank) o2).setDir(Dir.LEFT);
                    break;
                case UP:
                    ((BaseTank) o2).setDir(Dir.DOWN);
                    break;
                case DOWN:
                    ((BaseTank) o2).setDir(Dir.UP);
                    break;

            }


            return false;
        }

        return false;
    }
}
