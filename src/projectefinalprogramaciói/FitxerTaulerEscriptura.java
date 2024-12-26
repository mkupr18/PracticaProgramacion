/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinalprogramaciói;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author maria
 */
public class FitxerTaulerEscriptura {
    
    private static int comptadorPartides = 1;
    
    public static void registrarPartida(char[] nom, String tipusPartida, Tauler tauler) throws IOException {
        int disparsEnfonsats = tauler.getDisparsEnfonsats();
        int disparsTocats = tauler.getDisparsTocats();
        int disparsAigua = tauler.getDisparsAigua();
        
        String estadístiques = disparsEnfonsats + " dispars a vaixells enfonsats\n" + 
                disparsTocats + " dispars a vaixells tocats no enfonsats\n" + 
                disparsAigua + " dispars a l'aigua\n";
        
        //Arxiu on guarda la informació de la partida
        try (FileWriter escriure = new FileWriter("registre_partides.txt", true)) {
            //Escriure nom del jugador
            escriure.write("Partida " + comptadorPartides + " (" + generarDataiHora() + 
                    "). Mode /" + tipusPartida + "/, 10x10, 5-4-3-3-2.\n");
            escriure.write("- Jugador: /" + new String(nom) + "/ (guanyador/a):\n");
            escriure.write("    - " + estadístiques + "\n");
            escriure.write("\n");
            comptadorPartides++;
        } catch (IOException e) {
            System.out.println("Error en escriure al fitxer: " + e.getMessage());
        }
    }
    
    //Mètode per registrar els dispars
    public static void registrarDispar(char[] dispar, String resultatDispar) throws IOException {
        try(FileWriter escriure = new FileWriter("dispars_partides.txt", true)) {
            escriure.write("Dispar: ");
            //Escriure la casella del dispar
            escriure.write(new String(dispar));
            escriure.write(" - Resultat: " + resultatDispar + "\n");
        } catch (IOException e) {
            System.out.println("Error en escriure el dispar al fitxer: " + e.getMessage());
        }
    }
    
    private static String generarDataiHora() {
        LocalDateTime dataiHoraActual = LocalDateTime.now();
        DateTimeFormatter formatejador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dataiHoraActual.format(formatejador);
    }
}
