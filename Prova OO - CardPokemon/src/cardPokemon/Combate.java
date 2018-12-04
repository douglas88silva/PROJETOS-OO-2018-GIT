/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

/**
 * Interface criada para formar um contrato com os objetos que as implementam
 * Caso o objeto deseja implementar o combate ele presisa do metodo atacar
 *
 * @author Douglas
 */
interface Combate {

    public void atacar(Pokemon adversario);

}
