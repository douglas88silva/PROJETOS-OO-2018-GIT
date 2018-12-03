package cardPokemon;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Modelo de Carta de pokemon. Cada carta do jogo tem um pokemon associado, e a
 * carta e uma extensao de uma extrutura de level, ou seja sempre que um pokemon
 * vence a batalha sua carta ganha experiencia e por consequencia e possivel
 * evoluir.
 *
 * @see Pokemon
 *
 *
 */
public class CarD extends LevelUp {

    private static int id = 0;
    private int idCard;
    private int sPCard;
    private Pokemon pk;

    /**
     * Contrutor que avalia o tipo de pokemon para poder instancia seu
     * respectivo tipo
     *
     * @param idCard N# da carta
     * @param nome Nome do pokemon
     * @param tipo tipo do pokemon
     * @param ataque Valor do ataque
     * @param evolucao Quantidade de evoluções
     */
    public CarD(int idCard, String nome, String tipo, int ataque, int evolucao) {

        if ("Planta".equals(tipo)) {
            pk = new Planta(nome, tipo, ataque, evolucao);
        } else if ("Agua".equals(tipo)) {
            pk = new Agua(nome, tipo, ataque, evolucao);
        } else if ("Fogo".equals(tipo)) {
            pk = new Fogo(nome, tipo, ataque, evolucao);
        } else if ("Eletrico".equals(tipo)) {
            pk = new Eletrico(nome, tipo, ataque, evolucao);
        } else {
            pk = new Normal(nome, tipo, ataque, evolucao);
        }

        id++;
        this.idCard = idCard;

    }

    /**
     * Metodo responsavel por adicionar/remover experiencia na carta do pokemon
     * após a sua vitoria na batalha utilizando o console. Este metodo recebe
     * como paramentro todoas as cartas disponiveis no jogo para poder efetuar
     * uma possivel evolucao do pokemons O o pokemon evolui sempre que atinge o
     * level 5 e se exisitir uma evolucao
     *
     * @param experiencia Experiencia recebida
     * @param cartasDiponiveis Cartas disponiveis no jogo
     */
    public void addExperiencia(int experiencia, ArrayList<CarD> cartasDiponiveis) {

        int level_inicial = super.getLevelAtual();

        super.receberExperiencia(experiencia);

        if (level_inicial < super.getLevelAtual()) {
            if (super.getLevelAtual() % 5 == 0)//pokemon pode evoluir
            {
                int totalEvolucao = super.getLevelAtual() - level_inicial;

                while (totalEvolucao > 0) {
                    if (this.pk.getEvolucao() > 0) {
                        //fazendo a troca do pokemon para sua evolucao
                        System.out.println("\n\nOps... Parece que o " + this.pk.getNome() + " vai evoluir!");
                        //Main.pausarAplicacao();

                        this.pk = cartasDiponiveis.get(this.idCard++).getPk();
                        super.evolucao();

                        System.out.println("Parabens! seu pokemon evoluiu para " + this.pk.getNome());
                        //Main.pausarAplicacao();
                    }
                    totalEvolucao--;
                }
            } else {
                System.out.println("ops... Seu pokemon acaba de subir para o level " + super.getLevelAtual());
                this.pk.bonusLevel(super.getBonusAtributoLevel());
                //Main.pausarAplicacao();
            }

        }

    }

    /**
     * Metodo responsavel por adicionar/remover experiencia na carta do pokemon
     * após a sua vitoria na batalha, utilizando inteface grafica. Este metodo
     * recebe como paramentro todoas as cartas disponiveis no jogo para poder
     * efetuar uma possivel evolucao do pokemons O o pokemon evolui sempre que
     * atinge o level 5 e se exisitir uma evolucao
     *
     * @param experiencia Experiencia recebida
     * @param cartasDiponiveis Cartas disponiveis no jogo
     */
    public void addExperienciaInterface(int experiencia, ArrayList<CarD> cartasDiponiveis) {

        int level_inicial = super.getLevelAtual();

        super.receberExperiencia(experiencia);

        if (level_inicial < super.getLevelAtual()) {
            if (super.getLevelAtual() % 5 == 0)//pokemon pode evoluir
            {
                int totalEvolucao = super.getLevelAtual() - level_inicial;

                while (totalEvolucao > 0) {
                    if (this.pk.getEvolucao() > 0) {
                        //fazendo a troca do pokemon para sua evolucao
                        System.out.println("\n\nOps... Parece que o " + this.pk.getNome() + " vai evoluir!");
                        JOptionPane.showMessageDialog(null, "\n\nOps... Parece que o " + this.pk.getNome() + " vai evoluir!");
                        //Main.pausarAplicacao();

                        this.pk = cartasDiponiveis.get(this.idCard++).getPk();
                        super.evolucao();

                        System.out.println("Parabens! seu pokemon evoluiu para " + this.pk.getNome());
                        JOptionPane.showMessageDialog(null, "Parabens! seu pokemon evoluiu para " + this.pk.getNome());

                        //Main.pausarAplicacao();
                    }
                    totalEvolucao--;
                }
            } else {
                System.out.println("ops... Seu pokemon acaba de subir para o level " + super.getLevelAtual());
                JOptionPane.showMessageDialog(null, "ops... Seu pokemon acaba de subir para o level " + super.getLevelAtual());

                this.pk.bonusLevel(super.getBonusAtributoLevel());
                //Main.pausarAplicacao();
            }

        }

    }

    /**
     * Metodo responsavel por criar uma nova carta de pokemon com base na carta
     * atual, e retornar a mesma. Utilizo esse metodo sempre que quero criar um
     * novo pokemon que existe na minha lista de pokemons
     *
     * @return CarD
     *
     */
    public CarD createNewCardPokemon() {

        int idPk = this.idCard;
        String nomePk = this.pk.getNome();
        String tipoPK = this.pk.getTipo();
        int ataquePK = this.pk.getsAtaque();
        int evolucaoPK = this.pk.getEvolucao();

        CarD aux = new CarD(idCard, nomePk, tipoPK, ataquePK, evolucaoPK);

        return aux;

    }

    /**
     * Metodo responsavel por criar uma nova carta de pokemon com base na carta
     * atual, e retornar a mesma. Esse metodo é uma sobrecarga com um atributo
     * nivel, de a cordo com o valor do nivel do pokemon que você quer criar, o
     * pokemon pode ficar mais forte ou mais fraco. Fiz uma reducao de forca dos
     * pokemons de acordo com o nivel que é recebido como parametro. Os niveis
     * variam de 1 ate 4 com reducao da forca do pokemon caso ele esteja na sua
     * forma mais evoluida, 5 a 10 os pokemons não sofrem penalidades de ataque
     * e vida, cima do nivel 10 o pokemons recebe nivel% a mais de bonus de
     * ataque e vida. Este metodo é utilizado na hora de criar as cartas para os
     * adversarios, pois de acordo com o nivel do ginasio os pokemons precisam
     * ficar mais fortes ou mais fracos
     *
     * @param nivel Nivel do Ginasio, variavel que define a forca do pokemon
     * @return CarD Carta do pokemon criada
     *
     */
    public CarD createNewCardPokemon(int nivel) {

        int idPk = this.idCard;
        String nomePk = this.pk.getNome();
        String tipoPK = this.pk.getTipo();
        int ataquePK = this.pk.getsAtaque();
        int evolucaoPK = this.pk.getEvolucao();

        CarD aux;

        switch (nivel) {
            case 1:
                if (evolucaoPK == 0) {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK * 80 / 100)), evolucaoPK);
                } else {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK * 40 / 100)), evolucaoPK);
                }

                break;

            case 2:
                if (evolucaoPK == 0) {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK * 60 / 100)), evolucaoPK);
                } else {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK * 30 / 100)), evolucaoPK);
                }
                break;

            case 3:
                if (evolucaoPK == 0) {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK * 40 / 100)), evolucaoPK);
                } else {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK * 20 / 100)), evolucaoPK);
                }
                break;
            case 4:
                if (evolucaoPK == 0) {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK * 20 / 100)), evolucaoPK);
                } else {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK * 10 / 100)), evolucaoPK);
                }
                break;

            default:
                if (nivel > 10) {
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK + (ataquePK * nivel / 100)), evolucaoPK);
                } else {
                    aux = new CarD(idCard, nomePk, tipoPK, ataquePK, evolucaoPK);
                }
        }

        return aux;

    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getsPCard() {
        return sPCard;
    }

    public void setsPCard(int sPCard) {
        this.sPCard = sPCard;
    }

    public Pokemon getPk() {
        return pk;
    }

    public void setPk(Pokemon pk) {
        this.pk = pk;
    }

    public String getNome() {
        return this.pk.getNome();
    }

    public int getLevel() {
        return super.getLevelAtual();
    }

    public void setLevel(int level) {
        super.setLevelAtual(level);
    }

    @Override
    public String toString() {
        return this.pk.getNome();
    }

}
