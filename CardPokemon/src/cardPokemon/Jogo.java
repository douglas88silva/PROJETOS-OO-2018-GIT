/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jessi
 */
public class Jogo {
    
    private List<CarD> cartasDisponiveis;
    private int totalCartas;
    private Jogador player;
    private List<Ginasio> ginasios;
    private boolean fecharJogo = false;
    Scanner ler = new Scanner(System.in);
    
    public Jogo() {
        
           
      cartasDisponiveis = new ArrayList();
      ginasios = new ArrayList();
      
      CarD pk1 = new CarD("Bubasauro","Planta");
      CarD pk2 = new CarD("Pikachu","Eletrico");
      CarD pk3 = new CarD("Squirtle","Agua");
      CarD pk4 = new CarD("Charmander","Fogo");
      
      CarD pk5 = new CarD("Ivsauro","Planta");
      CarD pk6 = new CarD("Raichu","Eletrico");
      CarD pk7 = new CarD("Blastoise","Agua");
      CarD pk8 = new CarD("Charmilion","Fogo");
      
 

      
      cartasDisponiveis.add(pk1); 
      cartasDisponiveis.add(pk2);
      cartasDisponiveis.add(pk3);
      cartasDisponiveis.add(pk4);
      
      cartasDisponiveis.add(pk5); 
      cartasDisponiveis.add(pk6);
      cartasDisponiveis.add(pk7);
      cartasDisponiveis.add(pk8);
      
      //CRIANDO OS GINASIOS
      for(int i=0;i<5;i++)
      {
          String ginasio_nome = "Ginasio_";
          ginasio_nome = ginasio_nome.concat(toString(i+1));
          Ginasio g = new Ginasio(ginasio_nome,(ArrayList<CarD>)cartasDisponiveis);
          ginasios.add(g);
      }
      
      this.totalCartas = cartasDisponiveis.size();
      
    }
    
    public void iniciaJogo()
    {
       System.out.println("Iniciando o Jogo");
       
       System.out.println("Digite o seu nome:");
       String nome = ler.next();
       player = new Jogador(nome);
       
        
        System.out.println("Escolha um pokemon inicial");
        this.exibirPokemonsDisponiveis();
        int id = ler.nextInt();
        player.deckPokemon.add(cartasDisponiveis.get(id-1));
        
        
        
        
        while(this.fecharJogo == false)
        {
            System.out.println("#####MENU PRINCIPAL#####");
//            System.out.println("( 1) - GINASIOS");
//            System.out.println("( 2) - POKEMONS");
            System.out.println("(-1)- SAIR");
            
            
            this.exibirGinasios();           
            ler.nextLine();
            System.out.println("Em qual ginasio voce deseja entrar");
            int idGinasio = ler.nextInt();
            
            if(idGinasio<= ginasios.size() && idGinasio>0)
            {
                this.entrarGinasio(ginasios.get(idGinasio-1));
            }
            
            else if(idGinasio == -1)
                 {
                  this.fecharJogo = true;
                 }
                 else
                 {
                    System.out.println("Ginasio invalido");
                    Main.pausarAplicacao();

                 }
    
        }
        
        
        
        
        
          
    }
    
    public void exibirPokemonsDisponiveis()
    {
        
        Iterator cartas= this.cartasDisponiveis.iterator();
        
        while(cartas.hasNext())
        {
            CarD c = (CarD) cartas.next();
            System.out.println(c.getIdCard()+" - "+ c.getPk().getNome());
            
        }
        
    }
    public void exibirGinasios()
    {
        Iterator gin= this.ginasios.iterator();
        
        while(gin.hasNext())
        {
            Ginasio c = (Ginasio) gin.next();
            System.out.println("Nivel " +c.getNivel()+" - "+ c.getNome());
            
        }
        
    }
    
    public void entrarGinasio(Ginasio g){
        
        
        //INICIAR A BATALHA
        System.out.println("Iniciando a batalha no Ginasio"+g.getNome());
        System.out.println("Estes são seu adversarios:");
        g.exibirAdversarios();
        Main.pausarAplicacao();
        
                
        for(int i = 0;i<g.adversarios.size();i++){
           
           System.out.println(" Iniciando o duelo "+this.player.getNome()+" X "+g.getAdversarios().get(i).getNome());
           Main.pausarAplicacao();
           Duelo combate = new Duelo(this.player,g.getAdversarios().get(i));
           
           if(combate.getVencedor() != -1)
           {
               if(combate.getVencedor()==1)
               {
                   System.out.println("Parabens você venceu a batalha!");
                   Main.pausarAplicacao();
                   
                   System.out.println("Deseja desafiar o proximo?(s/n)");
                  
                   String opcao = ler.next();
                   ler.nextLine();
                   while(!"s".equals(opcao) && !"n".equals(opcao))
                   {
                    System.out.println("Deseja desafiar o proximo?(s/n)");
                  
                    opcao = ler.next();
                    ler.nextLine();
                   }
                   
                   if(("s").equals(opcao))
                   {
                       combate.setVencedor(-1);
                   }
                   else
                   {
                       System.out.println("Parabens você venceu " + (i+1) +" adversarios!");
                       break;
                   }
    
               }
               else if(combate.getVencedor()==0)
               {
                   System.out.println("Que pena, voce foi derrotado adversario "+ this.player.getNome());
                   Main.pausarAplicacao();
                   break;
               }
               
           }
           
            if(combate.getVencedor()==1 && i == g.adversarios.size()-1 )
            System.out.println("Parabens você venceu todos os adversarios!");
            Main.pausarAplicacao();
        }

        
        
    }

    private String toString(int i) {
        
        return "0"+i;
    }
    
    
}
