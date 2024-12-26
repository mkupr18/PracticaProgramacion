/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinalprogramaciói;

/**
 *
 * @author maria
 */
public class Vaixell {
    
    int longitut = 2;
    int tocat = 0;
    
    public Vaixell(int longitut){
        this.longitut = longitut;
    }
    
    public boolean estaEnfonsat() {
        return longitut == tocat;
    }
    
    public void tocarVaixell(){
        tocat++;
    }
    
    public int getLongitut() {
        return longitut;
    }
    
    public int getTocat() {
        return tocat;
    }
}