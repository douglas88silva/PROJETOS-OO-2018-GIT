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
public class Pokemon {
    
    private String nome;
    private String apelido;
    private int dust;
    private int id;
    
    public Pokemon(String nome,int dust){
        
        try{
            //buscar o nome na base de dados 
        
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
