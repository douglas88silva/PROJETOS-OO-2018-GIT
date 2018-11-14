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
public class PkFogo extends Pokemon implements Combate{

    private String tipo;
    private String nomeAtaque;

    public PkFogo(String nome) {
        super(nome);
        this.tipo = "Fogo";
        this.nomeAtaque = "Bola de Fogo";
    }

    @Override
    public void atacar(Pokemon adversario) {
        
        System.out.println(super.getNome()+ " usou "+this.nomeAtaque+ " no "+adversario.getNome());
     
        if(adversario.getVida()>0){
           adversario.receberAtaque(super.getsAtaque());
        }
    }
    
    
}
