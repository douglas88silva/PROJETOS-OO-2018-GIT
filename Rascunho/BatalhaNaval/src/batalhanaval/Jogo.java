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
public class Jogo {
    
    
    Tabuleiro tabuleiros[];
    Jogador jogadores[];
    Barco barco[];
    int quantidadeDeJogadores;
    int acertou;

    public Jogo(int quantidadeDeJogadores) {
        
        this.quantidadeDeJogadores = quantidadeDeJogadores;
        //this.jogadores = new Jogador[this.quantidadeDeJogadores];
        this.tabuleiros = new Tabuleiro[quantidadeDeJogadores];
        this.barco = new Barco[quantidadeDeJogadores];
        
        //INSTANCIANDO OS TABULEIROS E OS BARCOS E INSERINDO UM BARCO EM CADA TABULEIRO
        for(int i =0;i<quantidadeDeJogadores;i++)
        {
            this.tabuleiros[i] = new Tabuleiro(10);
            this.barco[i] = new Barco(10);
            this.tabuleiros[i].InsereBarco(this.barco[i]);
        }

    }
    
    public void iniciaJogo(Jogador[] x)
    {
        this.jogadores = x;
        int fim = 1;
        int rodada = 0;
        int palpite;
        Scanner ler = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("");
        //CONDICAO DE FIM DO JOGO
        while(fim != 0)
        {    
            //RODADAS DOS JOGADORES
            rodada++;
            System.out.println("Rodada "+rodada+" !");
           for(int i = 0;i<this.quantidadeDeJogadores;i++)
            {   

                         
                //PALPITES DOS JOGADORES
                System.out.println("Jogador(a) "+this.jogadores[i].NomeJogador + " e a sua vez!");
                System.out.println("Em qual posicao voce quer atirar");
                
                //MOSTRANDO O TABULEIRO
                this.tabuleiros[i].mostrarTabuleiro();
                palpite = ler.nextInt();
                
                //ATIRANDO NO BARCO
                this.tabuleiros[i].atirarNoBarco(palpite);
                
                
                //MOSTRANDO O TABULEIRO APOS A JOGADA
                this.tabuleiros[i].mostrarTabuleiro();           
                //ler.next();
                
                fim = verificaFimDoJogo( this.tabuleiros[i],palpite);  
                if(fim == 0)
                {
                    System.out.println("O jogador "+this.jogadores[i].NomeJogador +" venceu afundando o barco "+this.barco[i].nome);
                    this.tabuleiros[i].mostrarTabuleiro();   
                }
                

                System.out.println("");
                System.out.println("");
                ler.nextLine();
            }
        }            
        
    }

    private int verificaFimDoJogo(Tabuleiro tab, int palpite)
    {   
        //CASO TENHA ACERTADO TODOS OS TIROS NO BARCO FINALIZA O JOGO
        
        if(tab.tabuleiroOculto[palpite]!= null)
        {   
            if(tab.tabuleiroOculto[palpite].acertouTiro >= tab.tabuleiroOculto[palpite].tamanhoBarco)
            return 0;
        }
        
        return 1;
    }
    

    
    
    
    

    
    
    
    
}
