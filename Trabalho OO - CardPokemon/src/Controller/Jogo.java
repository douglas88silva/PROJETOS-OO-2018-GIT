/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CarregaDadosTXT;
import cardPokemon.CarD;
import cardPokemon.Duelo;
import cardPokemon.Ginasio;
import cardPokemon.Jogador;
import controller.Main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Classe que controla todas as funcionalidades do Jogo, criando as instancias e
 * objetos que o jogo precisa para ser executado.
 *
 * @see CarD
 * @see Jogador
 * @see Ginasio
 * @autor Douglas
 * @throw Exception para leitura do arquivo com os dados dos pokemons e para os
 * acessos as estruturas de armazenamentos
 */
public class Jogo {

    private List<CarD> cartasDisponiveis;
    private int totalCartas;
    private Jogador player;
    private List<Ginasio> ginasios;
    private boolean fecharJogo = false;
    private int expericenciaPorVitoria = 1000;
    Scanner ler = new Scanner(System.in);
    public int VENCEDOR;

    /**
     * Construtor da classe jogo, carrega a lista de pokemons contida no arquivo
     * externo e cria os ginasios para batalhar
     *
     * @see CarregaDadosTXT.java
     * @throw Exception
     */
    public Jogo() throws Exception {

        ginasios = new ArrayList();
        CarregaDadosTXT loadCartas = new CarregaDadosTXT();
        cartasDisponiveis = loadCartas.carregarPokemons();

        //CRIANDO OS GINASIOS
        for (int i = 0; i < 5; i++) {
            String ginasio_nome = "GINASIO_";
            ginasio_nome = ginasio_nome.concat(toString(i + 1));
            Ginasio g = new Ginasio(ginasio_nome, (ArrayList<CarD>) cartasDisponiveis);
            ginasios.add(g);
        }
        this.totalCartas = cartasDisponiveis.size();
    }

    /**
     * Metodo responsavel por estartar o jogo via console, exibindo o primeiro
     * menu do jogo
     *
     * @throw Exception
     */
    public void iniciaJogoConsole() throws Exception {
        System.out.println("#### LOADING BATALHA CARTAS POKEMON ####");
        this.carregarJogadorConsole();
        while (this.fecharJogo == false) {
            System.out.println("\n#### BATALHA DE CARTAS POKEMON####");
            System.out.println("#####MENU PRINCIPAL#####");
            System.out.println("( 1) - GINASIOS");
            System.out.println("( 2) - MEUS POKEMONS");
            System.out.println("( 3) - CARTAS DISPONIVEIS");
            System.out.println("(-1) - SAIR");
            int opcao = ler.nextInt();
            if (opcao == 1) {
                this.menuGinasioConsole();
            }
            if (opcao == 2) {
                this.exibirMeusPokemonsConsole();
            }
            if (opcao == 3) {
                this.exibirPokemonsDisponiveisConsole();
            }
            if (opcao == -1) {
                this.fecharJogo = true;
            }
        }
    }

    /**
     * Metodo responsavel por exibir o todos os pokemons diponivies no jogo
     * dentro do console
     */
    public void exibirPokemonsDisponiveisConsole() {
        Iterator cartas = this.cartasDisponiveis.iterator();
        while (cartas.hasNext()) {
            CarD c = (CarD) cartas.next();
            System.out.println(c.getIdCard() + " - " + c.getPk().getNome());
        }
        Main.pausarAplicacao();
    }

    /**
     * Metodo responsavel por exibir os ginasios dentro do console
     */
    public void exibirGinasiosConsole() {
        System.out.println("#### GINASIOS ABERTOS ####");
        Iterator gin = this.ginasios.iterator();
        int i = 1;
        while (gin.hasNext()) {
            Ginasio c = (Ginasio) gin.next();
            System.out.println("(" + i + ")" + " - " + c.getNome());
            i++;
        }
    }

    /**
     * Metodo responsavel por batalhar dentro de um ginasio(utilizando o
     * console), ele recebe como paramentro um Ginasio e inicia uma batalha ate
     * que um treinador venca. Sempre que o jogador vencer todos os adversarios
     * dentro do ginasio ele é premiado com um pokemon aleatorio Quando o
     * jogador vence seu pokemon que batalhou ganha experiencia Quando tem mais
     * de um adversario dentro do Ginasio o jogador pode escolher apos um duelo
     * desafiar o proximo ou nao.
     *
     * @param g
     */
    public void entrarGinasioConsole(Ginasio g) throws Exception {
        //INICIAR A BATALHA
        System.out.println("\ns#### ENTRANDO NO GINASIO " + g.getNome() + " ####");

        g.exibirAdversarios();
        Main.pausarAplicacao();

        for (int i = 0; i < g.getAdversarios().size(); i++) {
            System.out.println("###################################### DUELO ##########################################");
            System.out.println(
                    "[" + this.player.getNome() + " - " + this.player.getPokemonPrincipal().getNome() + "] "
                    + "X"
                    + " [" + g.getAdversarios().get(i).getNome() + " - " + g.getAdversarios().get(i).getPokemonPrincipal().getNome() + "]");

            System.out.println("############");

            Main.pausarAplicacao();
            Duelo combate = new Duelo(this.player, g.getAdversarios().get(i));
            combate.duelar();

            if (combate.getVencedor() != -1) {
                if (combate.getVencedor() == 1) {
                    System.out.println("Parabens você venceu a batalha!");
                    this.player.getCardPrincipal().addExperiencia(this.expericenciaPorVitoria, (ArrayList<CarD>) this.cartasDisponiveis);
                    //Main.pausarAplicacao();
                    if (g.getAdversarios().size() > 1 && i != g.getAdversarios().size() - 1) {
                        System.out.println("Deseja desafiar o proximo?(s/n)");
                        String opcao = ler.next();
                        ler.nextLine();
                        while (!"s".equals(opcao) && !"n".equals(opcao)) {
                            System.out.println("Deseja desafiar o proximo?(s/n)");
                            opcao = ler.next();
                            ler.nextLine();
                        }
                        if (("s").equals(opcao)) {
                            combate.setVencedor(-1);
                        } else {
                            System.out.println("\nParabens você venceu " + (i + 1) + " adversarios!");
                            break;
                        }
                    }
                } else if (combate.getVencedor() == 0) {
                    System.out.println("\nQue pena, voce foi derrotado adversario " + g.getAdversarios().get(i).getNome());
                    this.player.getCardPrincipal().addExperiencia(((int) -this.expericenciaPorVitoria / 4), (ArrayList<CarD>) this.cartasDisponiveis);

                    //Main.pausarAplicacao();
                    break;
                }
            }
            if (combate.getVencedor() == 1 && i == g.getAdversarios().size() - 1) {
                System.out.println("Parabens você venceu todos os adversarios!");
                Main.pausarAplicacao();
                this.premioVitoriaConsole(g.getAdversarios());
            }
            Main.pausarAplicacao();
        }
    }

    /**
     * Metodo responsavel por batalhar dentro de um ginasio(utilizando a
     * interface grafica), ele recebe como paramentro um Ginasio e inicia uma
     * batalha ate que um treinador venca. Sempre que o jogador vencer todos os
     * adversarios dentro do ginasio ele é premiado com um pokemon aleatorio
     * Quando o jogador vence seu pokemon que batalhou ganha experiencia Quando
     * tem mais de um adversario dentro do Ginasio o jogador pode escolher apos
     * um duelo desafiar o proximo ou nao. obs.: Foi necessário passar um
     * componente da interface grafica(JTextArea) para poder imprimir toda a
     * luta na tela.
     *
     * @param g
     */
    public void batalharGinasio(Ginasio g, JTextArea jTextArea1) throws Exception {
        //INICIAR A BATALHA

        VENCEDOR = 9;

        jTextArea1.append("\n#### ENTRANDO NO GINASIO " + g.getNome() + " ####");

        for (int i = 0; i < g.getAdversarios().size(); i++) {

            jTextArea1.append("\n########################### DUELO ############################");
            jTextArea1.append(
                    "\n[" + this.player.getNome() + " - " + this.player.getPokemonPrincipal().getNome() + "] "
                    + "X"
                    + " [" + g.getAdversarios().get(i).getNome() + " - " + g.getAdversarios().get(i).getPokemonPrincipal().getNome() + "]");

            System.out.println("\n############");

            //Main.pausarAplicacao();
            Duelo combate = new Duelo(this.player, g.getAdversarios().get(i));

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
            VENCEDOR = combate.duelarInstantaneo(jTextArea1);
//                }
//            }).start();

            if (VENCEDOR != -1) {
                if (VENCEDOR == 1) {

                    JOptionPane.showMessageDialog(null, "\nParabens você venceu a batalha!");
                    jTextArea1.append("\nParabens você venceu a batalha!");
                    this.player.getCardPrincipal().addExperienciaInterface(this.expericenciaPorVitoria, (ArrayList<CarD>) this.cartasDisponiveis);
                    //Main.pausarAplicacao();
                    if (g.getAdversarios().size() > 1 && i != g.getAdversarios().size() - 1) {

                        int Confirm = JOptionPane.showConfirmDialog(null, "Deseja desafiar o proximo treinador?", "sim ou nao", JOptionPane.YES_NO_OPTION);
                        if (Confirm == JOptionPane.YES_OPTION) {
                            combate.setVencedor(-1);

                        } else if (Confirm == JOptionPane.NO_OPTION) {

                            JOptionPane.showMessageDialog(null, "\nParabens você venceu " + (i + 1) + " adversarios!");
                            System.out.println("\nParabens você venceu " + (i + 1) + " adversarios!");
                            jTextArea1.append("\nParabens você venceu " + (i + 1) + " adversarios!");
                            break;

                        }

                    }
                } else if (VENCEDOR == 0) {
                    JOptionPane.showMessageDialog(null, "\nQue pena, voce foi derrotado adversario " + g.getAdversarios().get(i).getNome());
                    jTextArea1.append("\nQue pena, voce foi derrotado adversario ");
                    this.player.getCardPrincipal().addExperienciaInterface(((int) -this.expericenciaPorVitoria / 4), (ArrayList<CarD>) this.cartasDisponiveis);

                    //ENFRAQUECENDO O POKEMON INIMIGO
                    g.setVENCIDO(false);
                    this.ginasios.get(i).atualizaPokemonsGinasio(this.cartasDisponiveis);

                    //Main.pausarAplicacao();
                    break;
                }
            }
            if (VENCEDOR == 1 && i == g.getAdversarios().size() - 1) {
                JOptionPane.showMessageDialog(null, "Parabens você venceu todos os adversarios!");
                jTextArea1.append("\nParabens você venceu todos os adversarios!");
                System.out.println("Parabens você venceu todos os adversarios!");

                //FORTALECENDO O POKEMON INIMIGO
                g.setVENCIDO(true);
                this.ginasios.get(i).atualizaPokemonsGinasio(this.cartasDisponiveis);

                //Main.pausarAplicacao(); 
                this.premioVitoriaInstatanea(g.getAdversarios());
            }
            //Main.pausarAplicacao();
        }

        jTextArea1.append("\n\n########################### FIM DA BATALHA ############################");
//        JOptionPane.showMessageDialog(null, "Fim da batalha");
    }

    public String toString(int i) {
        return "0" + i;
    }

    /**
     * Metodo responsavel por instanciar um jogador utilizando o console(simulando uma tela de cadastro do jogo)
     */
    public void carregarJogadorConsole() {

        System.out.println("\n#### TELA DE CADASTRO ####");
        System.out.println("Digite o seu nome:");
        String nome = ler.next();
        player = new Jogador(nome);
        System.out.println("\n#### ESCOLHA SUA CARTA POKEMON INICIAL ####");
        System.out.println("(1) - " + cartasDisponiveis.get(0).getPk().getNome());
        System.out.println("(2) - " + cartasDisponiveis.get(3).getPk().getNome());
        System.out.println("(3) - " + cartasDisponiveis.get(6).getPk().getNome());
        int id = ler.nextInt();
        while (id < 0 || id > 3) {
            System.out.println("******Codigo pokemon invalido!******");
            System.out.println("\n#### ESCOLHA SUA CARTA POKEMON INICIAL ####");
            System.out.println("(1) - " + cartasDisponiveis.get(0).getPk().getNome());
            System.out.println("(2) - " + cartasDisponiveis.get(3).getPk().getNome());
            System.out.println("(3) - " + cartasDisponiveis.get(6).getPk().getNome());
            id = ler.nextInt();
        }

        if (id == 1) {
            player.addDeckPokemon(cartasDisponiveis.get(0));
        }
        if (id == 2) {
            player.addDeckPokemon(cartasDisponiveis.get(3));
        }
        if (id == 3) {
            player.addDeckPokemon(cartasDisponiveis.get(6));
        }

        System.out.println("**** Parabens, o " + player.getDeckPokemon(0).getPk().getNome() + " e agora seu novo companheiro! ****");
        Main.pausarAplicacao();
    }

    /**
    Metodo responsavel por simular um menu com todos os ginaisos
    */ 
    public void menuGinasioConsole() throws Exception {
        System.out.println("\n#### EM QUAL GINASIO VOCE DESEJA BATALHAR ####");
        this.exibirGinasiosConsole();
        System.out.println("(-1) - Voltar");
        ler.nextLine();
        int idGinasio = ler.nextInt();

        while (((idGinasio >= ginasios.size() || idGinasio < 1)) && idGinasio != -1) {
            this.menuGinasioConsole();
        }
        if (idGinasio <= ginasios.size() && idGinasio > 0) {
            this.entrarGinasioConsole(ginasios.get(idGinasio - 1));
        }
    }

    /**
    Metodo responsavel por simular um menu para exibir os pokemons do jogador
    */
    public void exibirMeusPokemonsConsole() {
        System.out.println("###MEUS POKEMONS###");
        System.out.println("N#\tNOME:\t\t\tLEVEL:\t\t\tEXP/EXP\t\tVIDA\t\tATAQUE");
        int i = 1;
        ArrayList opcoes = new ArrayList();
        for (CarD c : this.player.getDeckPokemon()) {
            if (c.equals(this.player.getCardPrincipal())) {
                System.out.println(i + "\t" + c.getPk().getNome() + "\t\t" + c.getLevelAtual() + "\t\t\t" + c.getExperienciaAtual() + "/" + c.getExperienciaLevel() + "\t\t" + c.getPk().getVida() + "\t\t" + c.getPk().getsAtaque() + "\t - PRINCIPAL");
            } else {
                System.out.println(i + "\t" + c.getPk().getNome() + "\t\t" + c.getLevelAtual() + "\t\t\t" + c.getExperienciaAtual() + "/" + c.getExperienciaLevel() + "\t\t" + c.getPk().getVida() + "\t\t" + c.getPk().getsAtaque());
            }
            opcoes.add(player.getDeckPokemon().indexOf(c));
            i++;
        }

        System.out.println("Caso deseja alterar seu pokemon principal digite o seu N#");
        int opcao = ler.nextInt();

        if (opcao > 0 && opcao <= this.player.getDeckPokemon().size()) {
            this.player.setPokemonPrincipal((int) opcoes.get(opcao - 1));

        }
    }

    /**
    Metodo responsavel por simular um menu(console) que exibi os premios apos o jogador vencer um ginasio
    * nesta implementação o jogador pode escolher um pokemon entre todos que ele venceu no ginasio para
    * ser capturado
    */
    public void premioVitoriaConsole(List<Jogador> adversarios) {
        System.out.println("Escolha um pokemon como premio");
        ArrayList opcoes = new ArrayList();
        int i = 1;
        for (Jogador j : adversarios) {
            System.out.println("(" + i + ") - " + j.getPokemonPrincipal().getNome());
            opcoes.add(adversarios.indexOf(j));
            i++;
        }
        int opcao = ler.nextInt();
        int indice = (int) opcoes.get(opcao - 1);
        if (opcoes.contains(indice)) {
            this.player.addDeckPokemon(adversarios.get(indice).getCardPrincipal().createNewCardPokemon());
        } else {
            premioVitoriaConsole(adversarios);
        }
    }

     /**
    Metodo responsavel por selecionar um pokemon de premio para o jogador que vence todos os ginasio
    * O premio nunca pode ser a ultima evolucao de um pokemon
    * Caso o treinado ja possua o pokemon sorteado, o pokemon do treinado ganha o dobro de experiencia como premio
    */
    public void premioVitoriaInstatanea(List<Jogador> adversarios) throws Exception {
        Random r = new Random();

//        //PEGANDO ALEATORIAMENTE DENTRO DOS POKEMONS DOS ADVERSARIOS
//        int indexJogador = r.nextInt(adversarios.size());
//        int idCard = adversarios.get(indexJogador).getCardPrincipal().getIdCard();      
//        int indexOf = this.getIndexOfCardID(idCard);
        //PEGANDO ALEATORIAMENTE DENTRO DE TODOS OS POKEMONS DISPONIVEIS
        int evolucao = 0; //NAO PERMITE Q O PREMIO SEJA A ULTIMA EVOLUCAO DO POKEMON
        int idCard = -1, indexOf = -1;

        while (evolucao == 0) {

            CarD pk = this.cartasDisponiveis.get(r.nextInt(cartasDisponiveis.size()));
            idCard = pk.getIdCard();
            indexOf = this.getIndexOfCardID(idCard);
            evolucao = pk.getPk().getEvolucao();
        }

        //CASO JÁ EXISTA O POKEMON NO DECK ADICIONA O DOBRO DE EXPERIENCIA PARA O MESMO
        if (!this.player.existsOfIdCarD(idCard)) {

            CarD aux = cartasDisponiveis.get(indexOf).createNewCardPokemon();
            this.player.addDeckPokemon(aux);
            JOptionPane.showMessageDialog(null, "Parabens, agora " + aux.getNome() + " e seu novo companheiro");

        } else {
            this.player.getDeckPokemon(idCard).addExperienciaInterface(2 * this.expericenciaPorVitoria, (ArrayList<CarD>) this.cartasDisponiveis);
        }

    }
    /**
    Metodo responsavel retornar a posicao de um pokemon na lista com base em seu N#(id inicial)
    */
    public int getIndexOfCardID(int id) throws Exception {

        int indexOfCardID = 0;

        for (CarD carta : cartasDisponiveis) {

            if (carta.getIdCard() == id) {
                indexOfCardID = cartasDisponiveis.indexOf(carta);
            }

        }

        return indexOfCardID;

    }

    public List<CarD> getCartasDisponiveis() {
        return cartasDisponiveis;
    }

    public void setCartasDisponiveis(List<CarD> cartasDisponiveis) {
        this.cartasDisponiveis = cartasDisponiveis;
    }

    public int getTotalCartas() {
        return totalCartas;
    }

    public void setTotalCartas(int totalCartas) {
        this.totalCartas = totalCartas;
    }

    public Jogador getPlayer() {
        return player;
    }

    public void setPlayer(Jogador player) {
        this.player = player;
    }

    public List<Ginasio> getGinasios() {
        return ginasios;
    }

    public void setGinasios(List<Ginasio> ginasios) {
        this.ginasios = ginasios;
    }

    public boolean isFecharJogo() {
        return fecharJogo;
    }

    public void setFecharJogo(boolean fecharJogo) {
        this.fecharJogo = fecharJogo;
    }

    public int getExpericenciaPorVitoria() {
        return expericenciaPorVitoria;
    }

    public void setExpericenciaPorVitoria(int expericenciaPorVitoria) {
        this.expericenciaPorVitoria = expericenciaPorVitoria;
    }

}
