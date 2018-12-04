/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

/**
 * Modelo abstrato Pokemon. Este modelo foi criado para representar as
 * informações basicas de um pokemon para o Jogo.
 *

 *
 */
public abstract class Pokemon implements Combate {

    private String nome;
    private int sVida = 1000;
    private int sAtaque;
    public String tipo;
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
    
    public Pokemon()
    {
        
    }
    
    public Pokemon(String nome, int sAtaque, int evolucao) {

        this.nome = nome;
        this.sAtaque = sAtaque;
        this.sVida = sAtaque * 10;
        this.hPCombate = this.sVida;
        this.evolucao = evolucao;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nome=" + nome + '}';
    }

    public String getNome() {
        return this.nome;
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

    public void bonusLevel(int ataqueExtra) {
        this.sVida = this.sVida + ataqueExtra*10;
        this.sAtaque = this.sAtaque + ataqueExtra / 2;
    }

    public int getsAtaque() {
        return sAtaque;
    }

    public void setsAtaque(int sAtaque) {
        this.sAtaque = sAtaque;
    }

    public void receberAtaque(int dano) {
        if (this.hPCombate - dano < 0) {
            this.hPCombate = 0;
        } else {
            this.hPCombate -= dano;
        }
    }


    public String getNomeAtaque() {
        return null;
    }

    public void setNomeAtaque(String nomeAtaque) {

    }

    /**
     * Metodo responsavel por voltar a vida do pokemon para cheia apos a
     * batalha.
     */
    public void restaurarHp() {

        this.hPCombate = this.sVida;
        //this.sAtaque = this.sAtaque;
    }

}
