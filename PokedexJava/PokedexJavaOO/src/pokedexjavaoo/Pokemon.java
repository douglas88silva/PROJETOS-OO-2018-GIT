/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedexjavaoo;

/**
 *
 * @author HomeNot
 */
public class Pokemon extends TipoPokemon {
    
    private String nome;
    private String apelido;
    private int dust;
    private int id;
    private TipoPokemon tipoPokemon;
    
    public Pokemon(String nome,int dust){
        
        try{
            //buscar o nome na base de dados
            
            
            //Buscar os tipos na base//criar uma execao caso os dois tipos sejam null
            String tipo1 = null,tipo2 = null;
            
            if(tipo1 !=null && tipo2 !=null)
            {
               System.out.println("Não foi possivel encontrar o tipo do seu pokemon na base");

            }
            
            else{
                this.tipoPokemon = new TipoPokemon(tipo1,tipo2);
                
            }
            
        }catch(Exception e)
        {
            System.out.println("Pokemon não existe na base de dados");
        }
        
        
    }

    public String getNome() {
        return nome;
    }
    
    public String getApelido()
    {
        return this.apelido;
    }
        
    public int getId() {
        return id;
    }

    public int getDust() {
        return dust;
    }
    
    
    //
    public void setApelido(String apelido)
    {
        this.apelido=apelido;
    }
    
    

    
}
