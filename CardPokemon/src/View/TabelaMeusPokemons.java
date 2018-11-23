package View;

import static View.TelaPrincipal.batalhaPokemon;
import cardPokemon.CarD;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TabelaMeusPokemons extends AbstractTableModel {

    private String colunas[] = {"N#", "Nome", "Level", "Vida", "Ataque", "Experiencia","Principal"};
    private List<CarD> meusPokemons;
    private final int COLUNA_ID = 0;
    private final int COLUNA_NOME = 1;
    private final int COLUNA_LEVEL = 2;
    private final int COLUNA_VIDA = 3;
    private final int COLUNA_ATAQUE = 4;
    private final int COLUNA_EXP = 5;
    private final int COLUNA_PRINCIPAL = 6;

    public TabelaMeusPokemons(List<CarD> meusPokemons) {
        this.meusPokemons = meusPokemons;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        return false;
    }

    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return meusPokemons.size();
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
            case COLUNA_LEVEL:
                return Integer.class;
            case COLUNA_VIDA:
                return Integer.class;
            case COLUNA_ATAQUE:
               return Integer.class; 
            case COLUNA_EXP:
                return String.class; 
             case COLUNA_PRINCIPAL:
                return Boolean.class;                         
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        CarD carta = this.meusPokemons.get(rowIndex);
        try{
            switch (columnIndex) {
                case COLUNA_ID:
                   return carta.getIdCard();
                case COLUNA_NOME:
                    return carta.getNome();
                case COLUNA_LEVEL:
                    System.out.println(carta.getLevelAtual());
                    return carta.getLevel();
                case COLUNA_VIDA:
                    return carta.getPk().getVida();
                case COLUNA_ATAQUE:
                   return carta.getPk().getsAtaque();
                case COLUNA_EXP:
                   String a = "";
                   return a.concat(carta.getExperienciaAtual()+" / "+ carta.getExperienciaLevel()); 
                case COLUNA_PRINCIPAL:
                   //return carta.equals(batalhaPokemon.player.getCardPrincipal());
                    return false;
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "erro " + e);
        }
        return null;
    }

}