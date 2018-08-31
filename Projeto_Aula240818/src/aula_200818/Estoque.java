/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_200818;

/**
 *
 * @author HomeNot
 */
public class Estoque {
    private String nome;
    private int quantidadeAtual; // Não pode ser negativo
    private int quantidadeMinima;// Não pode ser negativo

    public Estoque(String nome, int quantidadeAtual, int quantidadeMinima) {
        this.nome = nome;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
    }

    public void setNome(String nome)
    {
        System.out.println("");
        System.out.println("############# ALTERANDO A O NOME DO PRODUTO PARA "+this.nome+" para "+nome+" #############");
        this.nome =nome;
    }
    
    public void setQuantidadeMinima(int quantidadeMinima)
    {
        System.out.println("");
        System.out.println("############# ALTERANDO A QUANTIDADE MINIMA PARA "+quantidadeMinima+" do produto "+this.nome+" #############");
        this.quantidadeMinima=quantidadeMinima; 
    }
    
    public void reporEstoque(int quantidade)
    {
        System.out.println("");
        System.out.println("############# INSERINDO EM ESTOQUE "+quantidade+" itens do produto "+this.nome+" #############");
        this.quantidadeAtual+=quantidade;
    }
    
    public void baixarEstoque(int quantidade)
    {
        System.out.println("");
        System.out.println("############# RETIRANDO DO ESTOQUE "+quantidade+"  itens do produto "+this.nome+" #############");
        if(this.quantidadeAtual-quantidade>0)
        {   
            this.quantidadeAtual-=quantidade;
//            if(this.quantidadeAtual < this.quantidadeMinima)
//                System.out.println("Atencao, quantidade minima atingida");
        }
        else
        {   
            System.out.println("Não existe esta quantidade do produto "+this.nome+" em estoque");
            System.out.println("");
        }
    }
    
    public void imprimirProdutoEstoque()
    {
        System.out.println("");
        System.out.println("#############IMPRIMINDO O ESTOQUE DO PRODUTO "+this.nome+" #############");
        System.out.println("Nome:"+this.nome);
        System.out.println("Quantidade em estoque:"+this.quantidadeAtual);
        System.out.println("Quantidade minima:"+this.quantidadeMinima);
        System.out.println("");
    }
    
    public void precisaRepor()
    {
           if(this.quantidadeAtual < this.quantidadeMinima)
               System.out.println("Atencao, quantidade minima "+ this.nome +" atingida!");
           
           else
              System.out.println("Estoque do produto "+this.nome+" acima do minimo!");
    
    }
    


    
    
    
}
