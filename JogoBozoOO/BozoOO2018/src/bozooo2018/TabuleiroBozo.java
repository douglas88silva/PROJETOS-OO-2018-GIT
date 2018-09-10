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
            this.tabuleiroMarcado[i]=-1;
        
        
    }

    public int VericaTabuleiroMarcado(int id) {
        
        if (tabuleiroMarcado[id]==-1)
            return 0;
            
        else    
        return 1;
    }
    public void marcarNoTabuleiro(int id,Dado d1[])
    {
         //CALCULANDO A PONTUACAO DA JOGADA
        int dadosIguais=0;
        
        if(this.tabuleiroMarcado[id]==-1)
        {   
            //A POSICAO VEZES A QUANTIDADE DE DADOS DA POSICAO
            if(id<7)
            {   
                //VALIDANDO AS JOGADAS
                for(int i=0;i<d1.length;i++)
                    if(d1[i].getDado()==id)
                        dadosIguais++;
                
                this.tabuleiroMarcado[id]=dadosIguais*id;
            }
            else
            {
                //5 faces seguidas
                if(id == 8)
                {
                    int soma=0;
                    
                    for(int i=0;i<d1.length;i++)
                    {
                        soma+=d1[i].getDado();
                    }
                    if(soma==15 || soma==20)
                    {
                        if((d1[0].getDado()==1 && d1[5].getDado()==5) || (d1[0].getDado()==2 && d1[5].getDado()==6))
                        {
                            this.tabuleiroMarcado[id]= 30;
                        }
                    
                    }
                    else
                    {
                        this.tabuleiroMarcado[id]=0;
                    }
                }
                //4 face iguais e uma diferente
                if(id==9)
                {
                    //COLOCANDO OS DADOS DIFERENTES EM A E B;
                    
                    int a,b,valida=0;
                    int totalA = 0,totalB=0;
                    
                    a = d1[0].getDado();
                    //ENCONTRANDO O DADO DIFERENTE
                    for(int i = 0;i<d1.length;i++)
                    {
                        if(d1[i].getDado()!=a)
                        { 
                            b=d1[i].getDado();
                            valida++;
                        }
                    }
                    
                    if(valida==1)
                    {
                        //QUER DIZER QUE TEM APENAS DOIS DADOS DIFERENTES
                        //PRECISA TESTAR SE SAO 4 A OU 4 B
                        
                        for(int j = 0;j<d1.length;j++)
                        {
                            if(d1[j].getDado()==a)
                                totalA++;
                            else
                             totalB++;
                        }
                        
                        if(totalA == 4 || totalB==4)
                        {
                            this.tabuleiroMarcado[id]=40;
                        }
                        else
                        {
                            this.tabuleiroMarcado[id]=0;
                        }
                        
                    }
                    else
                    {
                        this.tabuleiroMarcado[id]=0;
                    }
                            
                
                }
                //5 faces iguais 
                if(id == 10)
                {
                    int a=d1[0].getDado();
                    
                    for(int i=0;i<d1.length;i++)
                    {   
                        if(a==d1[i].getDado())
                        dadosIguais++;
                    }
                    
                    if(dadosIguais==5)
                    {
                        this.tabuleiroMarcado[id]=50;
                    }
                    else
                    {
                        this.tabuleiroMarcado[id]=0;
                    }
                }
                
                else
                {
                  this.tabuleiroMarcado[id]=0;
                }
            }
        }
        
        else
        {
            System.out.println("Posicao do tabuleiro já marcada, Favor escolher outra");
            
        }

    }
    
    
    
    public void mostrar_Tabuleiro()
    {
        //MOSTRAR UMA COLUNA COM O NOME DA JOGADA E OUTRA COM SE ESTA MARCADA OU NÃO
        System.out.println();
        System.out.println("[X]Jogadas");
        for(int i=0;i<tabuleiro.size();i++)
        {   
            System.out.println("["+tabuleiroMarcado[i]+"]"+tabuleiro.get(i).getNome());         
        }
        System.out.println();
    }
    
    public int getPontuacaoJogada(int face,int quantidade)
    {
        return 0;
    }


    
    
}
