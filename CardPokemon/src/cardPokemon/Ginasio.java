/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jessi
 */
public class Ginasio {
    
    private static int id = 0;
    private String nome;
    private int nivel;
    List<Jogador> adversarios;

    public Ginasio(String nome, List<CarD> e) {
      
        id++;
        this.nivel = id;
        this.nome=nome;
        adversarios = new ArrayList();
               
        Random r = new Random();
        
        for(int i = id;i>0;i--)
        {
            String adversario="Adversario_";
            adversario = adversario.concat(toString(i+1));
         
            Jogador ad = new Jogador(adversario);       
            ad.deckPokemon.add((CarD) e.get(r.nextInt(e.size())));//pegar aleatoriamente
            this.adversarios.add(ad);
 
        }
        //System.out.println("Foram adicionados "+this.adversarios.size()+" adversarios no ginasio "+this.nome );
        
      
    }
    public void exibirAdversarios(){
        
        Iterator adv = this.adversarios.iterator();
        
        while(adv.hasNext())
        {
            Jogador c = (Jogador) adv.next();
            System.out.println(c.getNome());
        }
        
    }

    public String getNome() {
        return nome;
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
    
    
    
    
}
