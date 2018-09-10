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
public class Jogadas {
    
    
    private int id;
    private String nome;
    private int pontuacao;

    public Jogadas(int id, String nome,int pontuacao) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    
    
    
    
}
