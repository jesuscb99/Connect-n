package connecta4;

import java.util.Scanner;
/**
 * Write a description of class Joc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Joc
{   
    
     
    public static void main(String[] args) {
        int tir = 1;
        int joc = 1;
        
        Scanner tec = new Scanner(System.in);
        
        System.out.println("Benvingut al Connecta 4");
        
        System.out.println("Quants jugadors sou?");
        
        
        int nombreJugadors = tec.nextInt();
        Jugador[] llista = new Jugador[nombreJugadors + 1];
        
        
        
        for(int i = 1; i <= nombreJugadors; i++) {
            
            if(i == 1) {
                tec.nextLine();
                System.out.println("Jugador" + i + ", introdueix el teu nick");
                String nick = tec.nextLine();
                
                String caracter;
                do{
                    System.out.println("Ara el teu caracter per a la fitxa");
                    String c = tec.nextLine();
                    caracter = c;
                }
                while(caracter.length() != 1);
                
                
                caracter = caracter.toUpperCase();
                Jugador actual = new Jugador(nick, caracter);
                llista[i] = actual;
            }
            else {
                System.out.println("Jugador" + i + ", introdueix el teu nick");
                String nick = tec.nextLine();
                
                String caracter;
                do{
                    System.out.println("Ara el teu caracter per a la fitxa");
                    String c = tec.nextLine();
                    caracter = c;
                }
                while(caracter.length() != 1);
                
                caracter = caracter.toUpperCase();
                Jugador actual = new Jugador(nick, caracter);
                llista[i] = actual;
            }
           
        }
        
        System.out.println("Llista completada");
        
        System.out.println("Llista de jugadors:");
        
        for(int i = 1; i <= nombreJugadors; i++) {
            System.out.println(i + "." + llista[i].toString());
        }
        
        while(joc == 1) {
            int g = 0;
             while(g < 4 || g > 99){
                System.out.println("Tria una grandaria per a jugar (4 - 99): ");
                //try{
                g = tec.nextInt();
               // }catch(Exception e){
                  //  System.out.println("Introduix un nombre.");
            }
            
            System.out.println("ANEM A JUGAR");
            
            Taula a = new Taula(g);
            Ficha actual = new Ficha(0,0,"");
            boolean pas;
            
            a.draw();
            while(tir != 0) {
                    
                    String message = "\nTorn de " + llista[tir].toString() ;
                   
                    System.out.println(message);
                    
                    pas = false;
                    
                while(pas ==  false) {  
                    
                        
                        
                        System.out.println("Coordenada x de la fitxa: ");
                        int abs = tec.nextInt();
                        
                        Ficha j1 = new Ficha(abs,tir, llista[tir].getCaracter());
                        actual = j1;
                        if(a.add(j1) == true) { 
                            pas = true;
                            a.draw();
                            
                        }
                        
                    }
                       
                    
                    
                int check = a.comprovar(actual);
                
                if(check != 0) {
                    tir = 0;
                    
                    if(check == -1) {
                        System.out.println("\nFi del joc, heu quedat empatats. Ben jugat per part dels dos");
                    }
                    else {
                        System.out.println("\nEnhorabona, el jugador: " + llista[check].getNick().toUpperCase() + " ha guanyat la partida!!");
                    }
                }
                else {
                    tir++;
                    if(tir == nombreJugadors + 1) { 
                        tir = 1; 
                    }
                }
                }
            
            int res;
            do{
                System.out.println("Una revantxa??? \n0.SI\n1.NO"); 
                res = tec.nextInt();
                
            }
            while(res != 0 && res != 1);
            
            if(res == 1) {
                joc = 0;
                System.out.println("Bon Nadal");
            }
            else {
                tir = 1;
            }
        }
    }
        }           
    


