package gameFactory;

import com.*;

public class TwoSkinFactory extends GameFactory{


    @Override
    public BaseTank getTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new TankTwo(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet getBullet(int x, int y, Dir dir, Group group) {
        return new BulletTwo(x,y,dir,group);
    }
}
