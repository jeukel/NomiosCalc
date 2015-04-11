/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author jeukel
 */
public class Poli {
    private int x, y, A;
    
    public Poli (){
    }
    
    public Poli (int A, int x, int y){
        this.x = x;
        this.y = y;
        this.A = A;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setX(int elem){
        this.x = elem;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setY(int elem){
        this.y = elem;
    }
    
    public int getA(){
        return this.A;
    }
    
    public void setA(int elem){
        this.A = elem;
    }
}
