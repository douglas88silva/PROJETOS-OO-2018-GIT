/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaheranca;
import java.util.ArrayList;

/**
 *
 * @author HomeNot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         ArrayList <Animal> a = new ArrayList();
         
         
         a.add(new Gato("Gato"));
         a.add(new Gato("Gato"));
         a.add(new Cachorro("Cachorro"));
         
         
         
         
         if(a.get(0).equals(a.get(1)))
             System.out.println("Verdadeiro");
         
//         for(Animal x: a)
//         {
//             System.out.println(x.getNome());;
//             x.emitirSom();   
//         }

        
        
    }
    
}
