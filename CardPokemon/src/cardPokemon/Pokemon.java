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
    private int sVida = 1000;
    private int sAtaque;
    private String tipo;
    private int evolucao = 0;
    private int hPCombate;
    
    
    public int getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(int evolucao) {
        this.evolucao = evolucao;
    }


    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Pokemon(String nome, int sAtaque,int evolucao) {
        
        this.nome = nome;
        this.sAtaque = sAtaque;
        this.sVida = sAtaque*10;
        this.hPCombate = this.sVida;
        this.evolucao=evolucao;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return sVida;
    }

    public int gethPCombate() {
        return hPCombate;
    }

    public void sethPCombate(int hPCombate) {
        this.hPCombate = hPCombate;
    }

    public void setVida(int vida) {
        this.sVida = vida;
    }
    public void bonusLevel(int percentual)
    {
        this.tipo+=percentual;
        this.sAtaque+=percentual/2;
    }

    public int getsAtaque() {
        return sAtaque;
    }

    public void setsAtaque(int sAtaque) {
        this.sAtaque = sAtaque;
    }
    public void receberAtaque(int dano)
    {
        if(this.hPCombate - dano <0)
        {
            this.hPCombate = 0;
        }
        else    
        {
            this.hPCombate -= dano;
        } 
    }
    

    public void restaurarHp(){
        
        this.hPCombate = this.sVida;
        //this.sAtaque = this.sAtaque;
    }
    
    
    
}
