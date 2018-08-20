/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

/**
 *
 * @author HomeNot
 */
public class Tabuleiro {
    
    char tabuleiro[];
    //int tabuleiroOculto[];
    Barco tabuleiroOculto[];
    int tamanhoTabuleiro;
   

    public Tabuleiro(int tamanhoTabuleiro) {
        
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        tabuleiro = new char[tamanhoTabuleiro];
        
        this.tabuleiroOculto = new Barco[tamanhoTabuleiro];
        
        for(int i = 0;i<tamanhoTabuleiro;i++)
        {
            
           this.tabuleiro[i]='*';
           this.tabuleiroOculto[i]=null;
        
        }
    }
    
    public void mostrarTabuleiro()
    {   
        System.out.println("Tabuleiro");
        System.out.print("0 1 2 3 4 5 6 7 8 9 ");
        System.out.println("");
          for(int i = 0;i<this.tamanhoTabuleiro;i++)
        {
            
            System.out.print(this.tabuleiro[i]+" ");
        
        }
        System.out.println(" ");  
    }
    public void mostrarTabuleiroOculto()
    {
          for(int i = 0;i<this.tamanhoTabuleiro;i++)
        {
            System.out.print(this.tabuleiroOculto[i]+"");
        
        }
    }
    
    public void InsereBarco(Barco b1){
           
       for(int i=0;i<b1.tamanhoBarco;i++) 
       {
           this.tabuleiroOculto[b1.barco[i]] = b1; 
       }
    }
    
    public void atirarNoBarco(int tiro)
    {
        
        if(tabuleiroOculto[tiro] == null)
        {    
            tabuleiro[tiro] = 'X';
            System.out.println("Errou o tiro!!!");
        }
        else
        {   
           tabuleiro[tiro] = 'O';
           tabuleiroOculto[tiro].acertouTiro++;
           System.out.println("Otimo tiro!!!");
           
        }
    }

    
}
