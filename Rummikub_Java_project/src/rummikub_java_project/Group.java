/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummikub_java_project;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;




/**
 *
 * @author romma
 */
public class Group{
    private ArrayList <Tile> group;

    public Group() {
       group = new ArrayList();
    }

    public ArrayList<Tile> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Tile> group) {
        this.group = group;
    }

    
}
