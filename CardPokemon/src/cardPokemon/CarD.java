/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import java.util.ArrayList;

/**
 *
 * @author jessi
 */
public class CarD extends LevelUp {
    
    private static int id = 0;
    private int level = 1;
    private int idCard;
    private int sPCard;
    private Pokemon pk;
    
    public int getIdCard() {
        return idCard;
    }
    
    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getsPCard() {
        return sPCard;
    }

    public void setsPCard(int sPCard) {
        this.sPCard = sPCard;
    }

    public Pokemon getPk() {
        return pk;
    }

    public void setPk(Pokemon pk) {
        this.pk = pk;
    }

    
    public CarD(int idCard,String nome,String tipo,int ataque,int evolucao) {
        
        
        if("Planta".equals(tipo))
            pk = new Planta(nome,tipo,ataque,evolucao);
        
        else if("Agua".equals(tipo))
                pk = new Agua(nome,tipo,ataque,evolucao);
        
             else if("Fogo".equals(tipo))
                pk = new Fogo(nome,tipo,ataque,evolucao);
        
                  else if("Eletrico".equals(tipo))
                    pk = new Eletrico(nome,tipo,ataque,evolucao);
        
                       else
                         pk = new Normal(nome,tipo,ataque,evolucao);
        

        id++;
        this.idCard = idCard;
        
    }
    
    public void addExperiencia(int experiencia , ArrayList<CarD> cartasDiponiveis)
    {
        
        int level_inicial = super.getLevelAtual();
        
        super.receberExperiencia(experiencia);
        
        this.level = super.getLevelAtual();
        
        if(level_inicial < this.level)
        {
            if(this.level%5==0)//pokemon pode evoluir
            {
                int totalEvolucao = this.level - level_inicial;
            
            
                while(totalEvolucao > 0)
                {
                    if(this.pk.getEvolucao()>0)
                    {
                        //fazendo a troca do pokemon para sua evolucao
                        System.out.println("\n\nOps... Parece que o "+this.pk.getNome()+" vai evoluir!");
                        Main.pausarAplicacao();
                        

                        this.pk = cartasDiponiveis.get(this.idCard++).getPk();
                        super.evolucao();
                        
                        System.out.println("Parabens! seu pokemon evoluiu para "+this.pk.getNome());
                        Main.pausarAplicacao();
                    }
                    totalEvolucao--;
                }
            }
            else
            {
                System.out.println("ops... Seu pokemon acaba de subir para o level "+this.level);
                this.pk.bonusLevel(super.getBonusAtributoLevel());
                Main.pausarAplicacao();
            }
            
        }
        
        
    }
    
    public CarD createNewCardPokemon(){
        
                   int idPk = this.idCard;
                   String nomePk = this.pk.getNome();
                   String tipoPK = this.pk.getTipo();
                   int ataquePK = this.pk.getsAtaque();
                   int evolucaoPK = this.pk.getEvolucao();
                        
                   CarD aux = new CarD(idCard, nomePk, tipoPK, ataquePK, evolucaoPK);
                   
                   return aux;
        
        
    }
    public CarD createNewCardPokemon(int nivel){
                    
                   int idPk = this.idCard;
                   String nomePk = this.pk.getNome();
                   String tipoPK = this.pk.getTipo();
                   int ataquePK = this.pk.getsAtaque();
                   int evolucaoPK = this.pk.getEvolucao();
                   
                   CarD aux;
                   
                   if(nivel == 1)
                   {
                       aux = new CarD(idCard, nomePk, tipoPK, (int)(ataquePK/4), evolucaoPK);
                   }
                   else if(nivel == 2)
                        {
                            aux = new CarD(idCard, nomePk, tipoPK, (int)(ataquePK/2), evolucaoPK);
                        }
                        else
                            aux = new CarD(idCard, nomePk, tipoPK, ataquePK, evolucaoPK);
                   
                   return aux;
        
        
    }


    
    
    
}
