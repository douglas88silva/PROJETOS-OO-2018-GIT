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
    private static int tempo;
    
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
        
        Pokemon pokemonPlayer = this.player.getPokemonPrincipal();
        Pokemon pokemonAdversario = this.adversario.getPokemonPrincipal();
        
        pokemonPlayer.duelar();
        pokemonAdversario.duelar();
        
        Random r = new Random();
        Duelo.resetarContador();
        
        System.out.println("####Duracao da partida: "+Duelo.tempo+" ####");
        while((Duelo.tempo=Duelo.tempo-3)>0 && pokemonPlayer.getVida()>0 && pokemonAdversario.getVida()>0){
            
           
            
            try {
                
                T.sleep(1000);

            if(r.nextInt(2)==1)//taxa de acerto
            {
                pokemonPlayer.atacar(pokemonAdversario);
                if(pokemonAdversario.getVida()==0)
                    break;
            }
            else{
               System.out.println("O "+pokemonPlayer.getNome()+" errou o golpe");
            }
            T.sleep(1000);
            if(r.nextInt(2)==1)//taxa de acerto
            {
                pokemonAdversario.atacar(pokemonPlayer);
                
                if(pokemonPlayer.getVida()==0)
                break;
            } 
            else{ 
                System.out.println("O "+pokemonAdversario.getNome()+" errou o golpe");
            }
            T.sleep(1000);    
            } catch (InterruptedException ex) {
                Logger.getLogger(Duelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("");
            System.out.println("####Duracao da partida: "+Duelo.tempo+" ####");
            System.out.println("||||  "+pokemonPlayer.getNome()+" HP:"+pokemonPlayer.getVida()+"\t"+ pokemonAdversario.getNome()+" HP:"+pokemonAdversario.getVida()+"  ||||");
        }
        
        if(tempo <=0)
        {
            System.out.println("Tempo limite da partida atingido!");
        }
        
        if(pokemonPlayer.getVida()>pokemonAdversario.getVida())
        {
            return 1;
        }
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
           Duelo.tempo = c;
           //System.out.println(c);
           }
        
         
    }
    
    public static void resetarContador()
    {
        Duelo.tempo = 30;
    }
    
}
