/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jessi
 */
public class CarD extends LevelUp {

    private static int id = 0;
    private int idCard;
    private int sPCard;
    private Pokemon pk;

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

    public CarD createNewCardPokemon() {

        int idPk = this.idCard;
        String nomePk = this.pk.getNome();
        String tipoPK = this.pk.getTipo();
        int ataquePK = this.pk.getsAtaque();
        int evolucaoPK = this.pk.getEvolucao();

        CarD aux = new CarD(idCard, nomePk, tipoPK, ataquePK, evolucaoPK);

        return aux;

    }

    public CarD createNewCardPokemon(CarD novo) {

        int idPk = novo.idCard;
        String nomePk = novo.pk.getNome();
        String tipoPK = novo.pk.getTipo();
        int ataquePK = novo.pk.getsAtaque();
        int evolucaoPK = novo.pk.getEvolucao();

        CarD aux = new CarD(idCard, nomePk, tipoPK, ataquePK, evolucaoPK);

        return aux;

    }

    public CarD createNewCardPokemon(int nivel) {

        int idPk = this.idCard;
        String nomePk = this.pk.getNome();
        String tipoPK = this.pk.getTipo();
        int ataquePK = this.pk.getsAtaque();
        int evolucaoPK = this.pk.getEvolucao();

        CarD aux;

        switch (nivel) {
            case 1:
                if(evolucaoPK == 0)
                   aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK*80/100)), evolucaoPK); 
                else    
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK*40/100)), evolucaoPK);
                
                break;

            case 2:
                if(evolucaoPK == 0)
                   aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK*60/100)), evolucaoPK); 
                else    
                   aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK*30/100)), evolucaoPK);
                break;

            case 3:
                if(evolucaoPK == 0)
                   aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK*40/100)), evolucaoPK); 
                else    
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK*20/100)), evolucaoPK);
                break;
            case 4:
                if(evolucaoPK == 0)
                   aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK*20/100)), evolucaoPK); 
                else    
                    aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK - (ataquePK*10/100)), evolucaoPK);
                break;                
  
            default:
                if(nivel>10)
                aux = new CarD(idCard, nomePk, tipoPK, (int) (ataquePK + (ataquePK*nivel/100)), evolucaoPK);
                else
                aux = new CarD(idCard, nomePk, tipoPK, ataquePK, evolucaoPK);    
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