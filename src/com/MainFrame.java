package com;

import java.awt.*;

public class MainFrame {
    public static void main(String[] args) throws InterruptedException {
        Frame frame=new TankFrame();

while (true){
    Thread.sleep(50);
    frame.repaint();
}
    }

}
