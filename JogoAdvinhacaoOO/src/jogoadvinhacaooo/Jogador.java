/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoadvinhacaooo;

/**
 *
 * @author HomeNot
 */
public class Jogador {
   
    private String nomeJogador;
    private int numero;

    public Jogador(String nomeJogador) {
        
        this.nomeJogador = nomeJogador;
        Sortear();
    }
   
    public void Sortear()
    {
       int a = (int) (Math.random() * 10);
       this.numero = a;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public int getNumero() {
        return numero;
    }
    
    
    
    
    
    
    
}
