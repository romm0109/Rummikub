/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummikub_java_project;

/**
 *
 * @author romma
 */
public class Rules {
   public static int sum;
   private boolean wasItJoker;
    
   
   
public static boolean isAscendingSeriesLtoR(Tile[][] tiles, int x, int y){
    sum = 0;
    int counter = 1;
    int i;
    int lastNumber;
    i = x + 1;
    if(tiles[x][y].isIsjoker()){
        if(x-1 >= 0 && tiles[x-1][y].isIsUsed())
        {
            tiles[x][y].setColor(tiles[x-1][y].getColor());
            tiles[x][y].setNum(tiles[x-1][y].getNum()+1);
        }
        else{
            if(x+1 < Board.cols && tiles[x+1][y].isIsUsed())
            {
                 tiles[x][y].setColor(tiles[x+1][y].getColor());
                 tiles[x][y].setNum(tiles[x+1][y].getNum()-1);
            }
            else
            {
                return false;
            }
        }
    }
    if(tiles[x][y].getNum() == 0 || tiles[x][y].getNum() == 14)
                return false;
    tiles[x][y].setTypeOfSerie(1);
    lastNumber = tiles[x][y].getNum();
    while((i < Board.cols) && (((tiles[x][y].getColor().getColorID() == tiles[i][y].getColor().getColorID() && tiles[i][y].getNum() - 1 == lastNumber) || tiles[i][y].isIsjoker()) && (tiles[i][y].getTypeOfSerie() <= 1))){
        if(tiles[i][y].isIsjoker()){
            if(tiles[i-1][y].isIsUsed())
        {
            tiles[i][y].setColor(tiles[i-1][y].getColor());
            tiles[i][y].setNum(tiles[i-1][y].getNum()+1);
        }
        else
            {
               tiles[i][y].setColor(tiles[i+1][y].getColor());
               tiles[i][y].setNum(tiles[i+1][y].getNum()-1);
            }
            if(tiles[i][y].getNum() == 0 || tiles[i][y].getNum() == 14)
                return false;
        }
        tiles[i][y].setTypeOfSerie(1);
        lastNumber = tiles[i][y].getNum();
        counter++;
        sum += tiles[i][y].getNum();
        i++;
    }
    i = x-1;
    lastNumber = tiles[x][y].getNum();
    while((i >= 0) && (((tiles[x][y].getColor().getColorID() == tiles[i][y].getColor().getColorID() && tiles[i][y].getNum() + 1 == lastNumber) || tiles[i][y].isIsjoker()) && (tiles[i][y].getTypeOfSerie() <= 1))){
        
        if(tiles[i][y].isIsjoker()){
            
            if(tiles[i-1][y].isIsUsed())
        {
            tiles[i][y].setColor(tiles[i-1][y].getColor());
            tiles[i][y].setNum(tiles[i-1][y].getNum()+1);
        }
        else
            {
               tiles[i][y].setColor(tiles[i+1][y].getColor());
               tiles[i][y].setNum(tiles[i+1][y].getNum()-1);
            }
            if(tiles[i][y].getNum() == 0 || tiles[i][y].getNum() == 14)
                return false;
        }
        tiles[i][y].setTypeOfSerie(1);
        lastNumber = tiles[i][y].getNum();
        counter++;
        sum += tiles[i][y].getNum();
        i--;
    }
        
    return counter >= 3;
}
   
   
   
   
   

   public static boolean isSerieOfSameNum(Tile[][] tiles, int x, int y){
       int counter = 1;
       int sum = 0;
       int i = x + 1;
       boolean [] StatusArr = {false, false, false, false};
       if(tiles[x][y].isIsjoker()){
        if(x-1 >= 0 && tiles[x-1][y].isIsUsed())
        {
            tiles[x][y].setNum(tiles[x-1][y].getNum());
        }
        else{
            if(x+1 < Board.cols && tiles[x+1][y].isIsUsed())
            {
                 tiles[x][y].setNum(tiles[x+1][y].getNum());
            }
            else
            {
                return false;
            }
        }
    }
       tiles[x][y].setTypeOfSerie(2);
       while((i < Board.cols) && ((counter <= 4 && (tiles[x][y].getNum() == tiles[i][y].getNum()) || tiles[i][y].isIsjoker())) && (tiles[i][y].getTypeOfSerie() == 0 || (tiles[i][y].getTypeOfSerie()  == 2)))
       {
           if(!tiles[i][y].isIsjoker() && StatusArr[tiles[i][y].getColor().getColorID()] == true)
                return false;
           if(!tiles[i][y].isIsjoker()){
               StatusArr[tiles[i][y].getColor().getColorID()] = true;
           }
            tiles[i][y].setTypeOfSerie(2);
            counter++;
            sum += tiles[i][y].getNum();
            i++;
       }
       i = x-1;
       while((i >= 0) && ((counter <= 4 && (tiles[x][y].getNum() == tiles[i][y].getNum()) || tiles[i][y].isIsjoker())) && (tiles[i][y].getTypeOfSerie() == 0 || (tiles[i][y].getTypeOfSerie()  == 2)))
       {
           if(!tiles[i][y].isIsjoker() && StatusArr[tiles[i][y].getColor().getColorID()] == true)
                return false;
           if(!tiles[i][y].isIsjoker()){
               StatusArr[tiles[i][y].getColor().getColorID()] = true;
           }
            tiles[i][y].setTypeOfSerie(2);
            counter++;
            sum += tiles[i][y].getNum();
            i--;
       }
        
    return counter >= 3;
       
   }

   
   public static boolean isSumThirtey(Tile[][] tiles, int x, int y){
       if(isSerieOfSameNum(tiles,x,y) && sum >= 30){
           return true;
       }
//       if(isAscendingSeriesRtoL(tiles,x,y) && sum >= 30){
//           return true;
//       }
       if(isAscendingSeriesLtoR(tiles,x,y) && sum >= 30){
           return true;
       }
       return false;
   }
   
   public static boolean checkBoard(Tile[][] tiles){
       int i;
       int j;
       boolean flag = true;
       boolean temp = false;
       for (i = 0; i < Board.rows; i++) {
           for (j = 0; j < Board.cols; j++) {
               if(tiles[i][j].getNum() != 0){
                    flag = false;
                    flag = flag || isSerieOfSameNum(tiles, i, j);
                   // flag = flag || isAscendingSeriesRtoL(tiles, i, j);
                    flag = flag || isAscendingSeriesLtoR(tiles, i, j);
                    temp = flag;
                 }
               if(temp)
               {
                   flag = true;
               }
               if(!flag)
                   return false;
               temp = false;
           }
       }
       return flag;
   }
}

   
//   public static boolean isAscendingSeriesLtoR(Tile[][] tiles, int x, int y){
//       sum = 0;
//       int counter = 1;
//       int i = x + 1;
//       int before = x;
//       if(x+1 < Board.cols){
//            if(x+1 < Board.cols && tiles[x][y].isIsjoker() && tiles[x+1][y].isIsUsed())
//            {
//                 tiles[x][y].setNum(tiles[x+1][y].getNum()-1);
//                tiles[x][y].setColor(tiles[x+1][y].getColor());
//            }
//       }
//                if(x-1 >= 0)
//                {
//                    if(x-1 >= 0 && tiles[x][y].isIsjoker() && tiles[x-1][y].isIsUsed())
//                    {
//                        tiles[x][y].setNum(tiles[x-1][y].getNum()+1);
//                        tiles[x][y].setColor(tiles[x-1][y].getColor());
//                    }
//                }
//            
//       while((i >= 0 && i < Board.cols) && (((tiles[x][y].getColor().getColorID() == tiles[i][y].getColor().getColorID() && 
//               tiles[before][y].getNum()+1 == tiles[i][y].getNum()&& ((tiles[i+1][y].getNum() == 0) )&& ((i+1 < Board.cols) && tiles[i+1][y].getColor().getColorID() == tiles[i][y].getColor().getColorID()))) || tiles[i][y].isIsjoker()) ){ 
//           tiles[i][y].setNum(tiles[before][y].getNum()+1);
//           tiles[i][y].setColor(tiles[before][y].getColor());
//           counter++;
//           sum+=tiles[i][y].getNum();
//           before++;
//           i++;
//       }
//       i = x-1;
//       before = x;
//       while((i >= 0 && i < Board.cols) && (((tiles[x][y].getColor().getColorID() == tiles[i][y].getColor().getColorID() && 
//               tiles[before][y].getNum() == tiles[i][y].getNum()+1 && ((tiles[i-1][y].getNum() == 0)) && ((i-1 >= 0) && tiles[i-1][y].getColor().getColorID() == tiles[i][y].getColor().getColorID()))) || tiles[i][y].isIsjoker())){
//           tiles[i][y].setNum(tiles[i+1][y].getNum()-1);
//           tiles[i][y].setColor(tiles[before][y].getColor());
//           counter++;
//           sum+=tiles[i][y].getNum();
//           before--;
//           i--;
//       }
//       return counter >= 3;
//   }
   
//   public static boolean isAscendingSeriesRtoL(Tile[][] tiles, int x, int y){
//       sum = 0;
//       int counter = 1;
//       int i = x+1;
//       int before = x;
//       if(x+1 < Board.cols){
//            if(x+1 < Board.cols && tiles[x][y].isIsjoker() && tiles[x+1][y].isIsUsed())
//            {
//                 tiles[x][y].setNum(tiles[x+1][y].getNum()-1);
//                tiles[x][y].setColor(tiles[x+1][y].getColor());
//            }
//       }
//                if(x-1 >= 0)
//                {
//                    if(x-1 >= 0 && tiles[x][y].isIsjoker() && tiles[x-1][y].isIsUsed())
//                    {
//                        tiles[x][y].setNum(tiles[x-1][y].getNum()+1);
//                        tiles[x][y].setColor(tiles[x-1][y].getColor());
//                    }
//                }
//       while((i >= 0 && i < Board.cols) && (((tiles[x][y].getColor().getColorID() == tiles[i][y].getColor().getColorID() && 
//                tiles[before][y].getNum() == tiles[i][y].getNum()+1 && ((i+1 < Board.cols) &&(tiles[i+1][y].getNum() == 0)) && (tiles[i+1][y].getColor().getColorID() == tiles[i][y].getColor().getColorID())))  || tiles[i][y].isIsjoker())){
//           tiles[i][y].setNum(tiles[i-1][y].getNum()-1);
//           tiles[i][y].setColor(tiles[before][y].getColor());
//           counter++;
//           sum+=tiles[i][y].getNum();
//           before++;
//           i++;
//       }
//       i = x-1;
//       before = x;
//       while((i >= 0 && i < Board.cols) && (((tiles[x][y].getColor().getColorID() == tiles[i][y].getColor().getColorID()&& 
//               tiles[before][y].getNum()+1 == tiles[i][y].getNum() && ((tiles[i-1][y].getNum() == 0)) && ((i-1 >= 0) &&tiles[i-1][y].getColor().getColorID() == tiles[i][y].getColor().getColorID()))) || tiles[i][y].isIsjoker())){
//           tiles[i][y].setColor(tiles[before][y].getColor());
//           tiles[i][y].setNum(tiles[i+1][y].getNum()+1);
//           counter++;
//           sum+=tiles[i][y].getNum();
//           before--;
//           i--;
//       }
//       return counter >= 3;
//   }

//   public static boolean isSerieOfSameNum(Tile[][] tiles, int x, int y){
//       //y = 10 - y;
//       int counter = 1;
//       int i = x+1;
//       int before = x;
//       sum = 0;
//       int num;
//       int k = x;
//       while(tiles[k][y].isIsjoker())
//       {
//           k++;
//       }
//       if(!tiles[k][y].isIsUsed()){
//           k=x;
//            while(tiles[k][y].isIsjoker())
//            {
//                k--;
//            }
//       }
//       num = tiles[k][y].getNum();
//       boolean []hasPlaced = {false, false, false, false, false};
//       int placed = 1;
//       hasPlaced[tiles[x][y].getColor().getColorID()] = true;
//       while((i >= 0 && i < Board.cols)  && ((!hasPlaced[tiles[i][y].getColor().getColorID()]) && 
//               ((tiles[before][y].getNum() == tiles[i][y].getNum()) || tiles[i][y].isIsjoker()))){           
//                if(!tiles[i][y].isIsjoker()){
//                    hasPlaced[tiles[i][y].getColor().getColorID()] = true;
//                    }
//                sum+=num;
//                counter++;
//                before++;
//                i++; 
//                placed++;
//                if(placed > 4)
//                    return false;
//       }
//       i = x-1;
//       before = x;
//       while((i >= 0 && i < Board.cols) && ((!hasPlaced[tiles[i][y].getColor().getColorID()]) && 
//               ((tiles[before][y].getNum() == tiles[i][y].getNum()) || tiles[i][y].isIsjoker()))){
//         if(!tiles[i][y].isIsjoker()){
//               hasPlaced[tiles[i][y].getColor().getColorID()] = true;
//             }
//         sum+=num;
//           counter++;
//                before--;
//                i--; 
//           placed++;
//           if(placed > 4)
//               return false;
//       }
//       return counter >= 3;
//   }
   