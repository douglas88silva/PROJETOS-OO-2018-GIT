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
public class ValorInvalidoException extends Exception {

    
    
    @Override
    public String getMessage() {
        return "Quantidade negativa";
    }
    
    
    
}
