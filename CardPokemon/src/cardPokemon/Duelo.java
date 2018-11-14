/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import static cardPokemon.Main.T;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jessi
 */

public class Duelo {
    
    private Jogador player;
    private Jogador adversario;
    private static int tempo = 30;
    
    private int vencedor = -1;
    
    
    public Duelo(Jogador player, Jogador adversario) {
        
        this.player = player;
        this.adversario = adversario;
        //this.tempo = 30;
        this.vencedor = this.duelar();



    }

    public int getVencedor() {
        return vencedor;
    }

    public void setVencedor(int vencedor) {
        this.vencedor = vencedor;
    }
    
    
    
    
    public int duelar(){
        
        Pokemon pokemonPlayer = this.player.deckPokemon.get(0).getPk();
        Pokemon pokemonAdversario = this.adversario.deckPokemon.get(0).getPk();
        
        pokemonPlayer.duelar();
        pokemonAdversario.duelar();
        
        Random r = new Random();
        
        while((Duelo.tempo=Duelo.tempo-3)>0 && pokemonPlayer.getVida()>0 && pokemonAdversario.getVida()>0){
            
           System.out.println("Duracao da partida: "+Duelo.tempo);
            
            try {
                T.sleep(1000);

            if(r.nextInt(2)==1)//taxa de acerto
                this.player.deckPokemon.get(0).getPk().atacar(pokemonAdversario);
            else{
                
                System.out.println("O "+pokemonPlayer.getNome()+" errou o golpe");
            }
            T.sleep(1000);
            if(r.nextInt(2)==1)//taxa de acerto
                this.adversario.deckPokemon.get(0).getPk().atacar(pokemonPlayer); 
            else{ 
                System.out.println("O "+pokemonAdversario.getNome()+" errou o golpe");
            }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Duelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        if(tempo <=0)
        {
            System.out.println("Tempo limite da partida atingido!");
        }
        
        if(pokemonPlayer.getVida()>pokemonAdversario.getVida())
            return 1;
        else
            return 0;
    }
    
    public static void exibirtempo(){
        
           for (int c = 120; c >= 0; c--) {
               try {
                   T.sleep(1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Duelo.class.getName()).log(Level.SEVERE, null, ex);
               }
           tempo = c;
           //System.out.println(c);
           }
        
         
    }
    
}
