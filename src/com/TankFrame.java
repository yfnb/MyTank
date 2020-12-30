package com;

import gameFactory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TankFrame extends Frame {
    private static TankFrame tf = new TankFrame();

    private static GameModel gameModel=GameModel.getInstance();
    Graphics g =null;
    Image offScreenImage = null;

    public static int GAME_WIDTH = 800;
    public static int GAME_HEIGHT = 600;

    public static BaseTank myTank=gameModel.getMyTank();


    public static TankFrame getInstance() {
        return tf;
    }

    private TankFrame() throws HeadlessException {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(true);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量：" + gameModel.getBullets().size(), 10, 60);
        g.drawString("敌人的数量：" + gameModel.getTanks().size(), 10, 80);
        g.drawString("碰撞模型对象的数量：" + gameModel.getRectangles().size(), 10, 100);
        g.drawString("屏幕上的爆炸数：" + gameModel.getExplodes().size(), 10, 120);
        g.setColor(c);
        gameModel.getMyTank().paint(g);

        gameModel.paint(g);

    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
        this.g=g;
    }

    class MyKeyListener extends KeyAdapter {
        boolean bLeft = false;
        boolean bUp = false;
        boolean bRight = false;
        boolean bDown = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bLeft = true;
                    break;
                case KeyEvent.VK_UP:
                    bUp = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bRight = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bDown = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            gameModel.getMyTank().setMoving(false);
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bLeft = false;
                    break;
                case KeyEvent.VK_UP:
                    bUp = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bRight = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bDown = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    gameModel.getMyTank().fire();
                default:
                    break;
            }
        //    setMainTankDir();
        }

        private void setMainTankDir() {
            if (bDown || bUp || bLeft || bRight) {
                myTank.setMoving(true);
            } else {
                myTank.setMoving(false);
                return;
            }

            if (bDown) {
                myTank.setDir(Dir.DOWN);
            }
            if (bUp) {
                myTank.setDir(Dir.UP);
            }
            if (bLeft) {
                myTank.setDir(Dir.LEFT);
            }
            if (bRight) {
                myTank.setDir(Dir.RIGHT);
            }
            myTank.move();
        }
    }
}
