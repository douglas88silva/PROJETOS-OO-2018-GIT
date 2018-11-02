/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedexjavaoo;

/**
 *
 * @author HomeNot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //A IDEIA É FAZER UMA AGENDA POKEMON, NA QUAL O USUARIO VAI INFORMAR ALGUMAS INFORMAÇÕES SOBRE O POKEMON QUE ELE TEM
        //EM SEGUIDA O PROGRAMA VAI BUSCAR NA BASE DE DADOS AS INFORMAÇÕES DO POKEMON COMO FORÇA ATAQUE E TIPO E VAI GUARDAR EM UMA
        //LISTA COM TODOS OS POKEMONS QUE ELE JÁ CAPTUROU.
        //PARA ISSO VOU UTILIZAR UMA BASE DE DADOS DE POKEMON (PLANILHA EXCEL) PARA CALCULAR OS STATUS DO POKEMON DO USUÁRIO
        //O USUÁRIO PODERÁ FILTRAR DE MANEIRA FACIL OS POKEMONS PELA FORÇA TIPO E ATAQUE PARA PODER ESCOLHER QUAIS POKEMONS DEVE
        //UTILIZAR EM UMA BATALHA QUALQUER.(PROGRAMA BASEADO NA ESTRUTURA DO JOGO POKEMON GO)
//        
	//Carregando arquivo especifico
		PlanilhaDAO excel = new PlanilhaDAO();
		//Apenas mostrando os valores
		     // System.out.println(excel.getStringColuna(0,"MALTA"));
                      
                      
                      if(excel.getIntColuna(1,90) !=0)
                      {  int a = excel.getIntColuna(1,90);
                         System.out.println(a);
                      }
                    
    }
    
}
