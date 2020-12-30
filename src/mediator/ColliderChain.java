package mediator;

import com.GameObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        colliders.add(new TankBulletCollider());
        colliders.add(new TankTankCollider());

    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            Collider collider = colliders.get(i);
            boolean collide = collider.collide(o1, o2);
            if (collide) {
                return collide;
            }
        }

        return false;
    }

    @Override
    public boolean collideWide() {
        return false;
    }
}
