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
public class LevelUp {
    
    private int levelAtual = 1;
    private int experienciaAtual = 0;
    private int experienciaLevel=100;
    private int bonusAtributoLevel = 200;

    public int getBonusAtributoLevel() {
        return bonusAtributoLevel;
    }

    public void setBonusAtributoLevel(int bonusAtributoLevel) {
        this.bonusAtributoLevel = bonusAtributoLevel;
    }

    
    public int getLevelAtual() {
        return levelAtual;
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
    
    
    public void receberExperiencia(int experiencia){
        
        
        if(experiencia<0)
        {
            if(this.experienciaAtual+experiencia<0)
                this.experienciaAtual = 0;
            else
                this.experienciaAtual+=experiencia;
        }
        else 
        {
            this.experienciaAtual+=experiencia;
            
            while(this.experienciaAtual >= this.experienciaLevel)
            {
                if(this.experienciaAtual>=this.experienciaLevel)
                {
                    this.levelAtual++;
                    this.experienciaAtual = this.experienciaAtual-this.experienciaLevel;
                    this.experienciaLevel = this.experienciaLevel*this.levelAtual;
                }
            }
            
        }
        

        
        
    }
    
}
