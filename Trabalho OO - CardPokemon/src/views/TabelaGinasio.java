package views;


import cardPokemon.Jogador;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 * Classe pela criacao do modelo de tabela utilizado na tela que exibe os adversarios e os pokemons do ginasio
 *
 * @author Douglas
 */
public class TabelaGinasio extends AbstractTableModel {

    private String colunas[] = {"Treinador", "Pokemon", "Vida", "Ataque",};
    private List<Jogador> treinadores;
    private final int COLUNA_TREINADOR = 0;
    private final int COLUNA_POKEMON_NOME = 1;
    private final int COLUNA_VIDA = 2;
    private final int COLUNA_ATAQUE = 3;


    public TabelaGinasio(List<Jogador> cartasDisponiveis) {
        this.treinadores = cartasDisponiveis;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return treinadores.size();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUNA_TREINADOR:
                return String.class;
            case COLUNA_POKEMON_NOME:
                return String.class;
            case COLUNA_VIDA:
                return Integer.class;
            case COLUNA_ATAQUE:
               return Integer.class; 

            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jogador treinador = this.treinadores.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_TREINADOR:
                return treinador.getNome();
            case COLUNA_POKEMON_NOME:
                return treinador.getPokemonPrincipal().getNome();
            case COLUNA_VIDA:
                return treinador.getPokemonPrincipal().getVida();
            case COLUNA_ATAQUE:
               return treinador.getPokemonPrincipal().getsAtaque();
       
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela

}