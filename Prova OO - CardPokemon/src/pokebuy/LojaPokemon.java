/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokebuy;

import DAO.CarregaDadosTXT;
import cardPokemon.Pokemon;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ice
 */
public class LojaPokemon {
    
    private List<Brinquedo> listapokemon;
    private List<CarrinhoCompra> carrinhoCompras;
    private static double lucro=0;
    private  String compra = "";
    private boolean sairLoja = false;
    Scanner ler = new Scanner(System.in);
    
    
    public LojaPokemon() {
        
        carrinhoCompras = new ArrayList();
        listapokemon = new ArrayList();
        PKBudyAgua pk = new PKBudyAgua("Agua", "Pokemon1", 5);
        PKBudyAgua pk2 = new PKBudyAgua("FOGO", "Pokemon2", 6);
        PKBudyAgua pk3 = new PKBudyAgua("vento", "Pokemon3", 7);
        PKBudyAgua pk4 = new PKBudyAgua("planta", "Pokemon4", 8);
        
        
        listapokemon.add(pk);
        listapokemon.add(pk2);
        listapokemon.add(pk3);
        listapokemon.add(pk4);
        
        
        
//        
//         CarregaDadosTXT loadCartas = new CarregaDadosTXT();
//        try {
//            listapokemon = loadCartas.carregarPokemonsBrinquedo();
//            
//                
//            
//        } catch (Exception ex) {
//            Logger.getLogger(LojaPokemon.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
      
    public void menuLoja()
    {
        
            System.out.println("#### LOADING LOJA VIRTUAL ####");
        
        while (this.sairLoja == false) {
            System.out.println("\n#### Loja Pokemons####");
            System.out.println("#####MENU PRINCIPAL#####");
            System.out.println("( 1) - Produtos");
            System.out.println("( 2) - Comprar");
            System.out.println("( 3) - Carrinho");
            System.out.println("(-1) - SAIR");
            int opcao = ler.nextInt();
            if (opcao == 1) {
                
                this.exibirPokemonsVenda();
            }
            if (opcao == 2) {
                this.VenderBrinquedo();
            }
            if (opcao == 3) {
               this.exibirCompras();
            }
            if (opcao == -1) {
                this.sairLoja = true;
            }
        }
        
        
    }
    
    public void exibirPokemonsVenda(){
        
        System.out.println("Brinquedos disponiveis");
        for (Brinquedo brinquedo : listapokemon) {
            
            System.out.print("N#"+listapokemon.indexOf(brinquedo));
            brinquedo.mostrarBrinquedo();
            
        }
        
    }
    public void VenderBrinquedo()
    {
        
        System.out.println("Qual N# do pokemon que deseja comprar");
        int numerPokemon,quantidade;
          
        numerPokemon = ler.nextInt();
        System.out.println("Quantos pokemons você deseja");
            
        quantidade = ler.nextInt();
        try {
            
            if(quantidade>0)
            {
                CarrinhoCompra novaCompra = new CarrinhoCompra();
                novaCompra.addBriquedo(listapokemon.get(numerPokemon), quantidade);
                
                carrinhoCompras.add(novaCompra);
            }
               
        else
           throw new ValorInvalidoException();
            
        } catch (ValorInvalidoException e) {
            System.out.println(e.getMessage());
        }
 
 
        
    }
    

    
    public void exibirCompras(){
        
        double totalCompras =0;
         
        String str = "";
        
        for (CarrinhoCompra produto : carrinhoCompras) {
            
            produto.exibirProdutos();
            
            totalCompras+=produto.getQuantidade()*produto.getPreco();
            
            this.compra.concat(produto.getnomeProduto());
            this.compra.concat("\t");
            this.compra.concat(Integer.toString(produto.getQuantidade()));
            this.compra.concat("\n");
            
        }
        compra.concat("\nTotal compra:");
        compra.concat(Double.toString(totalCompras));
        System.out.println("Venda Total da compra:"+totalCompras);
        
        
        while(this.sairLoja == false){
         
            CarregaDadosTXT salvar = new CarregaDadosTXT();
            System.out.println("#####MENU COMPRAS#####");
            System.out.println("( 1) - Finalizar Compra");
            System.out.println("( 2) - Salvar Compra");
            System.out.println("( 3) - Esvaziar Carrinho");
            System.out.println("(-1) - Voltar");
            int opcao = ler.nextInt();
            if (opcao == 1) {
                
                salvar.escrever(this.compra);
                System.exit(0);
                
            }
            if (opcao == 2) {
                  salvar.escrever(this.compra);

            }
            if (opcao == 3) {
               carrinhoCompras.removeAll(this.carrinhoCompras);
               compra = "";
                
            }
            if (opcao == -1) {
                this.menuLoja();
            }
            
            
        }
        
        
    }

    @Override
    public String toString() {
        return "LojaPokemon{" + "listapokemon=" + listapokemon + '}';
    }
    
    

    
    
    
    
    
    
    
    
    
}
