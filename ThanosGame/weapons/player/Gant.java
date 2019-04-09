package ThanosGame.weapons.player;

import ThanosGame.Thanos;
import ThanosGame.World;
import ThanosGame.terrain.TerrainMap;
import javafx.geometry.Point2D;

public class Gant {
    public Thanos owner;
    public int selectedStone;
    public Stone[] stones;
    public int nbAme;
    public int [] prixCooldown = new int [6];
    public int [] prixPuissance = new int [6];

    public Gant(Thanos owner) {
        this.owner = owner;
        stones = new Stone[4];
        nbAme = 0;
        for (int i = 0; i < stones.length; i++) {
            stones[i] = new Stone(owner);
        }
        selectedStone = 0;

        //Création des prix de base
        for(int i=0; i<prixCooldown.length; i++){
            prixCooldown[i]=5;
            prixPuissance[i]=5;
        }
    }

    public void PierreAme(){
        nbAme += 1;
    }

    public void addStones(Stone nStone) {
        stones[nStone.stoneType] = nStone;
    }

    public void selectStone(int stoneToSelect) {
        selectedStone = stoneToSelect;
    }

    public void selectNextStone() {
        selectedStone += 1;
        if (selectedStone >= stones.length) {
            selectedStone = 0;
        }
    }

    public void selectPreviousStone() {
        selectedStone -= 1;
        if (selectedStone < 0) {
            selectedStone = stones.length - 1;
        }
    }

    public void action(TerrainMap currentTerrain, World currentWorld, Point2D destroyAt) {
        destroyAt = currentTerrain.clampPoint(destroyAt);
        stones[selectedStone].doAction(currentTerrain, currentWorld, destroyAt);
    }

    public void secondaryAction(TerrainMap currentTerrain, World currentWorld, Point2D destroyAt) {
        destroyAt = currentTerrain.clampPoint(destroyAt);
        stones[selectedStone].doSecondaryAction(currentTerrain, currentWorld, destroyAt);
    }

    public int getNbPierres() {
        int nbPierres = 0;
        for(int i=0; i<stones.length;i++){
            if(stones[i]!=null){
                nbPierres++;
            }
        }
        return nbPierres;
    }

    public void niveauCooldown(int n){
        if(prixCooldown[n]<=25 && prixCooldown[n]>0){
            prixCooldown[n]=(prixCooldown[n]*5);
            stones[n].coolDown =  stones[n].coolDown/2;
            if(stones[n].secondaryCoolDown!=1) {
                stones[n].secondaryCoolDown = stones[n].secondaryCoolDown / 2;
            }
        }else if (prixCooldown[n]==125){
            prixCooldown[n]= 0;
            stones[n].coolDown =  stones[n].coolDown/2;
            if(stones[n].secondaryCoolDown!=1) {
                stones[n].secondaryCoolDown = stones[n].secondaryCoolDown / 2;
            }
        }
    }
    public void niveauPuissance(int n){
        if(prixPuissance[n]<=25 && prixPuissance[n]>0){
            prixPuissance[n]=(prixPuissance[n]*5);
            stones[n].myPower =  stones[n].myPower*2;
        }else if (prixPuissance[n]==125){
            prixPuissance[n]= 0;
            stones[n].myPower =  stones[n].myPower*2;
        }
    }

    public boolean hasStone(int s){
        for(int i=0;i<stones.length;i++){
            if (stones[i].myType()==s){
                return true;
            }

        }
        return false;
    }
}
