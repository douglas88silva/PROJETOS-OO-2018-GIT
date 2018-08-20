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
public class Barco {
    String nome;
    int barco[] = new int[3];
    int tamanhoBarco;
    int acertouTiro = 0;
    
    public Barco(int TamanhoTabuleiro){
     
    this.nome = "B1";    
    this.tamanhoBarco = 3;   
    
    int a = (int) ((Math.random() * 10));
    
    if(a==0) a = 1;
    if(a==9) a = 8;
    this.barco[1] = a;
    this.barco[0] = a-1;
    this.barco[2] = a+1;

    }
    
}
