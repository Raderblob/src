package ThanosGame;

import ThanosGame.weapons.player.Stone;

import java.io.Serializable;

public class SaveGame implements Serializable {
    private final boolean finishedGame;
    private final int unlockedWorld;
    private final int selectedStone;
    private final Stone[] stones;
    private final int nbAme;
    public SaveGame(Thanos player){
        selectedStone=player.infinity.selectedStone;
        nbAme=player.infinity.nbAme;
        stones=player.infinity.stones;
        finishedGame=player.finishedGame;
        unlockedWorld=player.unlockedWorld;
    }

    public void loadGame(Thanos player){
        player.infinity.stones=stones;
        player.infinity.nbAme=nbAme;
        player.infinity.selectedStone=selectedStone;
        player.finishedGame=finishedGame;
        player.unlockedWorld=unlockedWorld;
    }
}
