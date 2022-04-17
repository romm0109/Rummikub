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
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import static rummikub_java_project.Screen.myCards;

/**
 *
 * @author romma
 */
public class Board extends JPanel implements ActionListener{
    public static int rows;
    public static int cols;
    private Image img;
    public static Tile[][] tiles;
    private JButton b;
    public static JButton mytilesButton;
    private Image blank;
    private Icon blankIcon;
    public static boolean isTurnEnd;
    public static ArrayList<Tile> singleTiles;
    public static int count;
    public static Point p;

    public JButton getMytilesButton() {
        return mytilesButton;
    }

    public void setMytilesButton(JButton mytilesButton) {
        this.mytilesButton = mytilesButton;
    }
    
    
    
    public Board(){
        isTurnEnd = false;
        count = 0;
        singleTiles = new ArrayList();
        int amount = 0;
        super.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        rows = 13;
        cols = 13;
        tiles = new Tile[rows][cols];
        GridLayout g = new GridLayout(rows, cols, 8,8);
        super.setLayout(g);
        super.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        try{
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                img  = ImageIO.read(getClass().getResource("/Resources/blank.gif"));
                tiles[i][j] = new Tile(amount, img, 0, new ColorDetails(1, "Blank"), false);
                b = new JButton(new ImageIcon(new javax.swing.ImageIcon(img).getImage().getScaledInstance(38, 45, Image.SCALE_SMOOTH)));
//                b.setBorderPainted(false); 
//                b.setContentAreaFilled(false); 
//                b.setFocusPainted(false); 
//                b.setOpaque(false);
                b.putClientProperty("location", new Point(i,j));
                b.addActionListener(this);
                super.add(b);
                amount++;
            }
        }
        }
        catch(Exception e){}
         super.setBackground(Color.red);  
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    try{
            img  = ImageIO.read(getClass().getResource("/Resources/background.gif"));
            g.drawImage(img, 0, 0, null);
            }
            catch(Exception e){}
}
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        p = (Point) ((JButton)arg0.getSource()).getClientProperty("location");
        Tile chosenTile = Screen.chosenTile;
        if(!chosenTile.isHasOnBoard() && MyTiles.hasTileChosen){
            count++;
            this.tiles[p.y][p.x] = chosenTile;
            ((JButton)arg0.getSource()).setIcon(new ImageIcon(new javax.swing.ImageIcon(chosenTile.getImg()).getImage().getScaledInstance(38, 45, Image.SCALE_SMOOTH)));
            chosenTile.setHasOnBoard(true);
            Screen.myCards.getMyTiles().remove(chosenTile);
            removeButton(mytilesButton); 
            MyTiles.hasTileChosen =false;
        
            if(!isTurnEnd && count != 0){
                 Screen.otherPlayers.update_(0);
            }
            else{
            if(count == 0){
                 Screen.otherPlayers.update_(2);
            }
            else{
                Screen.otherPlayers.update_(1);
            }
            }
            if(p.y + 1 < cols && p.y - 1 >= 0){
                if((tiles[p.y+1][p.x].getNum() == 0) && (tiles[p.y-1][p.x].getNum() == 0)){
                    singleTiles.add(tiles[p.y][p.x]);
            }
            }
            else{
                if(p.y + 1 == cols - 1 &&  (tiles[p.y-1][p.x].getNum() == 0))
                    singleTiles.add(tiles[p.y][p.x]);
                else{
                    if(p.y - 1 < 0 &&  (tiles[p.y+1][p.x].getNum() == 0))
                         singleTiles.add(tiles[p.y][p.x]);
                }
            }
        }
        else{
            if(!MyTiles.hasTileChosen && tiles[p.y][p.x].isHasOnBoard()){
                count--;
                for (int i = 0; i< singleTiles.size(); i++)
                {
                    if(tiles[p.y][p.x] == singleTiles.get(i)){
                        singleTiles.remove(i);
                        break;
                    }
                }
                Tile tile = tiles[p.y][p.x];
                tile.setHasOnBoard(false);
                Screen.myCards.getMyTiles().add(tile);
                try{
                img  = ImageIO.read(getClass().getResource("/Resources/blank.gif"));
                tiles[p.y][p.x] = new Tile(p.x%cols + p.y/rows, img,0,new ColorDetails(1, "Blank"), false);      
                }
                catch(Exception e){}  
            } 
        }
        adding_update(); 
        isTurnEnd = Rules.checkBoard(tiles);
                
                if(!isTurnEnd){
                     Screen.otherPlayers.update_(0);
                }
                else{
                    Screen.otherPlayers.update_(1);
                }
         Screen.myCards.adding_update();
       isTurnEnd = false;
       //Screen.otherPlayers = new OtherPlayers();
      
    }
    
    public void adding_update(){
        super.removeAll();
        super.revalidate();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                b = new JButton(new ImageIcon(new javax.swing.ImageIcon(tiles[j][i].getImg()).getImage().getScaledInstance(38, 45, Image.SCALE_SMOOTH)));
//                b.setBorderPainted(false); 
//                b.setContentAreaFilled(false); 
//                b.setFocusPainted(false); 
//                b.setOpaque(false);
                b.putClientProperty("location", new Point(i,j));
                b.addActionListener(this);
                super.add(b);
            }
        }
        super.repaint();
    }

    public void removeButton(JButton b){
        Screen.myCards.remove(b);
        Screen.myCards.repaint();
    }
    
}
