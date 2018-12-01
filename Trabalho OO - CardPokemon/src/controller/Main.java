/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Controller.Jogo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

       
        Jogo batalhaCartasPokemon = null;
        try {
            batalhaCartasPokemon = new Jogo();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            batalhaCartasPokemon.iniciaJogoConsole();
            //Duelo.exibirtempo();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void pausarAplicacao()
    {
        Scanner Pause = new Scanner (System.in);
        System.out.println("Press Enter to continue...");
        Pause.nextLine();
    }
    
}
