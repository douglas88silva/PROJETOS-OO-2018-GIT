/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.TelaPrincipal.batalhaPokemon;
import static View.TelaPrincipal.menu;
import cardPokemon.CarD;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;



/**
 *
 * @author douglas.silva
 */
public class MenuExibirTodosPokemons extends javax.swing.JInternalFrame {

    private List<CarD> cartasDisponiveis;
    
    /**
     * Creates new form MenuExibirTodosPokemons
     */
    public MenuExibirTodosPokemons() {
        initComponents();
                Toolkit tk = Toolkit.getDefaultToolkit();
            int xsize = (int)tk.getScreenSize().getWidth();
            int ysize = (int)tk.getScreenSize().getHeight();
            
        this.setSize(xsize, ysize);
        
        
        this.cartasDisponiveis = batalhaPokemon.getCartasDisponiveis();
        this.carregarJTable();
        
    }
    
    
     public void carregarJTable()
    {
       
        TabelaTodosPokemons model = new TabelaTodosPokemons(cartasDisponiveis);
        
        this.jTable1.setModel(model);
       
                DefaultTableCellRenderer ESQUERDA = new DefaultTableCellRenderer();
                DefaultTableCellRenderer CENTRALIZADO = new DefaultTableCellRenderer();
                DefaultTableCellRenderer DIREITA = new DefaultTableCellRenderer();
                
                ESQUERDA.setHorizontalAlignment(SwingConstants.LEFT);
                CENTRALIZADO.setHorizontalAlignment(SwingConstants.CENTER);
                DIREITA.setHorizontalAlignment(SwingConstants.RIGHT);
                
                //ALINHAMENTO DO CABEÇALHO
                ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER); 

                //ALINHAMENTO DAS COLUNAS
                jTable1.getColumnModel().getColumn(0).setCellRenderer(CENTRALIZADO);
                jTable1.getColumnModel().getColumn(1).setCellRenderer(CENTRALIZADO);
                jTable1.getColumnModel().getColumn(2).setCellRenderer(CENTRALIZADO);
                jTable1.getColumnModel().getColumn(3).setCellRenderer(CENTRALIZADO);
                jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
                
                //SETANDO O TAMANHO DAS COLUNAS
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(800);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(800);
                

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBorder(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Pokemons Disponiveis");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 340, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 340, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}