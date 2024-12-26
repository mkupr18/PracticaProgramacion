/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectefinalprogramaciói;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author maria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private char[] nom;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Main c = new Main();
        c.metodePrincipal();
    }

    private void metodePrincipal() throws FileNotFoundException, IOException {
        Jugador jugador = new Jugador();
        JugadorSolitari solitari = new JugadorSolitari();
        LT lt = new LT();
        Menu menu = new Menu();

        menu.menuPrincipal();

        if (menu.jugarTotSolSeleccionat()) {
            System.out.print("Introdueix el teu nom: ");
            //Llegeix el teu nom i el guarda com un array de tipus char
            nom = lt.llegirLinia();
            Tauler tauler = new Tauler();
            
            FitxerTaulerEscriptura.registrarPartida(nom, "Tot sol", tauler);
            
            //Mostra per pantalla el tauler
            tauler.mostrarTauler();
            System.out.print("Torn de ");
            //for per imprimir el nom que escrigui l'usuari
            for (int i = 0; i < nom.length; i++) {
                System.out.print(nom[i]);
            }
            System.out.println();

            while (!jugador.totsVaixellsEnfonsats(tauler)) {
                char[] dispar = solitari.disparar();
                jugador.marcarDispar(dispar, tauler);
                tauler.mostrarTauler();
            }
            
            FitxerTaulerEscriptura.registrarPartida(nom, "Tot sol", tauler);
            
            System.out.println("Has enfonsat tots els vaixells");
            System.out.print("Jugador guanyador: ");
            for (int i = 0; i < nom.length; i++) {
                System.out.print(nom[i]);
            }
            System.out.println();
            menu.menuPrincipal();
        }
        
        if (menu.jugarContraUnAltreSeleccionat()) {
            
            menu.menuPrincipal();
        }
        
        if (menu.jugarContraOrdinadorSeleccionat()) {
            
            menu.menuPrincipal();
        }
        
        if (menu.mostrarDetallsPartidesSeleccionat()) {
            //Obrim l'arxiu i llegim el seu contingut
            try {
                //Nombre de l'arxiu que té els detalls de les partides
                String rutaArxiu = "registres_partides.txt";
                
                //Obrim el fitxer per llegir-lo
                FileReader input = new FileReader(rutaArxiu);
                BufferedReader reader = new BufferedReader(input);
                
                //Llegeix linia per linia l'arxiu
                String fr = reader.readLine();
                boolean hiHaContingut = false;
                while (fr != null) {
                    System.out.println(fr);
                    fr = reader.readLine();
                    hiHaContingut = true;
                }
                
                if (!hiHaContingut) {
                    System.out.println("No hi ha registres de partides guardats");
                }
                
                reader.close();
                input.close();
            } catch (FileNotFoundException e) {
                System.out.println("No hi ha registres de partides guardats");
            } catch (IOException e) {
                System.out.println("Error al llegir els detalls de les partides: " + e.getMessage());
            }
            menu.menuPrincipal();
        }
        
        if (menu.estadistiquesJugadorSeleccionat()) {
            
            menu.menuPrincipal();
        }
    }
}