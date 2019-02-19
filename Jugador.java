package connecta4;


/**
 * Write a description of class Jugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jugador
{
    private String nick;
    private String caracter;
    
    public Jugador(String n, String c) {
        nick = n;
        caracter = c;
    }
    
    public String getCaracter() {
        return caracter;
        
    }
    
    public String getNick() {
        return nick;
    }
    
    public String toString() {
        String res;
        
        res = nick.toUpperCase() + "(Fitxes: " + caracter + ")";
        
        return res;
    }
}
