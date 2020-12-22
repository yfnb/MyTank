package com;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class TankFrame extends Frame {
/*    private int x = 200;
    private int y = 200;
    private static int SPEED = 10;
    private Dir dir=Dir.DOWN;*/
     Tank tank=new Tank(100,100,Dir.DOWN,false);

     Tank tank2=new Tank(200,300,Dir.DOWN,false);
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
        tank.paint(g);

        tank2.paint(g);
    }
    class MyKeyListener extends KeyAdapter {
        boolean bLeft = false;
        boolean bUp = false;
        boolean bRight = false;
        boolean bDown = false;


        @Override
        public void keyPressed(KeyEvent e) {
            tank.setMoving(true);
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
            setMainDir();
            repaint();
        }
        @Override
        public void keyReleased(KeyEvent e) {
            tank.setMoving(false);
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
            setMainDir();
            //dsafsdfdaf
        }
        private void setMainDir() {
            tank.setMainDir(bDown,bUp,bLeft,bRight);
        }
    }
}
