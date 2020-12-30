package com;

import gameFactory.BaseBullet;
import gameFactory.BaseTank;
import gameFactory.OneSkinFactory;

import java.awt.*;
import java.util.ArrayList;

public class GameModel {
    public static int GAME_WIDTH = 800;
    public static int GAME_HEIGHT = 600;

   private static GameModel gameModel=new GameModel();


    public ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    public ArrayList<Explode> explodes = new ArrayList<Explode>();


    public  ArrayList<BaseBullet> bullets = null;
    BaseTank myTank = null;


    public ArrayList<BaseTank> tanks = null;

    {
        //使用工厂来创建坦克
        myTank = OneSkinFactory.getInstance().getTank(100, 100, Dir.DOWN, Group.GOOD, this);

        tanks = new ArrayList<BaseTank>();

        bullets = new ArrayList<BaseBullet>();

    }


    private GameModel() {
    }

    public static GameModel getInstance(){
        return gameModel;
    }

    public static GameModel getGameModel() {
        return gameModel;
    }

    public static void setGameModel(GameModel gameModel) {
        GameModel.gameModel = gameModel;
    }

    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    public void setRectangles(ArrayList<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public ArrayList<Explode> getExplodes() {
        return explodes;
    }

    public void setExplodes(ArrayList<Explode> explodes) {
        this.explodes = explodes;
    }

    public ArrayList<BaseBullet> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<BaseBullet> bullets) {
        this.bullets = bullets;
    }

    public BaseTank getMyTank() {
        return myTank;
    }

    public void setMyTank(BaseTank myTank) {
        this.myTank = myTank;
    }

    public ArrayList<BaseTank> getTanks() {
        return tanks;
    }

    public void setTanks(ArrayList<BaseTank> tanks) {
        this.tanks = tanks;
    }

    public void paint(Graphics g) {


        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).fire();
        }


        if (bullets.size() == 0) {
            return;
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWide(tanks.get(j));

            }
        }

    }
}
