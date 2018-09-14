/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bozooo2018;

import java.util.ArrayList;
import java.util.Scanner;

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
        
        
        Scanner ler = new Scanner(System.in);
        Jogo Bozo = new Jogo();
        
        
        System.out.println("Iniciando o jogo Bozo");
        
        System.out.println("Favor escolha a quantidade de Jogadores");
        int quantidadeJogadores = ler.nextInt();
        
        Jogador x1[]; 
        
        if(quantidadeJogadores<2)
        {
            
        }
        else
        {
            //alocando os jogadores
            x1 = new Jogador[quantidadeJogadores];
            
            
            for(int i=0;i<quantidadeJogadores;i++)
            {   
                Bozo.limparTela();
                System.out.println("Carregando os jogadores:");
                String nome;
                System.out.println("Digite o nome do jogador "+(i+1));
                nome = ler.next();
                
                x1[i] = new Jogador(nome);

                Bozo.addJogador(x1[i]);
                
                Bozo.pausarAplicacao();
                
            }
        }
                
//        Jogador x1 = new Jogador("Jogador 1");
//        Jogador x2 = new Jogador("Jogador 2");
        

        Bozo.iniciaJogo();
        //Bozo.mostrarDados();
        
        
       
    }
    
}
