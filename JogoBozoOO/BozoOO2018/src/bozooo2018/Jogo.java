/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bozooo2018;

import java.util.ArrayList;

/**
 *
 * @author HomeNot
 */
public class Jogo {
    
    private ArrayList <Jogador> jogadores= new ArrayList <Jogador>();
    private ArrayList <TabuleiroBozo> tabuleiros= new ArrayList <TabuleiroBozo>();
    private Dado d1[] = new Dado[5];
    private int maxRodada = 2;

    public Jogo() {
        
        //INICIALIZANDO O VETOR DE DADOS
        for(int i=0;i<5;i++)
            this.d1[i] = new Dado();
        
    }
    
    
    public void addJogador(Jogador x)
    {
        this.jogadores.add(x);
        TabuleiroBozo tab = new TabuleiroBozo();
        this.tabuleiros.add(tab);
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
            for(int i=0;i<this.maxRodada;i++)
            {
                //2º RODADAS PARA OS JOGADORES
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
                          }                            
                      }    
                     //APOS CADA JOGADA DO JOGADOR VERIFICA SE ELE NÃO VENCEU FAZENDO UM GENERAL;                   
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

    
}
