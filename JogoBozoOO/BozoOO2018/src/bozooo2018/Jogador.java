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

    public Jogador() {
        
        this.tabuleiro = new TabuleiroBozo();
    }
    
    public void marcarTabuleiro(int id,Dado d1[])
    {
    
    
    }
    
    public void jogarDados(Dado d1)
    {
        d1.rolarDados();
    }
    
    
  
    
}
