/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedexjavaoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HomeNot
 */
public class PokedeX {
    
    private List <Pokemon> agendaPokemon;
    
    
    public PokedeX(){
        
        this.agendaPokemon = new ArrayList();
    }
    
    public void addPokemonPokedex(Pokemon pk)
    {
        this.agendaPokemon.add(pk);
    }
    
    
    public Pokemon getAgendaPokemon(String nome) {
       int i = this.agendaPokemon.size();
       while(i>0)
       {
           if(this.agendaPokemon.get(i).getNome() == nome)
           {
               return this.agendaPokemon.get(i);
           }
       
       }

        return null;
    }
    
    public Pokemon getAgendaPokemon(int id) {
       int i = this.agendaPokemon.size();
       while(i>0)
       {
           if(this.agendaPokemon.get(i).getId()== id)
           {
               return this.agendaPokemon.get(i);
           }
       }

        return null;
    }
   
    
}
