/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author jessi
 */
public class Ginasio {
    
    private static int id = 0;
    private String nome;
    private int nivel;
    private List<Jogador> adversarios;

    public Ginasio(String nome, List<CarD> cartasDisponiveis) {
      
        id++;
        this.nivel = id;
        this.nome=nome;
        adversarios = new ArrayList();
               
        Random r = new Random();
        int j = 0;
        for(int i = id;i>0;i--)
        {
            String adversario="NPC_";
            adversario = adversario.concat(toString(j+1));
         
            Jogador ad = new Jogador(adversario);       
            ad.addDeckPokemon((CarD) cartasDisponiveis.get(r.nextInt(cartasDisponiveis.size())).createNewCardPokemon(this.nivel));//pegar aleatoriamente
            this.adversarios.add(ad);
            j++;
        }
        //System.out.println("Foram adicionados "+this.adversarios.size()+" adversarios no ginasio "+this.nome );
        
      
    }

    @Override
    public String toString() {
        return "Ginasio{" + "nome=" + nome + '}';
    }



    public void exibirAdversarios(){
        
        Iterator adv = this.adversarios.iterator();
        System.out.println("---ADVERSARIO     ||    POKEMONS---");
        while(adv.hasNext())
        {
            Jogador c = (Jogador) adv.next();
            System.out.println(c.getNome() +"  -  "+ c.getPokemonPrincipal().getNome());
        }
        
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Jogador> getAdversarios() {
        return adversarios;
    }

    public void setAdversarios(List<Jogador> adversarios) {
        this.adversarios = adversarios;
    }

    private String toString(int i) {

        return "0"+i;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ginasio other = (Ginasio) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
   
}
