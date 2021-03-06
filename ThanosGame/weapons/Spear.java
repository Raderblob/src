package ThanosGame.weapons;

import ThanosGame.enemies.Personnage;
import ThanosGame.weapons.projectiles.Projectile;
import javafx.geometry.Point2D;

import java.util.LinkedList;

public class Spear extends Weapon {
    public Spear(LinkedList<Projectile> worldProjectiles, Personnage owner, double damage) {
        super(worldProjectiles, owner, damage, 5, 500);
    }

    @Override
    public Projectile createProjectile(Point2D direction) {
        return new Projectile(owner.myPosition,new Point2D(10,3),damage,direction.multiply(bulletSpeed),8,1);
    }
}
