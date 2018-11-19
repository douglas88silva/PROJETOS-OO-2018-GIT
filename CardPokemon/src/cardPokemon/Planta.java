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
public class Planta extends Pokemon{

    private String tipo;
    private String nomeAtaque;


    
    public Planta(String nome,String tipo,int ataque,int evolucao) {
        super(nome,ataque,evolucao);
        this.tipo = tipo;
        this.nomeAtaque = "Ataque de folhas";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeAtaque() {
        return nomeAtaque;
    }

    public void setNomeAtaque(String nomeAtaque) {
        this.nomeAtaque = nomeAtaque;
    }

    @Override
    public void atacar(Pokemon adversario) {
        
        System.out.println(super.getNome()+ " usou "+this.nomeAtaque+ " no "+adversario.getNome());
     
        if(adversario.gethPCombate()>0){
           adversario.receberAtaque(super.getsAtaque());
        }
    }


    
    
}
