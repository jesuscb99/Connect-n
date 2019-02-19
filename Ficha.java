package connecta4;


/**
 * Write a description of class Ficha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ficha
{
    // instance variables - replace the example below with your own
    private int x;  
    private int equip;
    private int y;
    private String caracter;
    
    public Ficha(int abs, int e, String c) {
        x = abs;    
        equip = e;
        caracter = c;
    }
    
    public boolean equals(Object o) {
        return(o instanceof Ficha) 
        && equip == (((Ficha) o).equip);
        
        
    }
    
    public int getX(){ return x; }
    
    public String toString() {
        
        return " " + caracter + " ";
        
    }
    public int getEquip() {
        return equip;
    }
    
    public int getY(){
        return y;
    }
    
    public void setY(int o) {
        y = o;
    }
    }

