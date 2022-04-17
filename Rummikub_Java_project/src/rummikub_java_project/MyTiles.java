/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummikub_java_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuComponent;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author romma
 */
public class MyTiles extends JPanel implements  ActionListener{
    private int rows;
    private int cols;
    private Image img;
    public static ArrayList<Tile> myTiles;
    private JButton b;
    public static boolean hasTileChosen;

       public MyTiles(ArrayList<Tile> m){
           this.myTiles = m;
           hasTileChosen = false;
           rows = 2;
           cols = 25;
           JButton b;
           super.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
           GridLayout g = new GridLayout(rows, cols, 10, 15);
            super.setLayout(g);
            super.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
       }
    public MyTiles(){
           hasTileChosen = false;
           rows = 2;
           cols = 25;
           JButton b;
           super.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
           GridLayout g = new GridLayout(rows, cols, 10, 15);
            super.setLayout(g);
            super.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }

    /**
     *
     * @param g
     */
    @Override
  protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    try{
            img  = ImageIO.read(getClass().getResource("/Resources/wood.gif"));
            g.drawImage(img, 0, 0, null);
            }
            catch(Exception e){}
}

    public ArrayList<Tile> getMyTiles() {
        return myTiles;
    }

    public void setMyTiles(ArrayList<Tile> myTiles) {
        this.myTiles = myTiles;
    }
  
    
    public MyTiles adding_update(){
        super.removeAll();
        super.revalidate();
        try{
        for (int i = 0; i < this.myTiles.size(); i++) 
        {
               b = new JButton(new ImageIcon(new javax.swing.ImageIcon(this.myTiles.get(i).getImg()).getImage().getScaledInstance(45, 60, Image.SCALE_SMOOTH)));
               b.putClientProperty("location", new Point(i,0));
               b.addActionListener(this);
               super.add(b);
        }
        }
        catch(Exception e){}
     
        super.repaint();
        return this;
       }

    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Point p = (Point) ((JButton)arg0.getSource()).getClientProperty("location");
        Screen.chosenTile = this.myTiles.get(p.x);
        Board.mytilesButton = (JButton) arg0.getSource();
        hasTileChosen=true;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public JButton getB() {
        return b;
    }

    public void setB(JButton b) {
        this.b = b;
    }

    public static boolean isHasTileChosen() {
        return hasTileChosen;
    }

    public static void setHasTileChosen(boolean hasTileChosen) {
        MyTiles.hasTileChosen = hasTileChosen;
    }
    

}



