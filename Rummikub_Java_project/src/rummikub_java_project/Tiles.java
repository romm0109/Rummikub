/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummikub_java_project;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author romma
 */
public class Tiles {
    private Tile []tiles;
    
    public Tiles(){
        int amount = 0;
        Image img = null;
        tiles = new Tile[106];
        for (int i = 0; i < 4; i++) 
        {
            for (int k = 0; k < 2; k++) 
            {
                 for (int j = 1; j <= 13; j++) 
                 {
                     switch (i){
                         case 0:
                             try{
                                     img  = ImageIO.read(getClass().getResource("/Resources/blue"+j+".gif"));
                                 }
                             catch(Exception e){}
                             tiles[amount]= new Tile(amount, img, j, new ColorDetails(i,"Blue"), false);
                             break;
                         case 1:
                             try{
                                     img  = ImageIO.read(getClass().getResource("/Resources/green"+j+".gif"));
                                 }
                             catch(Exception e){}
                             tiles[amount]= new Tile(amount, img, j, new ColorDetails(i,"Green"), false);
                             break;
                         case 2:
                             try{
                                     img  = ImageIO.read(getClass().getResource("/Resources/red"+j+".gif"));
                                 }
                             catch(Exception e){}
                             tiles[amount]= new Tile(amount, img, j, new ColorDetails(i,"Red"), false);
                             break;
                         case 3:
                             try{
                                     img  = ImageIO.read(getClass().getResource("/Resources/yellow"+j+".gif"));
                                 }
                             catch(Exception e){}
                             tiles[amount]= new Tile(amount, img, j, new ColorDetails(i,"Yelow"), false);
                             break;
                     }
                     amount++;
                 }
            }   
        }
        try{
       tiles[amount] = new Tile(amount, ImageIO.read(getClass().getResource("/Resources/joker.PNG")),14,new ColorDetails(4, "joker"), true);
       amount++;
       tiles[amount] = new Tile(amount, ImageIO.read(getClass().getResource("/Resources/joker.PNG")),14,new ColorDetails(4, "joker"), true);
         }
        catch(Exception e){}     
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }
    
    
}
