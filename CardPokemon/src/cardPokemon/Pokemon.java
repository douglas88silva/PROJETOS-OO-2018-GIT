/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

/**
 *
 * @author jessi
 */
public abstract class Pokemon implements Combate{
    
    private String nome;
    private int vida;
    private int sAtaque;

    public Pokemon(String nome) {
        
        this.nome = nome;
        this.vida = 100;
        this.sAtaque = 10;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getsAtaque() {
        return sAtaque;
    }

    public void setsAtaque(int sAtaque) {
        this.sAtaque = sAtaque;
    }
    public void receberAtaque(int dano)
    {
        this.vida -= dano; 
    }
    
    @Override
    public void atacar(Pokemon adversario) {

    }
    
    public void duelar(){
        
        this.vida = 40;
        this.sAtaque = 10;
    }
    
    
    
}
