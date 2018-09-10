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
public class TabuleiroBozo {
    
    private ArrayList<Jogadas> tabuleiro = new ArrayList<Jogadas>();
    private int tabuleiroMarcado[];
    
    private int pontuacaoTotal;

    public TabuleiroBozo() {
        
        //CRIANDO AS REGRAS DE PONTUACAO DAS JOGADAS
        
//        AS – com a face 1 dos dados, poderá obter de 1 até 5 pontos;
          Jogadas AS = new Jogadas(1,"ÁS",1);
//        DUQUE – com a face 2 dos dados, poderá obter de 2 até 10 pontos;
          Jogadas DUQUE = new Jogadas(2,"DUQUE",2);
//        TERNO – com a face 3 dos dados, poderá obter de 3 até 15 pontos;
          Jogadas TERNO = new Jogadas(3,"TERNO",3);
//        QUADRA – com a face 4 dos dados, poderá obter de 4 até 20 pontos;
          Jogadas QUADRA = new Jogadas(4,"QUADRA",4);
//        QUINA – com a face 5 dos dados, poderá obter de 5 até 25 pontos;
          Jogadas QUINA = new Jogadas(5,"QUINA",5);
//        SENA – com a face 6 dos dados, poderá obter de 6 até 30 pontos;
          Jogadas SENA = new Jogadas(6,"SENA",6);
//        FU – com duas faces iguais, mais outras três faces iguais, obterá 20 pontos
          Jogadas FU = new Jogadas(7,"FU",20);
//        SEGUIDA – cinco faces em seqüência, obterá 30 pontos;
          Jogadas SEGUIDA = new Jogadas(8,"SEGUIDA",30);
//        QUADRADA – com quatro faces iguais, mais uma diferente, obterá 40 pontos;
          Jogadas QUADRADA = new Jogadas(9,"QUADRADA",40);
//        GENERAL – com as cinco faces iguais, obterá 50 pontos.
          Jogadas GENERAL = new Jogadas(10,"GENERAL",50);
        
        this.tabuleiro.add(AS);
        this.tabuleiro.add(DUQUE);
        this.tabuleiro.add(TERNO);
        this.tabuleiro.add(QUADRA);
        this.tabuleiro.add(QUINA);
        this.tabuleiro.add(SENA);
        this.tabuleiro.add(FU);
        this.tabuleiro.add(SEGUIDA);
        this.tabuleiro.add(QUADRADA);
        this.tabuleiro.add(GENERAL);
        
        this.tabuleiroMarcado = new int[this.tabuleiro.size()];
        
        for(int i=0;i<this.tabuleiro.size();i++)
            this.tabuleiroMarcado[i]=0;
        
        
    }
    public void marcarNoTabuleiro(int id,Dado d1[],int quantidade)
    {
        if(this.tabuleiroMarcado[id]!=0)
            this.tabuleiroMarcado[id]=1;
        
        
 
    }
    
    public int getPontuacaoJogada(int face,int quantidade)
    {
        return 0;
    }
    
}
