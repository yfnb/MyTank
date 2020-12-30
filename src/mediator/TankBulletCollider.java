package mediator;

import com.*;
import gameFactory.BaseBullet;
import gameFactory.BaseTank;

import java.awt.*;

public class TankBulletCollider implements Collider {
    private BaseTank tank;
    private BaseBullet bullet;
    private GameObject o1;
    private GameObject o2;

    Rectangle rect1 = new Rectangle();
    Rectangle rect2 = new Rectangle();

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1.getGroup().equals(o2.getGroup())) {
            return false;
        }

        this.o1 = o1;
        this.o2 = o2;

        if ((o1 instanceof BaseBullet) && (o2 instanceof BaseTank)) {


            return (collideWide());
        }

        if ((o2 instanceof BaseBullet) && (o1 instanceof BaseTank)) {
            collide(o2, o1);
        }

        return false;
    }

    @Override
    public boolean collideWide() {

        rect1.setBounds(o1.getX(), o1.getY(), o1.getWIDTH(), o1.getHEIGHT());


        rect2.setBounds(o2.getX(), o2.getY(), o2.getWIDTH(), o2.getHEIGHT());


        if (rect1.intersects(rect2)) {
            o1.die();
            o2.die();
            Explode ex = new Explode(o1.getX(), o1.getY());
            ex.paint(TankFrame.getInstance().g);

            if((o1 instanceof BaseTank)&&o1.getGroup().equals(Group.GOOD)){

                GameModel.getInstance().setMyTank(null);
            }

            if((o2 instanceof BaseTank)&&o2.getGroup().equals(Group.GOOD)){

                GameModel.getInstance().setMyTank(null);
            }

            return true;
        }



        return false;
    }


}
