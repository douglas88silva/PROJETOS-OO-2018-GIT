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
public class Jogador {
    
    private String nome;
    TabuleiroBozo tabuleiro;
    private int Pontuacao;

    
    public Jogador() {
        
        this.tabuleiro = new TabuleiroBozo();
        this.Pontuacao = 0;
    }
    public Jogador(String nome) {
        this.nome=nome;
        this.tabuleiro = new TabuleiroBozo();
        this.Pontuacao=0;
    }
    
    public void marcarTabuleiro(int id,Dado []d1)
    {
        int id2 =id-1;
        tabuleiro.marcarNoTabuleiro(id2, d1);
    
    }
    
    public void jogarDados(Dado d1)
    {
        d1.rolarDados();
    }

    public String getNome() {
        return nome;
    }
    
    public void ImprimePontuacao()
    {   
        System.out.println("A pontuação total do jogador "+ this.nome +": "+this.tabuleiro.getPontuacaoJogada()); 
         
    }

    public int getPontuacao() {
        
        this.Pontuacao = this.tabuleiro.getPontuacaoJogada();
        
        return this.Pontuacao;
    }
    

    
    
    
  
    
}
