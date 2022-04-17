/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummikub_java_project;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import static rummikub_java_project.Board.tiles;
import static rummikub_java_project.Screen.tiles;

/**
 *
 * @author romma
 */
public class Player {
    public ArrayList<Tile> myTiles;

    public Player(){
        myTiles = new ArrayList<Tile>();
        randomInsert();
    }

    public void randomInsert(){
        Random rnd = new Random();
                int place;
                int counter =0;
                while(counter!=14){
                    place = rnd.nextInt(106);
                    while(Screen.tiles.getTiles()[place].isIsUsed()){
                        place = rnd.nextInt(106);
                    }
                    counter++;
                    Screen.tiles.getTiles()[place].setIsUsed(true);
                    myTiles.add(Screen.tiles.getTiles()[place]);
    }
}
    
    public boolean playTurn(){
        int i = 0;
        Tile [][] tiles = Board.tiles;
        int j;
        int k;
        Tile temp = null;
        Image img = null;
        try{
        img  = ImageIO.read(getClass().getResource("/Resources/blank.gif"));
        temp = new Tile(0, img, 0, new ColorDetails(1, "Blank"), false);
        }
        catch(Exception e){}
        
//        boolean flag = checkForSeries();
        
         for (k = 0; k < Board.cols; k++) {
             for (j = 0; j < Board.rows; j++) {
                 i = 0;
                 while(i < myTiles.size())
                {
                   if(!tiles[j][k].isIsUsed())
                   {
                        //temp = tiles[j][k];
                        tiles[j][k] = myTiles.get(i);
                        if(!Rules.isAscendingSeriesLtoR(tiles, j, k)  && !Rules.isSerieOfSameNum(tiles, j, k))
                        {
                           tiles[j][k] = temp;
                        }
                        else
                        {
                           myTiles.remove(i);
                           break;
                        }
                    }
                   i++;
                }
            }
        }
         Board.tiles = tiles;
         Screen.Board.adding_update();
         return (myTiles.size() == 0);
    }
}
//    
//    public void checkForSeries(int size, ArrayList<Tile> arr, int lastNum){
//         if(size == 0)
//             return;
//         if(myTiles.get(size-1).getNum() )
//    }
//    
//    public boolean check(int i){
//        int j = 0;
//        while(j < myTiles.size()){
//            if(i != j){
//                
//            }
//        }
//    }
//}