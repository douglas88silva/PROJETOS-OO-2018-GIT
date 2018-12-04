/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokebuy;

/**
 *
 * @author ice
 */
public class PKBudyAgua extends Brinquedo {


    private String tipo;

    public PKBudyAgua(String tipo) {
        this.tipo = tipo;
    }
    
        public PKBudyAgua(String tipo, String nome, double preco) {
        
            super.setNome(nome);
            super.setPreco(preco);
            this.tipo = tipo;
    }
    
    
    
 

    
    @Override
    public void emitirSom() {

        System.out.println("Glubblub");
    }

    
}
