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
    private int expericenciaPorVitoria = 110;
    Scanner ler = new Scanner(System.in);
   
    public Jogo() {
        //cartasDisponiveis = new ArrayList();
        ginasios = new ArrayList();
        //System.out.println("Carregando cartas pokemons!");
        CarregaDadosTXT loadCartas = new CarregaDadosTXT();
        cartasDisponiveis = loadCartas.carregarPokemons();
      //CRIANDO OS GINASIOS
      for(int i=0;i<5;i++)
      {
          String ginasio_nome = "GINASIO_";
          ginasio_nome = ginasio_nome.concat(toString(i+1));
          Ginasio g = new Ginasio(ginasio_nome,(ArrayList<CarD>)cartasDisponiveis);
          ginasios.add(g);
      }
      this.totalCartas = cartasDisponiveis.size();
    }
    
    public void iniciaJogo()
    {
        System.out.println("#### LOADING BATALHA CARTAS POKEMON ####");
        this.carregarJogador();
        while(this.fecharJogo == false)
        {
            System.out.println("\n#### BATALHA DE CARTAS POKEMON####");
            System.out.println("#####MENU PRINCIPAL#####");
            System.out.println("( 1) - GINASIOS");
            System.out.println("( 2) - MEUS POKEMONS");
            System.out.println("( 3) - CARTAS DISPONIVEIS");
            System.out.println("(-1) - SAIR");
            int opcao = ler.nextInt();
            if(opcao == 1)
                this.menuGinasio();
            if(opcao == 2)
                this.exibirMeusPokemons();
            if(opcao == 3)
                this.exibirPokemonsDisponiveis();
            if(opcao == -1)
                this.fecharJogo = true;
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
        Main.pausarAplicacao();
    }
    public void exibirGinasios()
    {
        System.out.println("#### GINASIOS ABERTOS ####");
        Iterator gin= this.ginasios.iterator();
        int i = 1;
        while(gin.hasNext())
        {
            Ginasio c = (Ginasio) gin.next();
            System.out.println("("+i+")"+" - "+ c.getNome());
            i++;
        }
    }
    
    public void entrarGinasio(Ginasio g){
        //INICIAR A BATALHA
        System.out.println("\ns#### ENTRANDO NO GINASIO " +g.getNome()+" ####");
        
        g.exibirAdversarios();
        Main.pausarAplicacao();
       
        for(int i = 0;i<g.adversarios.size();i++){
           System.out.println("###################################### DUELO ##########################################");
           System.out.println(
                   "["+this.player.getNome()+" - "+this.player.getPokemonPrincipal().getNome()+"] "
                   +"X"
                   + " ["+g.getAdversarios().get(i).getNome()+" - "+g.getAdversarios().get(i).getPokemonPrincipal().getNome()+"]");
           
           System.out.println("############");

           Main.pausarAplicacao();
           Duelo combate = new Duelo(this.player,g.getAdversarios().get(i));
           if(combate.getVencedor() != -1)
           {
               if(combate.getVencedor()==1)
               {
                   System.out.println("Parabens você venceu a batalha!");
                   this.player.getCardPrincipal().addExperiencia(this.expericenciaPorVitoria, (ArrayList<CarD>)this.cartasDisponiveis);
                   Main.pausarAplicacao();
                       if(g.adversarios.size()>1 && i != g.adversarios.size()-1 )
                       {
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
                            System.out.println("\nParabens você venceu " + (i+1) +" adversarios!");
                            break;
                        }
                      }
               }
               else if(combate.getVencedor()==0)
               {
                   System.out.println("\nQue pena, voce foi derrotado adversario "+ g.getAdversarios().get(i).getNome());
                   this.player.getCardPrincipal().addExperiencia(((int)-this.expericenciaPorVitoria/4), (ArrayList<CarD>)this.cartasDisponiveis);

                   Main.pausarAplicacao();
                   break;
               }
           }
            if(combate.getVencedor()==1 && i == g.adversarios.size()-1)
            {
                System.out.println("Parabens você venceu todos os adversarios!");
                Main.pausarAplicacao(); 
                this.premioVitoria(g.getAdversarios());
            }
            Main.pausarAplicacao();
        }
    }
    private String toString(int i) {
        return "0"+i;
    }
    private void carregarJogador() {
        
       System.out.println("\n#### TELA DE CADASTRO ####");
       System.out.println("Digite o seu nome:");
       String nome = ler.next();
       player = new Jogador(nome);
        System.out.println("\n#### ESCOLHA SUA CARTA POKEMON INICIAL ####");
        System.out.println("(1) - "+ cartasDisponiveis.get(0).getPk().getNome());
        System.out.println("(2) - "+ cartasDisponiveis.get(3).getPk().getNome());
        System.out.println("(3) - "+ cartasDisponiveis.get(6).getPk().getNome());
        int id = ler.nextInt();
        while(id <0 || id >3)
        {
            System.out.println("******Codigo pokemon invalido!******");
            System.out.println("\n#### ESCOLHA SUA CARTA POKEMON INICIAL ####");
            System.out.println("(1) - "+ cartasDisponiveis.get(0).getPk().getNome());
            System.out.println("(2) - "+ cartasDisponiveis.get(3).getPk().getNome());
            System.out.println("(3) - "+ cartasDisponiveis.get(6).getPk().getNome());
            id = ler.nextInt();
        }
       
        if(id==1) player.addDeckPokemon(cartasDisponiveis.get(0));
        if(id==2) player.addDeckPokemon(cartasDisponiveis.get(3));
        if(id==3) player.addDeckPokemon(cartasDisponiveis.get(6));
        
        System.out.println("**** Parabens, o "+player.getDeckPokemon(0).getPk().getNome()+" e agora seu novo companheiro! ****");
        Main.pausarAplicacao();
    }
    
    private void menuGinasio() {
            System.out.println("\n#### EM QUAL GINASIO VOCE DESEJA BATALHAR ####");
            this.exibirGinasios();
            System.out.println("(-1) - Voltar");
            ler.nextLine();
            int idGinasio = ler.nextInt();
           
            while(((idGinasio >= ginasios.size() || idGinasio<1)) && idGinasio != -1)
            {
                this.menuGinasio();
            }
            if(idGinasio<= ginasios.size() && idGinasio>0)
            {
                this.entrarGinasio(ginasios.get(idGinasio-1));
            }
    }
    
    private void exibirMeusPokemons() {
        System.out.println("###MEUS POKEMONS###");
        System.out.println("N#\tNOME:\t\t\tLEVEL:\t\t\tEXP/EXP\t\tVIDA\t\tATAQUE");
        int i = 1;
        ArrayList opcoes = new ArrayList();
        for(CarD c:this.player.getDeckPokemon())
        {
            if(c.equals(this.player.getCardPrincipal()))
            {
              System.out.println(i+"\t"+c.getPk().getNome() +"\t\t"+ c.getLevelAtual() +"\t\t\t"+ c.getExperienciaAtual()+"/"+c.getExperienciaLevel()+"\t\t"+c.getPk().getVida()+"\t\t"+c.getPk().getsAtaque()+"\t - PRINCIPAL");
            }
            else {
                System.out.println(i+"\t"+c.getPk().getNome() +"\t\t"+ c.getLevelAtual() +"\t\t\t"+ c.getExperienciaAtual()+"/"+c.getExperienciaLevel()+"\t\t"+c.getPk().getVida()+"\t\t"+c.getPk().getsAtaque());
            }
            opcoes.add(player.getDeckPokemon().indexOf(c));
            i++;
        }
        
        System.out.println("Caso deseja alterar seu pokemon principal digite o seu N#");
        int opcao = ler.nextInt();

        if(opcao > 0 && opcao <= this.player.getDeckPokemon().size())
        {
            this.player.setPokemonPrincipal((int) opcoes.get(opcao-1));
            
        }
    }
   
    private void premioVitoria(List<Jogador> adversarios) {
        System.out.println("Escolha um pokemon como premio");
        ArrayList opcoes = new ArrayList();
        int i = 1;
        for(Jogador j:adversarios)
        {
            System.out.println("("+i+") - "+ j.getPokemonPrincipal().getNome());
            opcoes.add(adversarios.indexOf(j));
            i++;
        }
        int opcao = ler.nextInt();
        int indice = (int) opcoes.get(opcao-1);
        if(opcoes.contains(indice))
        {
            this.player.addDeckPokemon(adversarios.get(indice).getCardPrincipal().createNewCardPokemon());
        }
        else
            premioVitoria(adversarios);
    }
}