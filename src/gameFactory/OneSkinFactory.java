package gameFactory;

import com.*;

public class OneSkinFactory extends GameFactory{


    @Override
    public BaseTank getTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new TankOne(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet getBullet(int x, int y, Dir dir, Group group) {
        return new BulletOne(x,y,dir,group);
    }
}
