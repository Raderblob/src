package ThanosGame;

import ThanosGame.terrain.LargeBase;
import ThanosGame.terrain.Teleporter;
import ThanosGame.terrain.TerrainMap;
import ThanosGame.terrain.buildings.BuildingSaves;
import ThanosGame.weapons.Explosion;
import ThanosGame.weapons.FXEffect;
import ThanosGame.weapons.Projectile;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;

public class World {
    public Game myGame;
    public Thanos thanos;
    private TerrainMap terrain;
    public  LinkedList<Personnage> enemies;
    public LinkedList<FXEffect> worldExplosions;
    public LinkedList<Projectile> worldProjectiles;
    private Point2D starterPos;
    private int teleportTo;
    private LinkedList<Teleporter> teleporters;
    public World(int worldType, Thanos p,Game myGame) {
        this.myGame = myGame;
        thanos = p;
        worldProjectiles = new LinkedList<>();
        worldExplosions = new LinkedList<>();
        teleporters = new LinkedList<>();
        enemies = new LinkedList<>();
        switch (worldType) {
            case 1:
                starterPos = new Point2D(50,50);
                teleportTo = 0;
                terrain = new TerrainMap(30,true,this,enemies);
                new LargeBase(BuildingSaves.pal,new Point2D(10000,0)).changeTerrain(terrain);
                new LargeBase(BuildingSaves.ironManBase,new Point2D(1500,0)).changeTerrain(terrain);
                new LargeBase(BuildingSaves.captainBase,new Point2D(2500,40)).changeTerrain(terrain);
                new LargeBase(BuildingSaves.thorBase,new Point2D(2000,0)).changeTerrain(terrain);
                enemies.add(new Personnage(new Point2D(1000,50),terrain,this));
                break;
            case 0:
                starterPos = new Point2D(720,320);
                teleportTo = 1;
                terrain = new TerrainMap(2,false,this,enemies);
                System.out.println("loading base");
                new LargeBase(BuildingSaves.thanosBase,new Point2D(0,0)).changeTerrain(terrain);//generate home base
                teleporters.add(new Teleporter(new Point2D(600,150),1,myGame));
                break;
            default:
                starterPos = new Point2D(50,50);
                break;
        }
    }

    public void runWorld(double currentNanoTime) {
        thanos.run(terrain, this, currentNanoTime);
        //run physics for the player



        LinkedList<Personnage> ennToRemove = new LinkedList<>();
        LinkedList<Projectile> pToRemove = new LinkedList<>();
        LinkedList<FXEffect> eToRemove = new LinkedList<>();

        for(Personnage enemy: enemies){
            enemy.run(terrain,this,currentNanoTime);//run ai
            if(enemy.PV<=0){
                ennToRemove.add(enemy);
            }
        }

        for (Projectile cProjectile : worldProjectiles) {
            cProjectile.runLogic(this, terrain, currentNanoTime); //run collisions for projectiles
            if (cProjectile.mylife <= 0) {
                pToRemove.add(cProjectile);
            }
        }
        for (FXEffect cExplosion : worldExplosions) {
            cExplosion.runExplosion(this, terrain, currentNanoTime); //run explosion logic (possible repulsion and animation)
            if (cExplosion.mylife <= 0) {
                eToRemove.add(cExplosion);
            }
        }

        for (Projectile p : pToRemove) {
            worldExplosions.add(new Explosion(p.position, new Point2D(10, 10), 28, p.degats, terrain));
            worldProjectiles.remove(p);
        }
        for (FXEffect e : eToRemove) {
            worldExplosions.remove(e);
        }
        for (Personnage e : ennToRemove) {
            worldExplosions.add(new Explosion(e.myPosition, new Point2D(10, 10), 28, 1, terrain));
            enemies.remove(e);
        }

        for(Teleporter teleporter:teleporters){
            teleporter.checkForTeleport(thanos);
        }
        //test for temp teleport
        if(thanos.myPosition.getX()<20){
            myGame.switchWorlds(teleportTo);
        }
    }

    public void renderWorld(GraphicsContext gc, Group root) {
        terrain.draw(gc, new Point2D((float) thanos.getCameraPosition().getX(), 0f), root);//draw terrain
        thanos.draw(gc);//draw the player
        for(Personnage enemy: enemies){
            enemy.draw(gc);//draw ai
        }
        for (Projectile cProjectile : worldProjectiles) {
            cProjectile.renderMe(gc, thanos.getCameraPosition());
        }
        for (FXEffect cExplosion : worldExplosions) {
            cExplosion.renderMe(gc, thanos.getCameraPosition());
        }

        for(Teleporter teleporter:teleporters){
            teleporter.renderMe(gc,thanos.getCameraPosition());
        }
    }

    public void dispose(Group root){
        terrain.removeCanvas(root);
    }

    public Point2D getStarterPos() {
        return new Point2D(starterPos.getX(),starterPos.getY());
    }
}




