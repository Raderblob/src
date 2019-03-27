package ThanosGame.terrain;


import javafx.geometry.Point2D;

import java.util.LinkedList;

public class LargeBase {
    private Point2D myPos;
    private byte[][] myArray;

    public LargeBase(byte[][] baseArray, Point2D basePos) {
        myPos = basePos;
        myArray = baseArray;
    }


    public void changeTerrain(TerrainMap theTerrain) {
        LinkedList<Point2D> PToChange = new LinkedList<>();
        LinkedList<Byte> fVals = new LinkedList<>();

        for (int x = 0; x < myArray.length; x++) {
            for (int y = 0; y < myArray[x].length; y++) {
                if (myArray[x][y] != -1) {
                    PToChange.add(new Point2D(x * 4, y * 4).add(myPos));
                    fVals.add(myArray[x][y]);
                }
            }
        }

        byte fValsFinal[] = new byte[fVals.size()];
        for (int i = 0; i < fValsFinal.length; i++) {
            fValsFinal[i] = fVals.get(i);
        }
        theTerrain.changeTerrain(PToChange.toArray(new Point2D[0]), fValsFinal);
    }
}
