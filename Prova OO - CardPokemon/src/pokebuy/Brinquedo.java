/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokebuy;

import cardPokemon.Pokemon;
import java.util.Random;

/**
 *
 * @author ice
 */
public class Brinquedo extends Pokemon implements CaracteristicasBrinquedo{
    
    int id = 0;
    private double preco;
    private Pokemon pk;
    

    
    public Brinquedo(){
        
    }
    
    public String getNome(){
        
        return super.getNome();
    }
    
    public Brinquedo(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    


    public Brinquedo(int id, String nome, int sAtaque, int evolucao,double preco) {
                
        Random r = new Random();
        
        
        if(preco == 0)
             preco = r.nextDouble()+5;
        
        
                        
        if ("Agua".equals(tipo)) {
            pk = new PKBudyAgua(tipo);
        } 
         else {
            pk = new PKBudyNormal("Normal");
        }
        
        pk.setNome(nome);
        pk.setTipo(tipo);
        pk.setsAtaque(sAtaque);
        this.id= id;
        this.preco = preco;
    }

    public Pokemon getPk() {
        return pk;
    }

    public void setPk(Pokemon pk) {
        this.pk = pk;
    }

 
    
    public void mostrarBrinquedo()
    {
        
        System.out.println("\tNome:"+super.getNome()+"\tPreco"+this.preco);
        
        
    }
    
    @Override
    public void emitirSom()
    {
        System.out.println("Arrggggghhhhh");
    }
    
    
    @Override
    public void atacar(Pokemon adversario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
