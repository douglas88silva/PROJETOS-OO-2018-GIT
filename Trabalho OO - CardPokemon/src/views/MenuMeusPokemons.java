/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import static views.TelaPrincipal.batalhaPokemon;
import static views.TelaPrincipal.jPAreaTrabalho;
import static views.TelaPrincipal.menu;
import cardPokemon.CarD;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Classe que implementa a tela que representa o menu que exibe os pokemons do jogador
 *
 * @author Douglas
 */
public class MenuMeusPokemons extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuMeusPokemons
     */
    List<CarD> cartasDisponiveis;

    public MenuMeusPokemons() {
        initComponents();
                Toolkit tk = Toolkit.getDefaultToolkit();
            int xsize = (int)tk.getScreenSize().getWidth();
            int ysize = (int)tk.getScreenSize().getHeight();
            
        this.setSize(xsize, ysize);
        
        
        this.cartasDisponiveis = batalhaPokemon.getPlayer().getDeckPokemon();


        this.carregarJTable();

    }

    public void carregarJTable() {

        TabelaMeusPokemons model = new TabelaMeusPokemons(cartasDisponiveis);

        this.jTable.setModel(model);
        
        
                DefaultTableCellRenderer ESQUERDA = new DefaultTableCellRenderer();
                DefaultTableCellRenderer CENTRALIZADO = new DefaultTableCellRenderer();
                DefaultTableCellRenderer DIREITA = new DefaultTableCellRenderer();
                
                ESQUERDA.setHorizontalAlignment(SwingConstants.LEFT);
                CENTRALIZADO.setHorizontalAlignment(SwingConstants.CENTER);
                DIREITA.setHorizontalAlignment(SwingConstants.RIGHT);
                
                //ALINHAMENTO DO CABEÇALHO
                ((DefaultTableCellRenderer) jTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER); 

                //ALINHAMENTO DAS COLUNAS
                jTable.getColumnModel().getColumn(0).setCellRenderer(CENTRALIZADO);
                jTable.getColumnModel().getColumn(1).setCellRenderer(CENTRALIZADO);
                jTable.getColumnModel().getColumn(2).setCellRenderer(CENTRALIZADO);
                jTable.getColumnModel().getColumn(3).setCellRenderer(CENTRALIZADO);
                jTable.getColumnModel().getColumn(4).setCellRenderer(CENTRALIZADO);
                jTable.getColumnModel().getColumn(5).setCellRenderer(CENTRALIZADO);
                
                
                
                jTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
                
                //SETANDO O TAMANHO DAS COLUNAS
                jTable.getColumnModel().getColumn(0).setPreferredWidth(50);
                jTable.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTable.getColumnModel().getColumn(2).setPreferredWidth(800);
                jTable.getColumnModel().getColumn(3).setPreferredWidth(800);
                jTable.getColumnModel().getColumn(4).setPreferredWidth(800);
                jTable.getColumnModel().getColumn(5).setPreferredWidth(800);
                jTable.getColumnModel().getColumn(6).setPreferredWidth(200);
        
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1_voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1_principal = new javax.swing.JToggleButton();
        jTextField1_Numero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBorder(null);

        jButton1_voltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1_voltar.setText("Voltar");
        jButton1_voltar.setNextFocusableComponent(jTextField1_Numero);
        jButton1_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_voltarActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable.setFocusable(false);
        jScrollPane1.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Meus Pokemons");

        jToggleButton1_principal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToggleButton1_principal.setText("Alterar Pokemon Principal");
        jToggleButton1_principal.setNextFocusableComponent(jButton1_voltar);
        jToggleButton1_principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1_principalActionPerformed(evt);
            }
        });

        jTextField1_Numero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1_Numero.setNextFocusableComponent(jToggleButton1_principal);
        jTextField1_Numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_NumeroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("N#");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 305, Short.MAX_VALUE)
                        .addComponent(jButton1_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jToggleButton1_principal)
                    .addComponent(jLabel1))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_NumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_NumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_NumeroActionPerformed

    private void jButton1_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_voltarActionPerformed

        this.setVisible(false);
        menu.setVisible(true);


    }//GEN-LAST:event_jButton1_voltarActionPerformed

    private void jToggleButton1_principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1_principalActionPerformed
        // TODO add your handling code here:
        try {
            int idCard = Integer.parseInt(jTextField1_Numero.getText());

                batalhaPokemon.getPlayer().setPokemonPrincipal(idCard);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Carta invalida!", null, 2);

        }
        finally{
            this.carregarJTable();
        }

        // jTable.setValueAt(cartasDisponiveis, Integer.parseInt(jTextField1.getText()), 6);

    }//GEN-LAST:event_jToggleButton1_principalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1_Numero;
    private javax.swing.JToggleButton jToggleButton1_principal;
    // End of variables declaration//GEN-END:variables
}