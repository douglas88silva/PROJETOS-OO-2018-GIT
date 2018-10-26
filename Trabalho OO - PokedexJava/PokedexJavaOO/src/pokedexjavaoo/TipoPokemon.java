/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedexjavaoo;

/**
 *
 * @author ice
 */
public class TipoPokemon implements AtaquesTipo{
    
   private String tipo1 = null;
   private String tipo2 = null;
   private String ataqueRapido;
   private String AtaqueCarregado;
  
   
   public TipoPokemon(){
   }
   
    public TipoPokemon(String tipo1, String tipo2) {
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;      
        
               
        this.setAtaque(tipo1);
        this.setAtaque(tipo2);
    }
   
    @Override
    public void setAtaque(String tipo) {
        
        if(tipo != null)
        {
          //busca os melhores ataques na base
            
            
            this.ataqueRapido = " ";
            this.AtaqueCarregado = " ";
            
        }
         
    }
   
   
}
