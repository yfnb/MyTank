package gameFactory;

import com.Dir;
import com.GameModel;
import com.Group;
import com.TankFrame;

public abstract class GameFactory {

    public abstract BaseTank getTank(int x, int y, Dir dir, Group group, GameModel gm);
    public abstract BaseBullet getBullet(int x, int y, Dir dir, Group group);


}
