package ThanosGame.weapons.player;

import ThanosGame.Main;
import ThanosGame.World;
import ThanosGame.enemies.Personnage;
import ThanosGame.terrain.TerrainMap;
import ThanosGame.weapons.projectiles.FXEffect;
import javafx.geometry.Point2D;
import resources.AudioSaves;

import java.io.Serializable;
import java.util.LinkedList;

public class Stone implements Serializable {
    int stoneType;
    String stoneName;
    int myPower;
    long coolDown;
    long secondaryCoolDown;
    private long lastUsage;
    private boolean usedSecondary;

    public Stone() {
        stoneType = -1;
        stoneName = "Empty";
        myPower = 2;
        lastUsage = System.currentTimeMillis();
        coolDown = 1;
        secondaryCoolDown = 5000;
        usedSecondary = false;
    }

    private void reset() {
        if (isReset()) {
            lastUsage = System.currentTimeMillis();
        }
    }

    public double getCurrentCoolDown() {
        if(!usedSecondary) {
            return Math.min(coolDown, System.currentTimeMillis() - lastUsage) / ((double) (coolDown));
        }else{
            return Math.min(secondaryCoolDown, System.currentTimeMillis() - lastUsage) / ((double) (secondaryCoolDown));
        }
    }

    private boolean isReset() {
        return getCurrentCoolDown() == 1;
    }

    public void doAction(TerrainMap currentTerrain, World currentWorld, Point2D destroyAt) {
        if (isReset()) {
            if (doSubAction(currentTerrain, currentWorld, destroyAt) == 1) {
                reset();
                usedSecondary=false;
            }
        }
    }

    public void doSecondaryAction(TerrainMap currentTerrain,World currentWorld,Point2D destroyAt){
        if(isReset()) {
            if(doSubSecondaryAction(currentTerrain,currentWorld,destroyAt)==1){
                reset();
                usedSecondary=true;
            }
        }
    }
    int doSubSecondaryAction(TerrainMap currentTerrain, World currentWorld, Point2D destroyAt){
        return 0;
    }

    int doSubAction(TerrainMap currentTerrain, World currentWorld, Point2D destroyAt) {
        Point2D destination = new Point2D(destroyAt.getX(), destroyAt.getY());
        Point2D hitDistance = destination.add(currentWorld.thanos.myPosition.multiply(-1));

        hitDistance = hitDistance.normalize().multiply(currentWorld.thanos.mySize.getX());
        destination = hitDistance.add(currentWorld.thanos.myPosition);
        LinkedList<Point2D> pointsToChange = currentTerrain.getCircleOfPointsLinked(destination, 15);

        doDamage(currentWorld,destination,pointsToChange);
        doChanges(pointsToChange, (byte) 0, currentTerrain);
        currentWorld.worldExplosions.add(new FXEffect(destination,new Point2D(20,20),10,currentTerrain));
        AudioSaves.punchSound.play();
        return 1;
    }

    private void doDamage(World currentWorld, Point2D destroyAt, LinkedList<Point2D> pointsToChange){
        for(Personnage enemy:currentWorld.enemies){
            if(Main.getMagnitudeSquared(destroyAt.add(enemy.myPosition.multiply(-1)))< 1000){
                dmgPerEnemy(enemy,pointsToChange);
            }
        }
    }
    private void dmgPerEnemy(Personnage enemy,LinkedList<Point2D> pointsToChange){
        for(Point2D pT:pointsToChange){
            Point2D dist = pT.add(enemy.myPosition.multiply(-1));
            if(Math.abs(dist.getX())<enemy.mySize.getX()&&Math.abs(dist.getY())<enemy.mySize.getY()){
                enemy.removeHp(myPower);
                return;
            }
        }
    }

    void doChanges(LinkedList<Point2D> p, byte b, TerrainMap currentTerrain) {
        Point2D[] pTD = testMyDamage(p, currentTerrain);


        byte bTD[] = new byte[pTD.length];
        for (int i = 0; i < bTD.length; i++) {
            bTD[i] = b;
        }
        currentTerrain.changeTerrain(pTD, bTD);
    }

    private Point2D[] testMyDamage(LinkedList<Point2D> pTD, TerrainMap currentTerrain) {
        LinkedList<Point2D> res = new LinkedList<>();
        for (Point2D p : pTD) {
            if (Main.canDamage(currentTerrain.getTerrainVal(p), myPower)) {
                res.add(p);
            }
        }
        return res.toArray(new Point2D[0]);
    }

    public int myType(){
        return stoneType;
    }

    public String toString() {
        return stoneName;
    }

    public boolean isReal() {
        return stoneType != -1;
    }
}
