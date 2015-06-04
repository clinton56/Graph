package com;

import javax.swing.*;
import java.awt.*;

public class Graph{
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

