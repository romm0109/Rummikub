/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummikub_java_project;

import java.awt.Image;

/**
 *
 * @author romma
 */
public class Tile {
    private int tileID;
    private Image img;
    private boolean isUsed;
    private boolean hasOnBoard;
    private int num;
    private ColorDetails color;
    private boolean isjoker;
    private int TypeOfSerie; // 0 - has not any type, 1 - ascending, 2 - different color same number
    
    public Tile(int id, Image img, int num, ColorDetails color, boolean isJoker){
        this.img = img;
        this.isUsed = false;
        this.tileID = id;
        this.hasOnBoard = false;
        this.num = num;
        this.color = color;
        this.isjoker = isJoker;
        this.TypeOfSerie = 0;

    }

    public boolean isHasOnBoard() {
        return hasOnBoard;
    }

    public void setHasOnBoard(boolean hasOnBoard) {
        this.hasOnBoard = hasOnBoard;
    }

    
    public int getTileID() {
        return tileID;
    }

    public void setTileID(int tileID) {
        this.tileID = tileID;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public int getNum() {
        return num;
    }

    public ColorDetails getColor() {
        return color;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setColor(ColorDetails color) {
        this.color = color;
    }

    public boolean isIsjoker() {
        return isjoker;
    }

    public void setIsjoker(boolean isjoker) {
        this.isjoker = isjoker;
    }

    public int getTypeOfSerie() {
        return TypeOfSerie;
    }

    public void setTypeOfSerie(int TypeOfSerie) {
        this.TypeOfSerie = TypeOfSerie;
    }

    
}
