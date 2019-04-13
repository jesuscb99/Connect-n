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

        int check = 1;
       

        boolean actual = true;
        if(a.getY() >= nombreLinea - 1) {
            for(int i = 0; i < nombreLinea; i++) {
                actual = actual && a.getEquip() == casella[a.getX()][a.getY() - i].getEquip();
            }
        }
        else {
            actual = false;
        }
        if(actual) {
            return a.getEquip();
        }
        return res;
    }

    /**
     * Comprova horizontalment si hi ha algun equip guanyador. Torna 1 si guanya l'equip1, torna 2 si guanya
     * l'equip 2, i torna 0 si no guanya cap.
     */
    private int  comprovarHorizontal(Ficha a) {
        int res = 0;

        boolean actual = true;
        

        if(a.getX() <= costat - nombreLinea ) {
            for(int i = 0; i < nombreLinea; i++) {    
                if(casella[a.getX() + i][a.getY()] != null) {
                    actual = actual && a.getEquip() == casella[a.getX() + i][a.getY()].getEquip();
                }
                else {actual = false; }
            }
            
            if(actual) { return a.getEquip();}
        }

        actual = true;
        
        if(a.getX() >= nombreLinea - 1) {
            for(int i = 0; i < nombreLinea; i++) {  
                if(casella[a.getX() - i][a.getY()] != null) {
                    actual = actual && a.getEquip() == casella[a.getX() - i][a.getY()].getEquip();
                }
                else { actual = false; }
            }
            
            if(actual) { return a.getEquip();}
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

        boolean actual = true;
        if(a.getY() <= costat - nombreLinea - 1 && a.getX() <= costat - nombreLinea - 1) {

            for (int i = 0; i < nombreLinea; i++) {
                if(casella[a.getX() + i][a.getY() + i] != null) {
                    actual = actual && a.getEquip() == casella[a.getX() + i][a.getY() + i].getEquip();
                }
                else { actual = false;}
            }
            if(actual) {
                System.out.println("1");
                return a.getEquip();
            }
        }
        actual = true;

        if(a.getY() >= nombreLinea - 1 && a.getX() >= nombreLinea - 1) {

            for (int i = 0; i < nombreLinea; i++) {
                if(casella[a.getX() - i][a.getY() - i] != null) {
                    actual = actual && a.getEquip() == casella[a.getX() - i][a.getY() - i].getEquip();
                }
                else { actual = false;}
            }
            if(actual) {
                System.out.println("2");
                return a.getEquip();
            }

        }
        /**
         * Diagonals \
         */

        actual= true;
        if(a.getY() <= costat - nombreLinea - 1 && a.getX() >= nombreLinea - 1) {

            for (int i = 0; i < nombreLinea; i++) {
                if(casella[a.getX() - i][a.getY() + i] != null) {
                    actual = actual &&  a.getEquip() == casella[a.getX() - i][a.getY() + i].getEquip();
                }
                else { actual = false;}
            }
            if(actual) {
                System.out.println("3");
                return a.getEquip();
            }

        }

        actual = true;
        if(a.getY() >= nombreLinea - 1 && a.getX() <= costat - nombreLinea - 1) {

            
            for (int i = 0; i < nombreLinea; i++) {
                if(casella[a.getX() + i][a.getY() - i] != null) {
                    actual = a.getEquip() == casella[a.getX() + i][a.getY() - i].getEquip();
                }
                else { actual = false;}
            }

            if(actual) {
                System.out.println("4");
                return a.getEquip();
            }
        }

        return res;

    }

    /**
     * Crea quatre arrays que correspon a una diagonal de fiches cada una, sent diag1 i diag2, la 
     * diagonal superior esquerra i la diagonal superior dreta respectivament,
     * diag3 = diagonal inferior esquerra
     * diag4 = diagonal inferior dreta. 
     */

    /**
     * Comprova si hi ha algun equip guanyador. Torna 1 si guanya l'equip1, torna 2 si guanya
     * l'equip 2, torna 0 si no guanya cap, i torna 3 si hi ha empat(taula completada)
     */
    public int comprovar(Ficha a) {
        int res = 0;
        if(comprovarHorizontal(a) != 0 || comprovarVertical(a) != 0 || comprovarDiagonal(a) != 0) {
            if(comprovarHorizontal(a) != 0) {
                res = comprovarHorizontal(a);
                //System.out.println("Horizontal");
            }
            else if(comprovarVertical(a) != 0) {
                res = comprovarVertical(a);
               // System.out.println("Vertical");
            }
            else {
                res = comprovarDiagonal(a);
                //System.out.println("Diagonal");
            }
        }

        if(numFitxes == costat * costat && res == 0) {
            res = -1;
        }
        return res;
    }
}
