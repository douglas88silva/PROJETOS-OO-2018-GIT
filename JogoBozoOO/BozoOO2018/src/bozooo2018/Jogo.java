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
public class Jogo {
    
    private ArrayList <Jogador> jogadores= new ArrayList <Jogador>();
    private Dado d1[] = new Dado[5];
    private Jogador Vencedor;
    private int maxRodada = 2;
    private int finalizaJogo = 0;

    public Jogo() {
        
        //INICIALIZANDO O VETOR DE DADOS
        for(int i=0;i<5;i++)
            this.d1[i] = new Dado();
        
    }

    public void addJogador(Jogador x)
    {
        this.jogadores.add(x);   
    }
    
    public void iniciaJogo()
    {
        if(this.jogadores.size()<2)
        {
            System.out.println("Não é possivel iniciar o jogo com menos de 2 jogadores");
            
        }
        else
        {
           // 1º TOTAL DE RODADAS PARA O JOGO
            Scanner ler = new Scanner(System.in);
            
            for(int i=0;i<this.maxRodada;i++)
            {
                //2º RODADAS PARA OS JOGADORESs
                for(Jogador j :jogadores)
                {
                     //CADA JOGADOR TEM DIREITO A TRÊS JOGADAS
                      for(int k=0;k<3;k++)
                      {
                          //rolar 5 dados;
                          if(k == 0)
                          {
                              this.d1[0].rolarDados();
                              this.d1[1].rolarDados();
                              this.d1[2].rolarDados();
                              this.d1[3].rolarDados();
                              this.d1[4].rolarDados();
                          }
                          else
                          {
                              //ESCOLHER OS DADOS QUE SERAO ARREMESSADOS NOVAMENTE
                              mostrarDados();
                              int opcao;
                              System.out.println("Quantos dados você deseja jogar outra vez");
                              opcao =  ler.nextInt();
                              
                              for(int l=0;l<opcao;l++)
                              {   
                                  //mostrarDados();
                                  int escolha;
                                  System.out.println("Escolha o dado:");
                                  escolha = ler.nextInt();
                                  
                                  if(escolha<5 && escolha>1)
                                     j.jogarDados(this.d1[escolha-1]);
                                                                    
                                  else
                                  {   
                                      System.out.println("Opção invalida, digite outra vez");
                                      l--;
                                  }
                              }
                              
                              //MARCAR NO TABULEIRO A POSICAO CORRESPONDENTE DA JOGADA
                              mostrarDados();
                              int marcarTabuleiro;
                              System.out.println("Qual posicao do tabuleiro voce deseja marcar");
                              marcarTabuleiro = ler.nextInt();
                              j.marcarTabuleiro(marcarTabuleiro, this.d1);
                          }  
                      }    
                     //APOS CADA JOGADA DO JOGADOR VERIFICA SE ELE NÃO VENCEU FAZENDO UM GENERAL;
                     this.finalizaJogo=verificaVencedor(this.jogadores);
                }
            }       
        }
    }
    
    public void mostrarDados()
    {
        for(int j=0;j<5;j++)
         System.out.print((j+1)+" ");
        
        System.out.print(" - DADOS");
        System.out.println("");
        
        for(int i=0;i<5;i++)
         System.out.print(this.d1[i].getDado()+" ");
        
        System.out.print(" - RESULTADO");
        System.out.println("");

    }
    
    public int verificaVencedor(ArrayList jogadores)
    {
        //DETERMINA A PONTUACAO DE TODOS E RETORNA A POSICAO DO VENCEDOR NO VETOR
        this.finalizaJogo = 1;
        
        return 1;
    }

    
}
