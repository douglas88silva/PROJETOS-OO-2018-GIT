/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaheranca;

/**
 *
 * @author HomeNot
 */
public abstract class Animal {
    
    protected String nome;
    protected String raca;
    protected String idade;
    
    
    
    
    public Animal(String nome) {
        this.nome = nome;
    }
    
    
    @Override
    public String toString()
    {   
       return this.nome;
    }
    public boolean equals(Animal a)
    {
        return this.nome.equals(a.nome);
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
    
    
    public void comer()
    {
        System.out.println("O "+this.nome+" está comendo!");
        
    }
    
    public void dormir()
    {
        System.out.println("O "+this.nome+" está dormindo!");
        
    }
    
    abstract public  void emitirSom();
    //System.out.println("O "+this.nome+" está emitindo um som!");

}
