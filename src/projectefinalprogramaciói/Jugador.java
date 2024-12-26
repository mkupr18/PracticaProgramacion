/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinalprogramaciói;

import java.io.IOException;

/**
 *
 * @author maria
 */
public class Jugador {

    LT lt;
    private char[][] matriu;

    public Jugador() {
        lt = new LT();
        matriu = new char[10][10];
    }

    public char[] disparar() {
        System.out.print("Introdueix la coordenada on vols disparar: ");
        char[] liniaLlegida = lt.llegirLinia();
        
        int fila = liniaLlegida[0] - 'A';
        int columna = liniaLlegida[1] - '0' - 1;
        if(liniaLlegida.length > 2) {
            columna = 9 + (liniaLlegida[2] - '0');
        }
        //Tornar la fila i la columna com un array de caràcters
        char[] coordenada = new char[2];
        coordenada[0] = (char) ('A' + fila);
        coordenada[1] = (char) ('0' + columna + 1);
        return coordenada;
    }

    public void marcarDispar(char[] dispar, Tauler tauler) throws IOException {
        if (tauler.esVaixell(dispar) && !tauler.esVaixellTocat(dispar)) {
            System.out.println("Tocat!");
            tauler.marcarDispar(dispar);
        } else if (!tauler.esVaixell(dispar) && !tauler.esVaixellTocat(dispar)) {
            System.out.println("Aigua!");
            tauler.marcarAigua(dispar);
        } else {
            System.out.println("Error: ja has disparat aquí");
        }
    }
    
    public boolean totsVaixellsEnfonsats(Tauler tauler) {
        return tauler.totsVaixellsEnfonsats();
    }
}