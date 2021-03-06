package resources;


import ThanosGame.terrain.PixelBlockType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BuildingSaves {
    private static final int MODULEDIMENSION = 20;
    public static final byte[][][] moduleTemplates = new byte[10][MODULEDIMENSION][MODULEDIMENSION];
    public static final byte[][][] largeBases = new byte[1][][];

    public static byte[][] thanosBase;
    public static byte[][] ironManBase;
    public static byte[][] captainBase;
    public static byte[][] thorBase;
    public static byte[][] SpidermanBase;


    public static void loadBuildings(){
        for(int i=0;i<moduleTemplates.length;i++){
            moduleTemplates[i]=readModule("module" + i + ".png");
        }
        //load largeBase
        largeBases[0] = readModule("largeBase0.png");
        thanosBase = readModule("ThanosBase.png");
        ironManBase = readModule("Base_Iron_man.png");
        captainBase = readModule("Captain_america.png");
        thorBase = readModule("Base_Thor.png");
        SpidermanBase = readModule("Base_SpiderMan.png");
    }

    private static byte[][] readModule(String str) {
        byte res[][];
        BufferedImage img;
        try {
            img = ImageIO.read(BuildingSaves.class.getClassLoader().getResourceAsStream("resources/buildings/" +str));
        } catch (IOException e) {
            e.printStackTrace();
            img = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
        }
        res = new byte[img.getWidth()][img.getHeight()];
        for (int x = 0; x < res.length; x++) {
            for (int y = 0; y < res[x].length; y++) {
                int myRGB = img.getRGB(x, y);
                System.out.println(myRGB + " " + new Color(myRGB).toString());
                switch (myRGB) {
                    case -16777216:
                        res[x][y] = PixelBlockType.BRICK.getMyVal();
                        break;
                    case -14606047:
                        res[x][y] =(byte) -PixelBlockType.BRICK.getMyVal();
                        break;
                    case -65281:
                        res[x][y] = PixelBlockType.BEDROCK.getMyVal();
                        break;
                    case -6737152:
                        res[x][y] = -100;
                        break;
                    case -8388608:
                        res[x][y] = PixelBlockType.BRICK3.getMyVal();
                        break;
                    case -256:
                        res[x][y] = PixelBlockType.UNDEFINED1.getMyVal();
                        break;
                    case -16744448:
                        res[x][y] = PixelBlockType.GRASS.getMyVal();
                        break;
                    case -8388480:
                        res[x][y] = PixelBlockType.UNDEFINED2.getMyVal();
                        break;
                    case -13421773:
                        res[x][y] = PixelBlockType.BRICK2.getMyVal();
                        break;
                    case -65536:
                        res[x][y] = PixelBlockType.UNDEFINED3.getMyVal();
                        break;
                    case -6908266:
                        res[x][y] = PixelBlockType.STONE.getMyVal();
                        break;
                    case -8355712:
                        res[x][y] = (byte) -PixelBlockType.STONE.getMyVal();
                        break;
                    default:
                        res[x][y] =0;
                        break;
                }
            }
        }

        return res;
    }

}



