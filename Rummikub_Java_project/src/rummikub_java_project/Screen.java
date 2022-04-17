/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummikub_java_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author romma
 */
public class Screen extends JFrame{
    public static Board Board;
    public static  MyTiles myCards;
    public static OtherPlayers otherPlayers;
    public static JPanel startGame;
    public static Tiles tiles;
    public static Tile chosenTile;
    public static JButton start;
    public static Player [] players;

    public static Tile getChosenTile() {
        return chosenTile;
    }

    public static void setChosenTile(Tile chosenTile) {
        Screen.chosenTile = chosenTile;
    }
    
    
    
    public Screen(){
        this.chosenTile = null;
        Board = new Board();
        myCards = new MyTiles();
        startGame = new JPanel();
        otherPlayers = new OtherPlayers();
        start = new JButton();
        tiles = new Tiles();
        players = new Player[2];
        Player p = new Player();
        players[0] = p;
        p = new Player();
        players[1] = p;
        start.setText("Start Game");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setText("Restart");
                ArrayList<Tile> myTiles = new ArrayList();
                Random rnd = new Random();
                int place;
                int counter =0;
                while(counter!=14){
                    place = rnd.nextInt(106);
                    while(tiles.getTiles()[place].isIsUsed()){
                        place = rnd.nextInt(106);
                    }
                    counter++;
                    tiles.getTiles()[place].setIsUsed(true);
                    myTiles.add(tiles.getTiles()[place]);
                }
                myCards.setMyTiles(myTiles);
                myCards = myCards.adding_update();
                 start.setEnabled(false);
            }
        });
        startGame.add(start);
        startGame.setBackground(Color.decode("#1F51FF"));
        
        super.setBounds(900, 1000, 1500, 1000);// x, y, width, height
        super.add(startGame, BorderLayout.PAGE_START);
        super.add(myCards, BorderLayout.PAGE_END);
        super.add(Board, BorderLayout.LINE_END);
        super.add(otherPlayers,BorderLayout.LINE_START);
        
        super.setVisible(true);
        super.setTitle("Rummikub");       
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setBoard(Board Board) {
        this.Board = Board;
    }

    public void setMyCards(MyTiles myCards) {
        this.myCards = myCards;
    }

    public void setOtherPlayers(OtherPlayers otherPlayers) {
        this.otherPlayers = otherPlayers;
    }

    public void setStartGame(JPanel startGame) {
        this.startGame = startGame;
    }

    public void setTiles(Tiles tiles) {
        this.tiles = tiles;
    }
    
    
    
}
