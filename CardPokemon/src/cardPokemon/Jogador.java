/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jessi
 */
public class Jogador {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    private String nome;
    private int tamDeck = 0;
    List<CarD> deckPokemon;
    

    public Jogador(String nome) {
        this.deckPokemon = new ArrayList();
        this.nome = nome;
        
    }


    
    
}
