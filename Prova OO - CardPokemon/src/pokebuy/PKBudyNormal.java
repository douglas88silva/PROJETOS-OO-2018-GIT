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
public class PKBudyNormal extends Brinquedo {

    private String tipo;

    public PKBudyNormal(String tipo) {
        this.tipo = tipo;
    }

    
    @Override
    public void emitirSom() {

        System.out.println("smash");
    }

    
}
