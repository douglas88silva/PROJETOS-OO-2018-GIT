/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacote2;

import javax.swing.JTextField;

/**
 *
 * @author ice
 */
class Pessoa {
    
    String nome;
    String dt;

    public String getNome() {
        return nome;
    }



    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    void setNome(JTextField jTextField1) {
        this.nome = jTextField1.getText();
    }

    void setDt(JTextField jTextField2) {
        this.dt = jTextField2.getText();
    }

}
