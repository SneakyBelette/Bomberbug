/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.ArrayList;

/**
 *
 * @author mclarion
 */
public class ListeMur {
    
    private ArrayList<Mur> listeMur;

    
    /*Constructeur*/
    public ListeMur() {
        this.listeMur = new ArrayList<>();
    }

    /*Getter*/
    public ArrayList<Mur> getListeMur() {
        return listeMur;
    }

    /*Setter*/
    public void setListeMur(ArrayList<Mur> listeMur) {
        this.listeMur = listeMur;
    }
    
    
    
    public void add(Mur mur){
        this.listeMur.add(mur);
    }
    
    public void remove(Mur mur){
        this.listeMur.remove(mur);
    }
    
    public void clear(){
        this.listeMur.clear();
    }
    
    
    public boolean estDansMur(int x, int y){
        boolean estDansMur = false;
        for(Mur mur : this.listeMur){
            if(mur.Contient(x, y)){
                estDansMur = true;
            }
        }
        return estDansMur;
    }
    
        
}
