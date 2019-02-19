package connecta4;


/**
 * Write a description of class Taula here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Taula
{
    private int costat;
    
    private Ficha[][] casella;
    private int numFitxes;
    private int nombreLinea = 4;
    
    public Taula(int g) {
        costat = g;
        casella = new Ficha[g][g];
        numFitxes = 0;
    }
    
    public boolean add(Ficha a) {
        boolean res = false;
        int i = 0;
        
        if(numFitxes < costat*costat && a.getX() < costat && a.getX() >= 0) {
            while(i < costat && !res) {
                if(casella[a.getX()][i] == null) {
                    casella[a.getX()][i] = a;
                    res = true;
                    numFitxes++;
                    a.setY(i);
                }
                i++;
            }
        }
        
        return res;
    }
    
    public Ficha getFicha(int x, int y) {
        return casella[x][y];
    }
    
    public void setCasellaANull(int x, int y) {
        casella[x][y] = null;
    }
    
    public void draw() {
        for(int y = costat - 1; y >= 0; y--) {
            System.out.print("|");
            for(int x = 0; x < costat; x++) {
                if(casella[x][y] == null) {
                System.out.print("   "); 
               }
               else {
               System.out.print(casella[x][y].toString()); 
            }
            }
            System.out.print("|");
            System.out.println();
        }
        for(int x = 0; x < costat; x++) {
            System.out.print("---");
        }
        System.out.println();
        System.out.print(" ");
        for(int i = 0; i < costat; i++) {
            if(i < 10) { System.out.print(" " + i + " "); }
            else { System.out.print(" " + i);
            
        }
        }
    }
    /**
     * Comprova verticalment si hi ha algun equip guanyador. Torna 1 si guanya l'equip1, torna 2 si guanya
     * l'equip 2, i torna 0 si no guanya cap.
     */
    private int comprovarVertical(Ficha a) {
        int res = 0;
        
       
        /*
        if(a.getY() >= 3) {
        if(casella[a.getX()][a.getY()] != null && casella[a.getX()][a.getY() - 1] != null && casella[a.getX()][a.getY() - 2] != null && casella[a.getX()][a.getY() - 3] != null) {
                    int primer = casella[a.getX()][a.getY()].getEquip();
                    int segon = casella[a.getX()][a.getY() - 1].getEquip();
                    int tercer = casella[a.getX()][a.getY() - 2].getEquip();
                    int quart = casella[a.getX()][a.getY() - 3].getEquip();
                    
                    if(primer == segon && primer == tercer && primer == quart) {
                        res = primer;
                    }
        
                }
            }*/
        
        int check = 1;
        int actual = casella[a.getX()][a.getY()].getEquip();
        int passat;
        
        if(a.getY() >= nombreLinea - 1) {
            for(int i = 0; i <= nombreLinea - 1; i++) {
                passat = actual;
                actual = casella[a.getX()][a.getY() - i].getEquip();
                
                if(passat == actual) { check = 1; }
                else { check = 0; }
            }
            if(check == 1) {res = a.getEquip();}
        }
        
        
        return res;
    }
    /**
     * Comprova horizontalment si hi ha algun equip guanyador. Torna 1 si guanya l'equip1, torna 2 si guanya
     * l'equip 2, i torna 0 si no guanya cap.
     */
    private int  comprovarHorizontal(Ficha a) {
        int res = 0;
      
        int check = 1;
        int actual = casella[a.getX()][a.getY()].getEquip();
        int passat;
        
        if(a.getX() <= costat - nombreLinea ) {
            /*if(casella[a.getX()][a.getY()] != null && casella[a.getX() + 1][a.getY()] != null && casella[a.getX() + 2][a.getY()] != null && casella[a.getX() + 3][a.getY()] != null) {
                    int primer = casella[a.getX()][a.getY()].getEquip();
                    int segon = casella[a.getX() + 1][a.getY()].getEquip();
                    int tercer = casella[a.getX() + 2][a.getY()].getEquip();
                    int quart = casella[a.getX() + 3][a.getY()].getEquip();
                    
                    if(primer==(segon) && primer==(tercer) && primer==(quart)) {
                        res = primer;
                    }
            }  */ 
            for(int i = 0; i < nombreLinea; i++) {
                passat = actual;
                if(casella[a.getX() + i][a.getY()] != null) {
                    actual = casella[a.getX() + i][a.getY()].getEquip();
                    if(passat == actual) { check = 1; }
                    else { check = 0; }
                }
                else {check = 0; }
            }
            if(check == 1) {res = a.getEquip();}
        }
        
        actual = casella[a.getX()][a.getY()].getEquip();
        check = 1;
        
        if(a.getX() >= nombreLinea - 1) {
           /* if(casella[a.getX()][a.getY()] != null && casella[a.getX() - 1][a.getY()] != null && casella[a.getX() - 2][a.getY()] != null && casella[a.getX() - 3][a.getY()] != null) {
                    int primer = casella[a.getX()][a.getY()].getEquip();
                    int segon = casella[a.getX() - 1][a.getY()].getEquip();
                    int tercer = casella[a.getX() - 2][a.getY()].getEquip();
                    int quart = casella[a.getX() - 3][a.getY()].getEquip();
                    
                    if(primer==(segon) && primer==(tercer) && primer==(quart)) {
                        res = primer;
                    }
            }   */
           for(int i = 0; i < nombreLinea; i++) {
                passat = actual;     
                if(casella[a.getX() - i][a.getY()] != null) {
                    actual = casella[a.getX() - i][a.getY()].getEquip();
                    if(passat == actual) { check = 1; }
                    else { check = 0; }
                }
                else { check = 0; }
            }
           if(check == 1) {res = a.getEquip();}
        }
        return res;
    }
    /**
     * Comprova en les diagonals si hi ha algun equip guanyador. Torna 1 si guanya l'equip1, torna 2 si guanya
     * l'equip 2, i torna 0 si no guanya cap.
     */
    private int  comprovarDiagonal(Ficha a) {
        int res = 0;
        /**
         * Diagonals /
         */
        
        if(a.getY() <= costat - 3 && a.getX() <= costat - 3) {
            if(casella[a.getX()][a.getY()] != null && casella[a.getX() + 1][a.getY() + 1] != null && casella[a.getX() + 2][a.getY() + 2] != null && casella[a.getX() + 3][a.getY() + 3] != null) {
                    int primer = casella[a.getX()][a.getY()].getEquip();
                    int segon = casella[a.getX() + 1][a.getY() + 1].getEquip();
                    int tercer = casella[a.getX() + 2][a.getY() + 2].getEquip();
                    int quart = casella[a.getX() + 3][a.getY() + 3].getEquip();
                    
                    if(primer==(segon) && primer==(tercer) && primer==(quart)) {
                           res = primer;
                        }
                    }
        }
        
        if(a.getY() >= 3 && a.getX() >= 3) {
            if(casella[a.getX()][a.getY()] != null && casella[a.getX() - 1][a.getY() - 1] != null && casella[a.getX() - 2][a.getY() - 2] != null && casella[a.getX() - 3][a.getY() - 3] != null) {
                        int primer = casella[a.getX()][a.getY()].getEquip();
                        int segon = casella[a.getX() - 1][a.getY() - 1].getEquip();
                        int tercer = casella[a.getX() - 2][a.getY() - 2].getEquip();
                        int quart = casella[a.getX() - 3][a.getY() - 3].getEquip();
                        
                        if(primer==(segon) && primer==(tercer) && primer==(quart)) {
                               res = primer;
                            }
                        }
        }
        /**
         * Diagonals \
         */
        /*for(int j = 0; j <= costat - 4; j++) {
            for(int i = 3; i <= costat - 1; i++) {
                if(casella[i][j] != null && casella[i - 1][j + 1] != null && casella[i - 2][j + 2] != null && casella[i - 3][j + 3] != null) {
                    int primer = casella[i][j].getEquip();
                    int segon = casella[i  - 1][j + 1].getEquip();
                    int tercer = casella[i - 2][j + 2].getEquip();
                    int quart = casella[i -  3][j + 3].getEquip();
                    
                    if(primer==(segon) && primer==(tercer) && primer==(quart)) {
                            res = primer;
                        }
                    }
            }
        }*/
        
        if(a.getY() <= costat - 3 && a.getX() >= 3) {
            if(casella[a.getX()][a.getY()] != null && casella[a.getX() - 1][a.getY() + 1] != null && casella[a.getX() - 2][a.getY() + 2] != null && casella[a.getX() - 3][a.getY() + 3] != null) {
                        int primer = casella[a.getX()][a.getY()].getEquip();
                        int segon = casella[a.getX() - 1][a.getY() + 1].getEquip();
                        int tercer = casella[a.getX() - 2][a.getY() + 2].getEquip();
                        int quart = casella[a.getX() - 3][a.getY() + 3].getEquip();
                        
                        if(primer==(segon) && primer==(tercer) && primer==(quart)) {
                               res = primer;
                            }
                        }
        }
        
        if(a.getY() <= costat - 3 && a.getX() >= 3) {
            if(casella[a.getX()][a.getY()] != null && casella[a.getX() - 1][a.getY() + 1] != null && casella[a.getX() - 2][a.getY() + 2] != null && casella[a.getX() - 3][a.getY() + 3] != null) {
                        int primer = casella[a.getX()][a.getY()].getEquip();
                        int segon = casella[a.getX() - 1][a.getY() + 1].getEquip();
                        int tercer = casella[a.getX() - 2][a.getY() + 2].getEquip();
                        int quart = casella[a.getX() - 3][a.getY() + 3].getEquip();
                        
                        if(primer==(segon) && primer==(tercer) && primer==(quart)) {
                               res = primer;
                            }
                        }
        }
        
        if(a.getY() >= 3 && a.getX() <= costat - 3) {
            if(casella[a.getX()][a.getY()] != null && casella[a.getX() + 1][a.getY() - 1] != null && casella[a.getX() + 2][a.getY() - 2] != null && casella[a.getX() + 3][a.getY() - 3] != null) {
                        int primer = casella[a.getX()][a.getY()].getEquip();
                        int segon = casella[a.getX() + 1][a.getY() - 1].getEquip();
                        int tercer = casella[a.getX() + 2][a.getY() - 2].getEquip();
                        int quart = casella[a.getX() + 3][a.getY() - 3].getEquip();
                        
                        if(primer==(segon) && primer==(tercer) && primer==(quart)) {
                               res = primer;
                            }
                        }
        }
        
        return res;
    }
    /**
     * Comprova si hi ha algun equip guanyador. Torna 1 si guanya l'equip1, torna 2 si guanya
     * l'equip 2, torna 0 si no guanya cap, i torna 3 si hi ha empat(taula completada)
     */
    public int comprovar(Ficha a) {
       int res = 0;
       if(comprovarHorizontal(a) != 0 || comprovarVertical(a) != 0 || comprovarDiagonal(a) != 0) {
           if(comprovarHorizontal(a) != 0) {
               res = comprovarHorizontal(a);
            }
            else if(comprovarVertical(a) != 0) {
                res = comprovarVertical(a);
            }
            else {
                res = comprovarDiagonal(a);
            }
       }
       
       if(numFitxes == costat * costat && res == 0) {
            res = -1;
       }
       return res;
    }
}
