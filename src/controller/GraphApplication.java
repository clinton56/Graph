package controller;

import view.mainFrame;

import javax.swing.*;
import java.awt.*;

public class GraphApplication {
    public static void main(String[]args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                mainFrame f = new mainFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}

