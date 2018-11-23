/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardPokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jessi
 */
public class CarregaDadosTXT {
    
    Scanner ler = new Scanner(System.in);
    ArrayList retorno = new ArrayList();
    
    public  ArrayList<CarD> carregarPokemons()
    {
        
                //System.out.printf("Informe o nome de arquivo texto:\n");
                String nome = "listaPokemon";//ler.nextLine();

                //System.out.printf("\nConteúdo do arquivo texto:\n");
                try {
                     FileReader arq = new FileReader(nome);
                     BufferedReader lerArq = new BufferedReader(arq);

                    String linha = lerArq.readLine(); // lê a primeira linha
                    // a variável "linha" recebe o valor "null" quando o processo
                    // de repetição atingir o final do arquivo texto
                  
                    while (linha != null) {
                        
                        String array[]= new String[4];
                        array = linha.split("-");
                        
                        int idPk = Integer.parseInt(array[0].trim());
                        String nomePk = array[1].trim();
                        String tipoPK = array[2].trim();
                        int ataquePK = Integer.parseInt(array[3].trim());
                        int evolucaoPK = Integer.parseInt(array[4].trim());
                                                
                        CarD aux = new CarD(idPk,nomePk,tipoPK,ataquePK,evolucaoPK);
                        
                        //System.out.println(aux.getPk().getNome()+" "+aux.getPk().getTipo());
                        this.retorno.add(aux);
                        
                        //System.out.println(idPk+nomePk+tipoPK+ataquePK);
                        //this.retorno.get(0).getPk().getNome();
                        //System.out.println(array[0].trim()+" "+array[1].trim()+" "+array[2].trim()+" "+array[3].trim());
                        //System.out.printf("%s\n", linha);

                    linha = lerArq.readLine(); // lê da segunda até a última linha
                  }
                  
                  arq.close();
                   
                  
                } 
                catch (IOException e)
                {
                    System.err.printf("Erro na abertura do arquivo: %s.\n",
                      e.getMessage());
                }

                //System.out.println();
                return retorno; 
      
    }
    
    
}
