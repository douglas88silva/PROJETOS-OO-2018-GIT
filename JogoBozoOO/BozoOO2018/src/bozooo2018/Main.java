/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bozooo2018;

/**
 *
 * @author HomeNot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

        Jogador x1 = new Jogador("Jogador 1");
        Jogador x2 = new Jogador("Jogador 2");
        
        Jogo Bozo = new Jogo();
        
        Bozo.addJogador(x1);
        Bozo.addJogador(x2);
        
        Bozo.iniciaJogo();
        //Bozo.mostrarDados();
        
        
       
    }
    
}
