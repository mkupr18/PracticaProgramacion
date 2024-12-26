/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinalprogramaciói;

/**
 *
 * @author maria
 */
public class Menu {
    
    private LT lt;
    private boolean jugarTotSolSeleccionat;
    private boolean jugarContraUnAltreSeleccionat;
    private boolean jugarContraOrdinadorSeleccionat;
    private boolean mostrarDetallsPartidesSeleccionat;
    private boolean estadistiquesJugadorSeleccionat;
    
    public Menu() {
        lt = new LT();
        jugarTotSolSeleccionat = false;
        jugarContraUnAltreSeleccionat = false;
        jugarContraOrdinadorSeleccionat = false;
        mostrarDetallsPartidesSeleccionat = false;
        estadistiquesJugadorSeleccionat = false;
    }
    
    public void menuPrincipal() {
        lt = new LT();
        System.out.println("***********************************************************");
        System.out.println("MENU PRINCIPAL");
        System.out.println("***********************************************************");
        System.out.println("    1 Jugar");
        System.out.println("    2 Registre");
        System.out.println("    s Sortir");
        System.out.println("***********************************************************");
        System.out.print("Opció (1|2|s): ");
        char opcio1 = lt.llegirCaracter();
        
        switch (opcio1) {
            case '1':
                menuJugar();
                break;
            case '2':
                menuRegistre();
                break;
            case 's':
                sortir();
                break;
            default:
                System.out.println("Valor incorrecte");;
        }
    }
    
    public void menuJugar() {
        System.out.println("***********************************************************");
        System.out.println("JUGAR");
        System.out.println("***********************************************************");
        System.out.println("    1 Jugar tot sol");
        System.out.println("    2 Jugar contra un atre jugador");
        System.out.println("    3 Jugar contra l'ordinador");
        System.out.println("    s Tornar al menú principal");
        System.out.println("***********************************************************");
        System.out.print("Opció (1|2|3|s): ");
        char opcio2 = lt.llegirCaracter();
        
        switch (opcio2) {
            case '1':
                jugarTotSol();
                jugarTotSolSeleccionat = true;
                break;
            case '2':
                jugarContraUnAltre();
                jugarContraUnAltreSeleccionat = true;
                break;
            case '3':
                jugarContraOrdinador();
                jugarContraOrdinadorSeleccionat = true;
                break;
            case 's':
                menuPrincipal();
                break;
            default:
                System.out.println("Valor incorrecte");;
        }
    }
    
    public void menuRegistre() {
        System.out.println("***********************************************************");
        System.out.println("REGISTRE");
        System.out.println("***********************************************************");
        System.out.println("    1 Mostrar detalls de les partides");
        System.out.println("    2 Mostrar estadistiques d'un jugador");
        System.out.println("    s Tornar al menu principal");
        System.out.println("***********************************************************");
        System.out.print("Opció (1|2|s): ");
        char opcio3 = lt.llegirCaracter();
        
        switch (opcio3) {
            case '1':
                mostrarDetallsPartides();
                mostrarDetallsPartidesSeleccionat = true;
                break;
            case '2':
                estadistiquesJugador();
                estadistiquesJugadorSeleccionat = true;
                break;
            case 's':
                menuPrincipal();
                break;
            default:
                System.out.println("Valor incorrecte");;
        }
    }
    
    private void sortir() {
        System.out.println("Fins aviat!");
    }
    
    public void jugarTotSol() {
        System.out.println("***********************************************************");
        System.out.println("PARTIDA EN SOLITARI");
        System.out.println("***********************************************************");
    }
    
    private void jugarContraUnAltre() {
        System.out.println("***********************************************************");
        System.out.println("PARTIDA DE DOS JUGADORS");
        System.out.println("***********************************************************");
    }
    
    private void jugarContraOrdinador() {
        System.out.println("***********************************************************");
        System.out.println("PARTIDA CONTRA L'ORDINADOR");
        System.out.println("***********************************************************");
    }
    
    private void mostrarDetallsPartides() {
        System.out.println("***********************************************************");
        System.out.println("DETALLS DE LES PARTIDES");
        System.out.println("***********************************************************");
    }
    
    private void estadistiquesJugador() {
        System.out.println("***********************************************************");
        System.out.println("ESTADISTIQUES D'UN JUGADOR");
        System.out.println("***********************************************************");
    }
    
    public boolean jugarTotSolSeleccionat() {
        return jugarTotSolSeleccionat;
    }
    
    public boolean jugarContraUnAltreSeleccionat() {
        return jugarContraUnAltreSeleccionat;
    }
    
    public boolean jugarContraOrdinadorSeleccionat() {
        return jugarContraOrdinadorSeleccionat;
    }
    
    public boolean mostrarDetallsPartidesSeleccionat() {
        return mostrarDetallsPartidesSeleccionat;
    }
    
    public boolean estadistiquesJugadorSeleccionat() {
        return estadistiquesJugadorSeleccionat;
    }
}