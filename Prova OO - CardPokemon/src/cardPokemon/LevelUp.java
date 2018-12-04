/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

/**
 * Modelo utilizado para criar as regras de level.
 *

 *
 */
public class LevelUp {

    private int levelAtual = 1;
    private int experienciaAtual = 0;
    private int experienciaLevel = 100;
    private int bonusAtributoLevel = 10;

    /**
     * Metodo responsavel por adicionar experiencia. Sempre que a experiencia
     * atual supera a experiencia por level, o level é incrementado em uma
     * unidade, fazendo com que a experiencia por level seja dobrada.
     * @param  experiencia Experiencia recebida pela pokemon
     */
    public void receberExperiencia(int experiencia) {

        if (experiencia < 0) {
            if (this.experienciaAtual + experiencia < 0) {
                this.experienciaAtual = 0;
            } else {
                this.experienciaAtual += experiencia;
            }
        } else {
            this.experienciaAtual += experiencia;

            while (this.experienciaAtual >= this.experienciaLevel) {
                if (this.experienciaAtual >= this.experienciaLevel) {
                    this.levelAtual++;
                    this.experienciaAtual = this.experienciaAtual - this.experienciaLevel;
                    this.experienciaLevel = this.experienciaLevel * this.levelAtual;
                }
            }

        }

    }

    /**
     * Metodo responsavel por voltar o resetar o level
     */
    public void evolucao() {

        this.levelAtual = 1;
        this.experienciaAtual = 0;
        this.experienciaLevel = 100;
        this.bonusAtributoLevel = 200;

    }

    public int getLevelAtual() {
        return this.levelAtual;
    }

    public void setLevelAtual(int levelAtual) {
        this.levelAtual = levelAtual;
    }

    public int getExperienciaAtual() {
        return experienciaAtual;
    }

    public void setExperienciaAtual(int experienciaAtual) {
        this.experienciaAtual = experienciaAtual;
    }

    public int getExperienciaLevel() {
        return experienciaLevel;
    }

    public void setExperienciaLevel(int experienciaLevel) {
        this.experienciaLevel = experienciaLevel;
    }

    public int getBonusAtributoLevel() {
        return this.levelAtual * this.bonusAtributoLevel;
    }

    public void setBonusAtributoLevel(int bonusAtributoLevel) {
        this.bonusAtributoLevel = bonusAtributoLevel;
    }

}
