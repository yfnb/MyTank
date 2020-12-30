package com;

import gameFactory.BaseTank;
import gameFactory.OneSkinFactory;
import gameFactory.TwoSkinFactory;
import mediator.ColliderChain;
import util.PropertyMgr;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameModel {
    public static int GAME_WIDTH = 800;
    public static int GAME_HEIGHT = 600;

    private static GameModel gameModel = new GameModel();
    ColliderChain chain = new ColliderChain();


    public LinkedList<Rectangle> rectangles = new LinkedList<Rectangle>();
    public LinkedList<Explode> explodes = new LinkedList<Explode>();


    BaseTank myTank = null;

    private List<GameObject> objects = new LinkedList<>();


    public List<GameObject> getObjects() {
        return objects;
    }

    public void setObjects(List<GameObject> objects) {
        this.objects = objects;
    }


    {
        //使用工厂来创建坦克
        myTank = OneSkinFactory.getInstance().getTank(100, 100, Dir.DOWN, Group.GOOD, this);


        objects.add(myTank);

        Integer initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        BaseTank baseTank = null;
        for (int i = 1; i <= initTankCount; i++) {

            int x = (int) (Math.random() * TankFrame.GAME_WIDTH);
            int y = (int) (Math.random() * TankFrame.GAME_HEIGHT);

            TwoSkinFactory twoSkinFactory = TwoSkinFactory.getInstance();
            baseTank = twoSkinFactory.getTank(x, y, Dir.DOWN, Group.BAD, this);

            objects.add(baseTank);
        }

    }



    private GameModel() {
    }

    public static GameModel getInstance() {
        return gameModel;
    }

    public static GameModel getGameModel() {
        return gameModel;
    }

    public static void setGameModel(GameModel gameModel) {
        GameModel.gameModel = gameModel;
    }

    public LinkedList<Rectangle> getRectangles() {
        return rectangles;
    }

    public void setRectangles(LinkedList<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public LinkedList<Explode> getExplodes() {
        return explodes;
    }

    public void setExplodes(LinkedList<Explode> explodes) {
        this.explodes = explodes;
    }

    public BaseTank getMyTank() {
        return myTank;
    }

    public void paint(Graphics g) {
        if(myTank!=null){
            myTank.paint(g);
        }

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        collider();
    }

    private void collider() {
        for (int i = 0; i < objects.size(); i++) {
            for (int j = 0; j < objects.size(); j++) {
                if (i == j) {
                    continue;
                }
                chain.collide(objects.get(i), objects.get(j));
            }
        }
    }

    public void setMyTank(BaseTank myTank) {
        this.myTank = myTank;
    }

    public void myTankDie(){

        myTank=null;

    }


}
