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
public class Fogo extends Pokemon implements Combate{

    private String nomeAtaque;


    public Fogo(String nome,String tipo,int ataque, int evolucao) {
        super(nome,ataque,evolucao);
        super.setTipo(tipo);
        this.nomeAtaque = "Bola de Fogo";
    }
    
    public String getNomeAtaque() {
        return nomeAtaque;
    }

    public void setNomeAtaque(String nomeAtaque) {
        this.nomeAtaque = nomeAtaque;
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }
    
    @Override
    public void atacar(Pokemon adversario) {
        
        System.out.println(super.getNome()+ " usou "+this.nomeAtaque+ " no "+adversario.getNome());
     
        if(adversario.gethPCombate()>0){
           adversario.receberAtaque(super.getsAtaque());
        }
    }
    
    
}
