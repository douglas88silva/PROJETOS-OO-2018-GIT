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
public class TesteEstoque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //CRIANDO PRODUTOS
        Estoque produto1 = new Estoque("Impressora Jato de tinta", 13, 6);
        Estoque produto2 = new Estoque("Monitor LCD 17 polegadas", 11, 13);
        Estoque produto3 = new Estoque("Mouse óptico", 6, 2);
        Estoque produto4 = new Estoque("Notebook", 5, 1);

        //IMPRIMINDO INFORMACOES DOS PRODUTOS
        produto1.imprimirProdutoEstoque();
        System.out.println("");
        produto2.imprimirProdutoEstoque();
        System.out.println("");
        produto3.imprimirProdutoEstoque();
        System.out.println("");
        produto4.imprimirProdutoEstoque();
        System.out.println("");
        
        
        //Dar baixa de 5 unidades do produto1;
        produto1.baixarEstoque(5);
        //Fazer a reposição de 7 unidades do produto2;
        produto2.reporEstoque(7);
        // Dar baixa em 4 unidades do produto3;
        produto3.baixarEstoque(4);

        produto4.baixarEstoque(6);
        
        
        //VERIFICANDO NECESSIDADE DE REPOR EM ESTOQUE
        produto1.precisaRepor();
        produto2.precisaRepor();
        produto3.precisaRepor();
        produto4.precisaRepor();
        
        
        //IMPRIMINDO INFORMACOES DOS PRODUTOS
        produto1.imprimirProdutoEstoque();
        System.out.println("");
        produto2.imprimirProdutoEstoque();
        System.out.println("");
        produto3.imprimirProdutoEstoque();
        System.out.println("");
        produto4.imprimirProdutoEstoque();
        System.out.println("");
    }
    
}
