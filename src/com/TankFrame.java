package com;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private int x = 200;
    private int y = 200;


    public TankFrame() throws HeadlessException {

        setSize(800, 600);
        setResizable(false);
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
        g.fillRect(x, y, 50, 50);
        //   x+=10;
        //   y+=10;

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

            if(bLeft&bUp){
                x-=10;
                y-=10;

            }else if(bLeft&bDown){
                x-=10;
                y+=10;


            }else if(bRight&bUp){
                x+=10;
                y-=10;

            }else if(bRight&bDown){

                x+=10;
                y+=10;

            }else if(bLeft){
                x-=10;

            }else if(bRight){

                x+=10;
            }else if(bUp){
                y-=10;

            }else if(bDown){
                y+=10;

            }else{

                System.out.println("ammd");
            }

            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
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
                default:
                    break;
            }
        }
    }
}


