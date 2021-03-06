package ThanosGame.menus;


import ThanosGame.Thanos;
import resources.ImagesSaves;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInventaire extends JFrame implements ActionListener {
    private final JButton bRouge;
    private final JButton bVert;
    private final JButton bBleu;
    private final JButton bViolet;
    private final JButton bOrange;
    private final JButton bJaune;
    private final JButton b2Rouge;
    private final JButton b2Vert;
    private final JButton b2Bleu;
    private final JButton b2Violet;
    private final JButton b2Orange;
    private final JButton b2Jaune;
    private final JButton moreLife;
    private final JLabel PV;
    private final JLabel Ame;
    private final JPanel Pv2;
    private final Thanos thanos;


    public MenuInventaire(Thanos thanos) {
        this.thanos = thanos;
        //nbPierres = 6;




        //Création de la fenêtre et son en-tête
        {
            String texteTitre = "INVENTAIRE";
            setTitle(texteTitre);
            setLayout(null);//c null
            setSize(960, 720);
            setLocation(0, 0);
            setResizable(false);
        }

        //Texte
        int x2Bouton = 700;
        int x1Bouton = 500;
        int hauteurBouton = 50;
        int longueurBouton = 150;
        JPanel cooldown1;
        JPanel puissance1;
        {
            JLabel puissance = new JLabel("Puissance :");
            puissance.setBounds(40,0, longueurBouton, hauteurBouton);
            puissance.setForeground(Color.WHITE);
            puissance1 = new JPanel();
            puissance1.setLayout(null);
            puissance1.setBounds(x1Bouton,15, longueurBouton, hauteurBouton);
            puissance1.setBackground(Color.black);
            puissance1.add(puissance);

            JLabel cooldown = new JLabel("Cooldown :");
            cooldown.setBounds(40,0, longueurBouton, hauteurBouton);
            cooldown.setForeground(Color.WHITE);
            cooldown1 = new JPanel();
            cooldown1.setLayout(null);
            cooldown1.setBounds(x2Bouton,15, longueurBouton, hauteurBouton);
            cooldown1.setBackground(Color.black);
            cooldown1.add(cooldown);

        }

        //Bouton Pierres Puissance
        {   //Violet
            {
                bViolet = new JButton("");
                bViolet.setBounds(x1Bouton, 100, longueurBouton, hauteurBouton);
                bViolet.setBackground(new Color(75, 15, 125));
                bViolet.setForeground(Color.white);
                bViolet.addActionListener(this);
            }
            //Rouge
            {
                bRouge = new JButton("");
                bRouge.setBounds(x1Bouton, 200, longueurBouton, hauteurBouton);
                bRouge.setBackground(Color.red);
                bRouge.setForeground(Color.white);
                bRouge.addActionListener(this);
            }
            //Bleu
            {
                bBleu = new JButton("");
                bBleu.setBounds(x1Bouton, 300, longueurBouton, hauteurBouton);
                bBleu.setBackground(Color.blue);
                bBleu.setForeground(Color.white);
                bBleu.addActionListener(this);
            }
            //Jaune
            {
                bJaune = new JButton("Esprit : Lvl max");
                bJaune.setBounds(x1Bouton, 400, longueurBouton, hauteurBouton);
                bJaune.setBackground(new Color(255, 255, 0));
                bJaune.setForeground(Color.white);
                bJaune.addActionListener(this);
            }
            //Vert
            {
                bVert = new JButton("Temps : Lvl max");
                bVert.setBounds(x1Bouton, 500, longueurBouton, hauteurBouton);
                bVert.setBackground(Color.green);
                bVert.setForeground(Color.white);
                bVert.addActionListener(this);
            }
            //Orange
            {
                bOrange = new JButton("");
                bOrange.setBounds(x1Bouton, 600, longueurBouton, hauteurBouton);
                bOrange.setBackground(new Color(255, 96, 0));
                bOrange.setForeground(Color.white);
                bOrange.addActionListener(this);
            }
        }

        //Bouton Pierres Cooldown
        {   //Violet
            {
                b2Violet = new JButton("");
                b2Violet.setBounds(x2Bouton, 100, longueurBouton, hauteurBouton);
                b2Violet.setBackground(new Color(75, 15, 125));
                b2Violet.setForeground(Color.white);
                b2Violet.addActionListener(this);
            }
            //Rouge
            {
                b2Rouge = new JButton("");
                b2Rouge.setBounds(x2Bouton, 200, longueurBouton, hauteurBouton);
                b2Rouge.setBackground(Color.red);
                b2Rouge.setForeground(Color.white);
                b2Rouge.addActionListener(this);
            }

            //Bleu
            {
                b2Bleu = new JButton("");
                b2Bleu.setBounds(x2Bouton, 300, longueurBouton, hauteurBouton);
                b2Bleu.setBackground(Color.blue);
                b2Bleu.setForeground(Color.white);
                b2Bleu.addActionListener(this);
            }
            //Jaune
            {
                b2Jaune = new JButton("");
                b2Jaune.setBounds(x2Bouton, 400, longueurBouton, hauteurBouton);
                b2Jaune.setBackground(new Color(255, 255, 0));
                b2Jaune.setForeground(Color.white);
                b2Jaune.addActionListener(this);
            }
            //Vert
            {
                b2Vert = new JButton("");
                b2Vert.setBounds(x2Bouton, 500, longueurBouton, hauteurBouton);
                b2Vert.setBackground(Color.green);
                b2Vert.setForeground(Color.white);
                b2Vert.addActionListener(this);
            }
            //Orange
            {
                b2Orange = new JButton("");
                b2Orange.setBounds(x2Bouton, 600, longueurBouton, hauteurBouton);
                b2Orange.setBackground(new Color(255, 96, 0));
                b2Orange.setForeground(Color.white);
                b2Orange.addActionListener(this);
            }

        }

        //Bouton More Life
        {
            moreLife = new JButton("Augmenter Vie : ");
            moreLife.setBounds(75,getHeight() / 2 + 200, 350, 50);
            moreLife.setBackground(Color.red);
            moreLife.setForeground(Color.white);
            moreLife.addActionListener(this);
        }

        //Photo du personnage
        JLabel perso;
        {
            perso = new JLabel();
            perso.setIcon(new ImageIcon(ImagesSaves.class.getResource("menus/thanos.jpg")));
            perso.setLocation(0, 5);
            perso.setSize(350, 310);
        }

        //Cadre perso
        JPanel conteneurPerso;
        {
            int x1, y1;
            x1 = 350;
            y1 = 320;
            conteneurPerso = new JPanel();
            conteneurPerso.setLayout(null);
            conteneurPerso.add(perso);
            conteneurPerso.setBounds(75, getHeight() / 2 - y1 / 2, x1, y1);
            conteneurPerso.setBackground(Color.white);
        }

        //Fond
        JLabel fond;
        {
            fond = new JLabel();
            fond.setIcon(new ImageIcon(ImagesSaves.class.getResource("menus/th2.jpg")));
            fond.setLocation(0, 0);
            fond.setSize(getWidth(), getHeight());
        }

        //Barre de vie
        JPanel pv1;
        {
            PV = new JLabel("" + thanos.getPV() + "/" + thanos.getMaxPv());
            PV.setBounds(300/2, 0, 350, 50);
            PV.setForeground(Color.WHITE);
            Pv2 = new JPanel();
            Pv2.setBounds(0,0,(int)(350*thanos.getHp()),50);
            Pv2.setBackground(Color.RED);
            pv1 = new JPanel();
            pv1.setLayout(null);
            pv1.setBounds(75,getHeight() / 2 - 220,350,50);
            pv1.setBackground(Color.BLACK);
            pv1.add(PV);
            pv1.add(Pv2);
        }

        //Ame
        JPanel ame1;
        {
            Ame = new JLabel(""+thanos.infinity.nbAme);
            Ame.setBounds(250,0,350,50);
            Ame.setForeground(Color.WHITE);
            JLabel ameTxt = new JLabel("Âmes :");
            ameTxt.setBounds(50,0,350,50);
            ameTxt.setForeground(Color.WHITE);
            ame1 = new JPanel();
            ame1.setLayout(null);
            ame1.setBounds(75,getHeight() / 2 - 270,350,50);
            ame1.setBackground(Color.BLACK);
            ame1.add(Ame);
            ame1.add(ameTxt);
        }

        //Conteneur Main
        JPanel conteneurMain;
        {
            conteneurMain = new JPanel();
            conteneurMain.setLayout(null);
            conteneurMain.add(bRouge);
            conteneurMain.add(bVert);
            conteneurMain.add(bBleu);
            conteneurMain.add(bViolet);
            conteneurMain.add(bJaune);
            conteneurMain.add(bOrange);
            conteneurMain.add(b2Rouge);
            conteneurMain.add(b2Vert);
            conteneurMain.add(b2Bleu);
            conteneurMain.add(b2Violet);
            conteneurMain.add(b2Jaune);
            conteneurMain.add(b2Orange);
            conteneurMain.add(conteneurPerso);
            conteneurMain.add(puissance1);
            conteneurMain.add(cooldown1);
            conteneurMain.add(pv1);
            conteneurMain.add(ame1);
            conteneurMain.add(moreLife);
            conteneurMain.add(fond);
            conteneurMain.setBounds(0, 0, getWidth(), getHeight());
        }

        add(conteneurMain);
        setVisible(false);
    }

    public void update(){
        Pv2.setBounds(0,0,(int)(350*thanos.getHp()),50);
        PV.setText("" + thanos.getPV() + "/" + thanos.getMaxPv());
        Ame.setText(""+thanos.infinity.nbAme);


        bViolet.setText("Pouvoir : "+this.thanos.infinity.prixPuissance[0]);
        bRouge.setText("Réalité : "+this.thanos.infinity.prixPuissance[1]);
        bBleu.setText("Espace : "+this.thanos.infinity.prixPuissance[2]);
        bJaune.setText("Esprit : "+this.thanos.infinity.prixPuissance[3]);
        bVert.setText("Temps : Lvl max");
        bOrange.setText("Âme : Lvl max");

        b2Violet.setText("Pouvoir : "+this.thanos.infinity.prixCooldown[0]);
        b2Rouge.setText("Réalité : "+this.thanos.infinity.prixCooldown[1]);
        b2Bleu.setText("Espace : "+this.thanos.infinity.prixCooldown[2]);
        b2Jaune.setText("Esprit : "+this.thanos.infinity.prixCooldown[3]);
        b2Vert.setText("Temps : Lvl max");
        b2Orange.setText("Âme : Lvl max");

        moreLife.setText("Augmenter Vie : "+thanos.prixVie);

        if(thanos.prixVie==0){
            moreLife.setText("Vie au max");
        }

        if(thanos.infinity.prixPuissance[0]==0){
            bViolet.setText("Lvl max");
        }
        if(thanos.infinity.prixPuissance[1]==0){
            bRouge.setText("Lvl max");
        }
        if(thanos.infinity.prixPuissance[2]==0){
            bBleu.setText("Lvl max");
        }
        if(thanos.infinity.prixPuissance[3]==0){
            bJaune.setText("Lvl max");
        }

        if(thanos.infinity.prixCooldown[0]==0){
            b2Violet.setText("Lvl max");
        }
        if(thanos.infinity.prixCooldown[1]==0){
            b2Rouge.setText("Lvl max");
        }
        if(thanos.infinity.prixCooldown[2]==0){
            b2Bleu.setText("Lvl max");
        }
        if(thanos.infinity.prixCooldown[3]==0){
            b2Jaune.setText("Lvl max");
        }

        if(thanos.infinity.hasStone(0)){
            bViolet.setVisible(false);
            b2Violet.setVisible(false);
        }else{
            bViolet.setVisible(true);
            b2Violet.setVisible(true);
        }
        if(thanos.infinity.hasStone(1)){
            bRouge.setVisible(false);
            b2Rouge.setVisible(false);
        }else{
            bRouge.setVisible(true);
            b2Rouge.setVisible(true);
        }
        if(thanos.infinity.hasStone(2)){
            bBleu.setVisible(false);
            b2Bleu.setVisible(false);
        }
        else{
            bBleu.setVisible(true);
            b2Bleu.setVisible(true);
        }
        if(thanos.infinity.hasStone(3)){
            bJaune.setVisible(false);
            b2Jaune.setVisible(false);
        }
        else{
            bJaune.setVisible(true);
            b2Jaune.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        //Puissance
        {
            if (e.getSource() == bViolet && thanos.infinity.nbAme>=thanos.infinity.prixPuissance[0]) {
                thanos.infinity.nbAme-=thanos.infinity.prixPuissance[0];
                thanos.infinity.niveauPuissance(0);
            }
            if (e.getSource() == bRouge && thanos.infinity.nbAme>=thanos.infinity.prixPuissance[1]) {
                thanos.infinity.nbAme-=thanos.infinity.prixPuissance[1];
                thanos.infinity.niveauPuissance(1);
            }
            if (e.getSource() == bBleu && thanos.infinity.nbAme>=thanos.infinity.prixPuissance[2]) {
                thanos.infinity.nbAme-=thanos.infinity.prixPuissance[2];
                thanos.infinity.niveauPuissance(2);
            }
            if (e.getSource() == bJaune && thanos.infinity.nbAme>=thanos.infinity.prixPuissance[3]) {
            thanos.infinity.nbAme-=thanos.infinity.prixPuissance[3];
            thanos.infinity.niveauPuissance(3);
            }
        }

        //Cooldown
        {
            if (e.getSource() == b2Violet && thanos.infinity.nbAme>=thanos.infinity.prixCooldown[0]) {
                thanos.infinity.nbAme-=thanos.infinity.prixCooldown[0];
                thanos.infinity.niveauCooldown(0);
            }
            if (e.getSource() == b2Rouge && thanos.infinity.nbAme>=thanos.infinity.prixCooldown[1]) {
                thanos.infinity.nbAme-=thanos.infinity.prixCooldown[1];
                thanos.infinity.niveauCooldown(1);
            }
            if (e.getSource() == b2Bleu && thanos.infinity.nbAme>=thanos.infinity.prixCooldown[2]) {
                thanos.infinity.nbAme-=thanos.infinity.prixCooldown[2];
                thanos.infinity.niveauCooldown(2);
            }
            if (e.getSource() == b2Jaune && thanos.infinity.nbAme>=thanos.infinity.prixCooldown[3]) {
                thanos.infinity.nbAme-=thanos.infinity.prixCooldown[3];
                thanos.infinity.niveauCooldown(3);
            }

        }

        //Vie
        {
            if (e.getSource() == moreLife && thanos.infinity.nbAme>=thanos.prixVie) {
                thanos.infinity.nbAme = thanos.infinity.nbAme - thanos.prixVie;
                if(thanos.prixVie<=25 && thanos.prixVie>0){
                    thanos.setPv(thanos.getMaxPv()*2);
                    thanos.prixVie=thanos.prixVie*5;
                }else if (thanos.prixVie==125) {
                    thanos.prixVie = 0;
                    thanos.setPv(thanos.getMaxPv() * 2);
                }
            }

        }
        update();
    }


}

