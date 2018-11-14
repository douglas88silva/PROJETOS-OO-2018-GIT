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
public class PkPlanta extends Pokemon implements Combate{

    private String tipo;
    private String nomeAtaque;

    public PkPlanta(String nome) {
        super(nome);
        this.tipo = "Planta";
        this.nomeAtaque = "Ataque de folhas";
    }

    @Override
    public void atacar(Pokemon adversario) {
        
        System.out.println(super.getNome()+ " usou "+this.nomeAtaque+ " no "+adversario.getNome());
     
        if(adversario.getVida()>0){
           adversario.receberAtaque(super.getsAtaque());
        }
    }
    
    
}
