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
public class PkEletrico extends Pokemon{

    private String tipo;
    private String nomeAtaque;

    public PkEletrico(String nome) {
        super(nome);
        this.tipo = "Eletrico";
        this.nomeAtaque = "Ataque de raio ";
    }

    @Override
    public void atacar(Pokemon adversario) {
        
        System.out.println(super.getNome()+ " usou "+this.nomeAtaque+ " no "+adversario.getNome());
     
        if(adversario.getVida()>0){
           adversario.receberAtaque(super.getsAtaque());
        }
    }
    
    
}
