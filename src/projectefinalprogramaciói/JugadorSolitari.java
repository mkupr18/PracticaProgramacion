/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinalprogramaciói;

/**
 *
 * @author maria
 */
public class JugadorSolitari {
    LT lt;
    
    public JugadorSolitari(){
        lt = new LT();
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
        return coordenada;    }
}