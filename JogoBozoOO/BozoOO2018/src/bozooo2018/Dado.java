/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bozooo2018;

import java.util.Random;

/**
 *
 * @author HomeNot
 */
public class Dado {
    
    private int totalFaces;
    private int resultado;

    public Dado() {
        
        this.totalFaces = 6;
        this.resultado=0;
        
    }

    public Dado(int totalFaces) {
        
        this.totalFaces = totalFaces;
    }
    
    
    public void rolarDados()
    {
        Random random = new Random();
        this.resultado = random.nextInt(this.totalFaces)+1;    
    }
    public int getDado()
    {   
              
        return this.resultado;
    }
    public String getDadoSimbolo()
    {   
        
        if(this.resultado == 1)
            return ".";
        
        if(this.resultado == 2)
            return ":";
                
        if(this.resultado == 3)
          return ":.";
                            
        if(this.resultado == 4)
          return "::";
        
        if(this.resultado == 5)
          return ":::";
            
        
        return " ";
    }
    
    
    
    
    
}
