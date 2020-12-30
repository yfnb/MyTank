package gameFactory;

import com.*;

public class OneSkinFactory extends GameFactory {
    //应用单例懒汉模型
    private static volatile OneSkinFactory oneSkinFactory = null;
    private OneSkinFactory() {
    }

    public static OneSkinFactory getInstance() {
       //双重加锁，保证线程安全
        if (oneSkinFactory == null) {
            synchronized (OneSkinFactory.class) {
                if (oneSkinFactory == null) {
                    oneSkinFactory = new OneSkinFactory();
                }
            }
        }
        return oneSkinFactory;
    }

    @Override
    public BaseTank getTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new TankOne(x, y, dir, group, gm);
    }

    @Override
    public BaseBullet getBullet(int x, int y, Dir dir, Group group) {
        return new BulletOne(x, y, dir, group);
    }
}
