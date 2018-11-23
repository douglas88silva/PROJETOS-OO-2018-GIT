package View;

import cardPokemon.CarD;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaTodosPokemons extends AbstractTableModel {

    private String colunas[] = {"N#", "Nome", "Vida", "Ataque",};
    private List<CarD> cartasDisponivies;
    private final int COLUNA_ID = 0;
    private final int COLUNA_NOME = 1;
    private final int COLUNA_VIDA = 2;
    private final int COLUNA_ATAQUE = 3;


    public TabelaTodosPokemons(List<CarD> cartasDisponiveis) {
        this.cartasDisponivies = cartasDisponiveis;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return cartasDisponivies.size();
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
            case COLUNA_ID:
                return Integer.class;
            case COLUNA_NOME:
                return Integer.class;
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
        CarD carta = this.cartasDisponivies.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_ID:
                return carta.getIdCard();
            case COLUNA_NOME:
                return carta.getNome();
            case COLUNA_VIDA:
                return carta.getPk().getVida();
            case COLUNA_ATAQUE:
               return carta.getPk().getsAtaque();
       
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela

}