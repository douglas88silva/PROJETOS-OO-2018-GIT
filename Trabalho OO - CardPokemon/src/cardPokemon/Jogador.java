/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import static views.TelaPrincipal.batalhaPokemon;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 * Modelo de Jogador. Cada jogaador tem um nome uma lista com todos os seus
 * pokemons e um pokemon que é utilizado na batalha. obs.: O pokemon principal
 * não é um objeto é apenas um ponteiro para um pokemon da lista.
 *
 * @see CarD
 * @autor Douglas
 *
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

        if (this.deckPokemon.size() == 1) {
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

        CarD aux = null;

        for (CarD carD : deckPokemon) {

            if (carD.getIdCard() == id) {
                aux = carD;
                break;
            }
        }

        return aux;
    }

    /**
     * Metodo responsavel retornar a posicao de um pokemon na lista com base em
     * seu N#(id inicial)
     */
    public int getIndexOfDeck(int id) {

        int indexOfCardID = -1;

        for (CarD carta : this.deckPokemon) {

            if (carta.getIdCard() == id) {
                indexOfCardID = this.deckPokemon.indexOf(carta);
            }

        }

        return indexOfCardID;

    }

    public int getSizeDeckPokemon() {
        return this.deckPokemon.size();
    }

    /**
     * Metodo responsavel por alterar o pokemon principal do jogador com base em
     * seu N#(id inicial)
     */
    public void setPokemonPrincipal(int idCard) {

        int indexOf = this.getIndexOfDeck(idCard);
        boolean local = this.pokemonPrincipal.equals(this.deckPokemon.get(indexOf));

        if ((indexOf >= 0 && indexOf < this.deckPokemon.size())) {

            this.pokemonPrincipal = this.deckPokemon.get(indexOf);
            System.out.println("Seu novo pokemon principal e " + this.getPokemonPrincipal().getNome());
            if (!local) {
                JOptionPane.showMessageDialog(null, "Seu novo pokemon principal e " + this.getPokemonPrincipal().getNome());
            }

            //Main.pausarAplicacao();
        } else {
            System.out.println("Nao foi possivel encontrar o pokemon de id= " + idCard);
            JOptionPane.showMessageDialog(null, ("Nao foi possivel encontrar o pokemon de id= " + idCard));
        }

    }

    /**
     * Metodo responsavel verificar se um determinado pokemon esta na lista com
     * base em seu N#(id inicial)
     */
    public boolean existsOfIdCarD(int idCard) {
        boolean a = false;

        for (CarD carD : deckPokemon) {

            if (carD.getIdCard() == idCard) {
                a = true;
            }

        }

        return a;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Jogador other = (Jogador) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.pokemonPrincipal, other.pokemonPrincipal)) {
            return false;
        }
        return true;
    }

}
