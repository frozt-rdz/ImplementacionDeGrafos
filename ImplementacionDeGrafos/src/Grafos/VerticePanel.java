/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;
/**
 *
 * @author crist
 */
public class VerticePanel extends Vertice {;
    
    int x,y; // ubicacion (x,y) del vertice
    
    public VerticePanel(int x, int y, String z) {
        this.x = x;
        this.y = y;
        super(z);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
