/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_aula270818;

/**
 *
 * @author HomeNot
 */
public class Cachorro {
    
    public static int cont = 0;
    private String nome;
    private String raca;
    
    
    
    public Cachorro(){
    cont++;
    }
    
    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
        
        cont++;
    }
    
    public void venderCachorro()
    {
      cont--;   
    }
    
    
    
}
