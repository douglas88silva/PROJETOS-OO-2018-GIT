/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

import java.util.Scanner;

/**
 *
 * @author HomeNot
 */
public class ProgramaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Jogador x1 = new Jogador("Douglas");
        //JOGO DE BATALHA NAVAL APRIMORADO
        //DOIS JOGADORES JOGANDO EM DOIS TABULEIROS DIFERENTES COM MAIS DE UM BARCO EM CADA
        //VENCE O QUE AFUNDAR O BARCO PRIMEIRO
        //QUANDO O JOGADOR VENCER PRINT O NOME DO BARCO AFUNDADO E O VENCEDOr
        /*
        Tabuleiro t1 = new Tabuleiro(10);
        Barco b1 = new Barco(10);
        
        t1.InsereBarco(b1);
        
        t1.mostrarTabuleiro();
        */
        
        
        //INICIANDO O JOGO
        
        int quantidadeJogadores;
        //int palpite;
        String nomeJogador;
        Jogador jogadores[];
        Jogo batalhaNaval;
        
        System.out.println("Iniciando o Jogo");
        
        Scanner ler = new Scanner(System.in);
       
        System.out.println("Digite a quantidade de jogadores");
        quantidadeJogadores =  ler.nextInt();
        ler.nextLine();
        
        
        //CRIANDO O VETOR DE JOGADORES
        jogadores = new Jogador[quantidadeJogadores];
        
        //LENDO O NOME DOS JOGADORES E INSTANCIANDO OS JOGADORES
        for(int i = 0;i<quantidadeJogadores;i++)
        {
            System.out.println("Digite o nome do jogador");
            nomeJogador = ler.next();
            jogadores[i]= new Jogador(nomeJogador);
            ler.nextLine();
        }
        
        //CRIANDO O JOGO COM X JOGADORES
        
        batalhaNaval = new Jogo(quantidadeJogadores);
        batalhaNaval.iniciaJogo(jogadores);
        
        
        
        
    }
    
}
