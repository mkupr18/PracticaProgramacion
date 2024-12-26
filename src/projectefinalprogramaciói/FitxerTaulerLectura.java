/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinalprogramaciói;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author maria
 */
public class FitxerTaulerLectura {
    
    int random = generateNumber();
    
    //Mètode que donat un vaixell pugui treure sa fila i sa columna on marcaré després al tauler una 'x'
    public static void cercarCaracteriMarcarTauler(char caracter, char[][] tauler, char caracteraMarcar) throws FileNotFoundException, IOException {
        
        try {
            FileReader fr = new FileReader("10-10-5-4-3-3-2/" + 7 + ".txt");
            int indexFila = 0;
            int indexColumna = 0;
            int valor;
            
            while ((valor = fr.read()) != -1) {
                if (valor == '\n') {
                    indexFila++;
                    indexColumna = 0;
                } else { 
                    char[] casella = new char[2];
                    casella[0] = (char)(indexFila + 'A');
                    casella[1] = (char)(indexColumna + '1');
                    if (llegirContingutCasella(casella) == caracter) {
                        tauler[indexFila][indexColumna] = caracteraMarcar;
                    }
                    indexColumna++;
                    }
                }
            } catch (IOException e) {
            System.out.println("Error al llegir l'arxiu: " + e.getMessage());
        }
    }
    
    public static char llegirContingutCasella(char[] casella) {
        int fila = casella[0] - 'A';
        int columna = casella[1] - '0' - 1;
        if(casella.length > 2) {
            columna = 9 + (casella[2] - '0');
        }
        
        try {
            FileReader fr = new FileReader("10-10-5-4-3-3-2/" + 7 + ".txt");
            int indexFila = 0;
            int indexColumna = 0;
            int valor;

            while ((valor = fr.read()) != -1) {
                if (indexFila == fila && indexColumna == columna) {
                    return (char) valor;
                }

                if (valor == '\n' || valor == '\r') {
                    indexFila++;
                    indexColumna = 0;
                } else {
                    indexColumna++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al llegir l'arxiu: " + e.getMessage());
        }
        return '\0';
    }
    
    public int generateNumber() {
        Random ra = new Random();

        int num = ra.nextInt(99) + 1; //Elegeix un nombre aleatori entre el 0 i el 99
        return num;
    }
}
