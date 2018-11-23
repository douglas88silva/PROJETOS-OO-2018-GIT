/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import Controller.Jogo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author 
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

       
        Jogo batalhaCartasPokemon = new Jogo();
        batalhaCartasPokemon.iniciaJogoConsole();
        //Duelo.exibirtempo();
        
    }
    
    
    public static void pausarAplicacao()
    {
        Scanner Pause = new Scanner (System.in);
        System.out.println("Press Enter to continue...");
        Pause.nextLine();
    }
    
}
