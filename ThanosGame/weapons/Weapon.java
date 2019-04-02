package ThanosGame.weapons;

import ThanosGame.Personnage;
import javafx.geometry.Point2D;

import java.util.LinkedList;

public class Weapon {
    private LinkedList<Projectile> worldProjectiles;
    protected int damage;
    protected double bulletSpeed;
    private long reloadTime;
    private long lastFire;
    protected Personnage owner;

    public Weapon(LinkedList<Projectile> worldProjectiles, Personnage owner, int damage, int bulletSpeed, int reloadTime){
        this.owner=owner;
        this.worldProjectiles = worldProjectiles;
        this.damage = damage;
        this.bulletSpeed = bulletSpeed;
        this.reloadTime = reloadTime;
    }

    public boolean fire(Point2D direction){
        if(System.currentTimeMillis()-lastFire>reloadTime){
            lastFire=System.currentTimeMillis();
            worldProjectiles.add(createProjectile(direction));
            return  true;
        }
        return false;
    }

    public Projectile createProjectile(Point2D direction){
        return new Projectile(owner.myPosition,new Point2D(4,3),damage,direction.multiply(bulletSpeed),1000,0);
    }
}