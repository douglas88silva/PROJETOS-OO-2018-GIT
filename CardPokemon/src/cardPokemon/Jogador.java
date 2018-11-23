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

    private String nome;
    private int tamDeck = 0;
    private CarD pokemonPrincipal;
    private List<CarD> deckPokemon;

    public Jogador(String nome) {
        this.deckPokemon = new ArrayList();
        this.nome = nome;   
    }
    
    public void addDeckPokemon(CarD pk) {
  
        this.deckPokemon.add(pk);

         if(this.deckPokemon.size()==1)
         {
           this.pokemonPrincipal = this.deckPokemon.get(0);
         }
    }
    
    public List<CarD> getDeckPokemon() {
        return this.deckPokemon;
    }

    public Pokemon getPokemonPrincipal() {
        return this.pokemonPrincipal.getPk();
    }
    
    public CarD getCardPrincipal() {
        return this.pokemonPrincipal;
    }

    public void setDeckPokemon(List<CarD> deckPokemon) {
        this.deckPokemon = deckPokemon;
    }
    
    
    public String getNome() {
        return this.nome;
    }

    public CarD getDeckPokemon(int id) {
        return this.deckPokemon.get(id);
    }
    
    public int getSizeDeckPokemon()
    {
        return this.deckPokemon.size();
    }
    


    public void setPokemonPrincipal(int id) {
        
        if(id >= 0 && id < this.deckPokemon.size())
        {
            this.pokemonPrincipal = this.deckPokemon.get(id);
            System.out.println("Seu novo pokemon principal e "+this.getPokemonPrincipal().getNome());
            Main.pausarAplicacao();
        }
        
        else
        {
            System.out.println("Nao foi possivel encontrar o pokemon de id= "+id);
        }
        
    }
   
    

    public void setNome(String nome) {
        this.nome = nome;
    }
     



    
    
}
