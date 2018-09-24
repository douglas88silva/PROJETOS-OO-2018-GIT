/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaheranca;

/**
 *
 * @author HomeNot
 */
public class Gato extends Animal{

    
    public Gato(String nome) {
        super(nome);
    }
    
    @Override
    public void emitirSom()
    {
              //super.emitirSom();
              System.out.println("Miauuuu!!!");
      //System.out.println("O "+super.getNome()+" está miando!");

    }
   
}
