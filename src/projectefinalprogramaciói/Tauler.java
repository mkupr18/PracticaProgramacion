/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinalprogramaciói;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author maria
 */
public class Tauler {
    
    private char[][] tauler;
    Vaixell[] vaixells;
    private int nombreVaixellsEnfonsats;
    private int disparsEnfonsats;
    private int disparsTocats;
    private int disparsAigua;
    
    public Tauler() {
        tauler = new char[10][10];
        vaixells = inicialitzarVaixells();
        rellenarMatriu(); //Inicialitza el tauler al crear-lo
        nombreVaixellsEnfonsats = 0;
        disparsEnfonsats = 0;
        disparsTocats = 0;
        disparsAigua = 0;
    }
    
    private Vaixell[] inicialitzarVaixells() {
        Vaixell vaixell[] = new Vaixell[5];
        vaixell[0] = new Vaixell(5);
        vaixell[1] = new Vaixell(4);
        vaixell[2] = new Vaixell(3);
        vaixell[3] = new Vaixell(3);
        vaixell[4] = new Vaixell(2);

        return vaixell;
    }
    
    //Inicialitza el tauler amb un caràcter buit
    public void rellenarMatriu() {
        for (int i = 0; i < tauler.length; i++){
            for (int j = 0; j < tauler[i].length; j++){
                tauler[i][j] = '-';
            }
        }
    }
    
    public void mostrarTauler() {
        System.out.println("Tauler rival: ");
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        
        //Cream dos for per imprimir la matriu
        for (int i = 0; i < tauler.length; i++){
            System.out.print((char)('A' + i) + " "); //Lletres per les files
            for (int j = 0; j < tauler[i].length; j++){
                System.out.print(tauler[i][j] + " ");
            }
            System.out.println((char)('A' + i)); //Lletres al final de les files
        }
        
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        System.out.println();
    }
    
    public void marcarDispar(char[] casella) throws IOException {
        int fila = casella[0] - 'A';
        int columna = casella[1] - '0' - 1;
        if(casella.length > 2) {
            columna = 9 + (casella[2] - '0');
        }
        
        char contingutCasella = FitxerTaulerLectura.llegirContingutCasella(casella);
        int indexVaixell = Character.getNumericValue(contingutCasella); //casting no va be
        
        tauler[fila][columna] = 't';
        
        vaixells[indexVaixell].tocarVaixell();
        
        if(vaixells[indexVaixell].estaEnfonsat()) {
            marcarVaixellEnfonsat(contingutCasella);
            disparsEnfonsats++;
        } else {
            disparsTocats++;
        }
    }
    
    public boolean esVaixell(char[] casella) {
        char contingutCasella = FitxerTaulerLectura.llegirContingutCasella(casella);

        return (contingutCasella >= '0' && contingutCasella <= '9' || contingutCasella == 'v');
    }
    
    public boolean esVaixellTocat(char[] casella) {
        int fila = casella[0] - 'A';
        int columna = casella[1] - '0' - 1;
        if(casella.length > 2) {
            columna = 9 + (casella[2] - '0');
        }
        
        if (tauler[fila][columna] == 't') {
            return true;
        }
        return false;
    }
    
    //Mètode que donat un vaixell pugui treure sa fila i sa columna on marcaré després al tauler una 'x'
    public void marcarVaixellEnfonsat(char vaixell) throws FileNotFoundException, IOException {
        nombreVaixellsEnfonsats++; //Incrementam el comptador de vaixells enfonsats
        
        FitxerTaulerLectura.cercarCaracteriMarcarTauler(vaixell, tauler, 'x');
    }
    
    public void marcarAigua(char[] casella) {
        int fila = casella[0] - 'A';
        int columna = casella[1] - '0' - 1;
        if(casella.length > 2) {
            columna = 9 + (casella[2] - '0');
        }
        
        tauler[fila][columna] = 'a';
        disparsAigua++;
    }
    
    public void modificar(int fila, int columna, char valor) {
        tauler[fila][columna] = valor;
    }
    
    public char tornarChar(int fila, int columna) {
        return tauler[fila][columna];
    }
    
    public boolean totsVaixellsEnfonsats() {
        return nombreVaixellsEnfonsats == vaixells.length;
    }
    
    public int getDisparsTocats() {
        return disparsTocats;
    }
    
    public int getDisparsEnfonsats() {
        return disparsEnfonsats;
    }
    
    public int getDisparsAigua() {
        return disparsAigua;
    }
}