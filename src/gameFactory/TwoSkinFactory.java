package gameFactory;

import com.*;

public class TwoSkinFactory extends GameFactory{
    //使用单例饿汉模式
    private static TwoSkinFactory twoSkinFactory=new TwoSkinFactory();
    private TwoSkinFactory() {
    }

    public static TwoSkinFactory getInstance(){
        return twoSkinFactory;
    }

    @Override
    public BaseTank getTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new TankTwo(x,y,dir,group,gm);
    }

    @Override
    public BaseBullet getBullet(int x, int y, Dir dir, Group group) {
        return new BulletTwo(x,y,dir,group);
    }
}
