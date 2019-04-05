package ThanosGame.weapons.player;

import ThanosGame.Thanos;
import ThanosGame.World;
import ThanosGame.terrain.TerrainMap;
import ThanosGame.weapons.FXEffect;
import javafx.geometry.Point2D;
import resources.AudioSaves;

import java.util.LinkedList;

public class RealityStone extends Stone {
    private final int SOUNDTIME =400;
    private long lastTime;

    public RealityStone(Thanos owner) {
        super(owner);
        stoneType = 1;
        stoneName = "Reality Stone";
        myPower = 10;
        coolDown = 10000;
        secondaryCoolDown = 1;
    }

    @Override
    protected int doSubAction(TerrainMap currentTerrain, World currentWorld, Point2D destroyAt) {
        AudioSaves.shieldSound.play();
        currentWorld.thanos.myShield += myPower*10;
        return 1;

    }

    @Override
    protected int doSubSecondaryAction(TerrainMap currentTerrain, World currentWorld, Point2D destroyAt) {
        LinkedList<Point2D> pointsToChange = new LinkedList<>();
        pointsToChange.add(destroyAt);
        pointsToChange.add(currentTerrain.clampPoint(destroyAt.add(4, 0)));
        pointsToChange.add(currentTerrain.clampPoint(destroyAt.add(4, 4)));
        pointsToChange.add(currentTerrain.clampPoint(destroyAt.add(0, 4)));
        if (currentTerrain.getTerrainVal(destroyAt) != 1) {
            doChanges(pointsToChange, (byte) 1, currentTerrain);
            currentWorld.worldExplosions.add(new FXEffect(destroyAt, new Point2D(20, 20), 4, currentTerrain));
            if (System.currentTimeMillis() - lastTime>SOUNDTIME) {
                AudioSaves.realityCreateSound.play();
                lastTime=System.currentTimeMillis();
            }
            return 1;
        } else {
            return 0;
        }
    }
}
