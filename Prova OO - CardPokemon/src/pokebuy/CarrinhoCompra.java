/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokebuy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ice
 */
public class CarrinhoCompra {
 
    
    private Brinquedo briquedos;
    private int quantidade;

    public CarrinhoCompra() {
       briquedos = null;
       quantidade = 0;
       
    }

    @Override
    public String toString() {
        return "CarrinhoCompra{" + "briquedos=" + briquedos + ", quantidade=" + quantidade + '}';
    }

  
    
    public String getnomeProduto()
    {
        return briquedos.getNome();
    }
    
    public void addBriquedo(Brinquedo bd, int quantidade)
    {
        
        briquedos = bd;
        this.quantidade+=quantidade;
        
    }
    
    
    
    public void exibirProdutos()
    {
        
        System.out.println("\tNome:"+this.briquedos.getNome()+"\tQuantidade:"+this.quantidade+"\tPreco unitario:"+briquedos.getPreco());

        
        
    }
    public double getPreco(){
    
    return briquedos.getPreco();
    
}
    public Brinquedo getBriquedos() {
        return briquedos;
    }

    public void setBriquedos(Brinquedo briquedos) {
        this.briquedos = briquedos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
 
    }
    
    
    
    

