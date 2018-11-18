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
    private int vida = 1000;
    private int sAtaque;
    private String tipo;
    private int evolucao = 0;
    
    
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
        this.vida = sAtaque*10;
        this.evolucao=evolucao;
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
    public void bonusLevel(int percentual)
    {
//        this.vida = this.vida + (int)(this.vida * (int)(percentual/100));
//        this.sAtaque = this.sAtaque + (int)(this.sAtaque * (int)(percentual/100));
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
        this.vida -= dano; 
    }
    

    
//    @Override
//    public void addExperiencia(int experiencia) {
//
//        super.receberExperiencia(experiencia);
//        
//        if(evolucao>0 && super.getLevelAtual()==2)
//        {
//            
//        }
//
//    }
//    
    public void duelar(){
        
        this.vida = this.vida;
        this.sAtaque = this.sAtaque;
    }
    
    
    
}
