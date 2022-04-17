/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummikub_java_project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import static rummikub_java_project.Screen.tiles;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author romma
 */
public class OtherPlayers extends JPanel{
    public static JButton btn;
    
    public OtherPlayers(){
        btn = new JButton("Take a tile");

        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                     if(Board.count == 0){
                      Random rnd = new Random();
                      int place = rnd.nextInt(106);
                    while(Screen.tiles.getTiles()[place].isIsUsed()){
                        place = rnd.nextInt(106);
                    }
                    Screen.tiles.getTiles()[place].setIsUsed(true);
                    Screen.myCards.myTiles.add(Screen.tiles.getTiles()[place]);
                    Screen.myCards.adding_update();
                    Board.count = 0;
                  }
                        btn.setEnabled(false);
                        update_(2);
//                        try 
//                        {
//                            TimeUnit.SECONDS.sleep(1);
//                        } 
//                        catch (InterruptedException ex) 
//                         {
//                            Logger.getLogger(OtherPlayers.class.getName()).log(Level.SEVERE, null, ex);
//                         }
                         Screen.players[0].playTurn();
//                         try 
//                        {
//                            TimeUnit.SECONDS.sleep(1);
//                        } 
//                        catch (InterruptedException ex) 
//                         {
//                            Logger.getLogger(OtherPlayers.class.getName()).log(Level.SEVERE, null, ex);
//                         }
                         Screen.players[1].playTurn();
                         btn.setEnabled(true);
                         btn.setText("Take a tile");
                         Board.count = 0;
                         update_(2);
            }
        });
        JLabel text = new JLabel("Opponents:");
        text.setFont(new Font("Serif", Font.BOLD, 30));
        JLabel deck = new JLabel("Your Tiles:");
        deck.setFont(new Font("Serif", Font.BOLD, 30));
        Image img1 = null;
        Image img2 = null;
        JLabel label1 = new JLabel();
        GridLayout g = new GridLayout(7, 1, 1, 1);
        super.setLayout(g);
        JLabel label2 = new JLabel();
         try{
            label1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/avram.PNG")).getImage().getScaledInstance(120, 140, Image.SCALE_SMOOTH)));
            }
         catch(Exception e){}
          try{
            label2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saul.PNG")).getImage().getScaledInstance(120, 140, Image.SCALE_SMOOTH)));
            }
         catch(Exception e){}
         super.add(text);
         super.add(label1);
         super.add(Box.createVerticalStrut(1));
         super.add(label2);
         super.add(Box.createVerticalStrut(5));
         super.add(btn);
         super.add(deck);
    }
    
    public void update_(int n){
        super.removeAll();
        super.revalidate();
        btn = new JButton("End Turn");

        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  if(Board.count == 0){
                      Random rnd = new Random();
                      int place = rnd.nextInt(106);
                    while(Screen.tiles.getTiles()[place].isIsUsed()){
                        place = rnd.nextInt(106);
                    }
                    Screen.tiles.getTiles()[place].setIsUsed(true);
                    Screen.myCards.myTiles.add(Screen.tiles.getTiles()[place]);
                    Screen.myCards.adding_update();
                  }
                        btn.setEnabled(false);
                        update_(2);
//                        try 
//                        {
//                            TimeUnit.SECONDS.sleep(1);
//                        } 
//                        catch (InterruptedException ex) 
//                         {
//                            Logger.getLogger(OtherPlayers.class.getName()).log(Level.SEVERE, null, ex);
//                         }
//                         Screen.players[0].playTurn();
//                         try 
//                        {
//                            TimeUnit.SECONDS.sleep(1);
//                        } 
//                        catch (InterruptedException ex) 
//                         {
//                            Logger.getLogger(OtherPlayers.class.getName()).log(Level.SEVERE, null, ex);
//                         }
                         Screen.players[1].playTurn();
                         btn.setEnabled(true);
                         btn.setText("Take a tile");
                         Board.count = 0;
                         update_(2);   
            }
        });
        JLabel text = new JLabel("Opponents:");
        text.setFont(new Font("Serif", Font.BOLD, 30));
        JLabel deck = new JLabel("Your Tiles:");
        deck.setFont(new Font("Serif", Font.BOLD, 30));
        Image img1 = null;
        Image img2 = null;
        JLabel label1 = new JLabel();
        GridLayout g = new GridLayout(7, 1, 1, 1);
        super.setLayout(g);
        JLabel label2 = new JLabel();
         try{
            label1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/avram.PNG")).getImage().getScaledInstance(120, 140, Image.SCALE_SMOOTH)));
            }
         catch(Exception e){}
          try{
            label2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saul.PNG")).getImage().getScaledInstance(120, 140, Image.SCALE_SMOOTH)));
         }
         catch(Exception e){}
          if(n == 0){
                btn.setText("Invalid move");
                btn.setEnabled(false);
         }
         if(n==1){
                 btn.setText("End Turn");
                 btn.setEnabled(true);
         }
          if(Board.count == 0 || n == 2){
              btn.setText("Take a tile");
              btn.setEnabled(true);
          }
         super.add(text);
         super.add(label1);
         super.add(Box.createVerticalStrut(1));
         super.add(label2);
         super.add(Box.createVerticalStrut(5));
         super.add(btn);
         super.add(deck);
         
         super.repaint();
    }
}
