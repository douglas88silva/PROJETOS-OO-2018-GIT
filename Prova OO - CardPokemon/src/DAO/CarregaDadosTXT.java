/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import cardPokemon.CarD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import pokebuy.Brinquedo;

/**
 * Classe responsavel pela leitura de arquivos
 *
 * @see CarD

 */
public class CarregaDadosTXT {

    Scanner ler = new Scanner(System.in);
    ArrayList retorno = new ArrayList();
    public static int compra=0;
    /**
     * Metodo responsavel pela leitura de arquivos Lê um arquivo no seguinte
     * modelo de linha (N# - NOME - TIPO - ATAQUE - EVOLUCAO) N#: Id do pokemon
     * Nome: nome do pokemon Ataque: força do pokemon Evolucao: Os id dos
     * pokemons são sequenciais, ou seja sua evolução é sempre id+1, caso o
     * pokemon não tenha evolução eu a varavel evolução fica com o valor 0
     * EXEMPLO:
     * (1-Bulbasaur-Planta-118-2) TEM DUAS EVOLUÇÕES
     * (2-Ivysaur-Planta-151-1)TEM UMA EVOLUÇÕES
     * (3-Venusaur-Planta-198-0)NAO TEM EVOLUÇÃO
     * @see CarD
     * @return retorno
     * @throws Exception para leitura do arquivo com os dados dos pokemons e para
     * os acessos as estruturas de armazenamentos
     */
    public ArrayList<CarD> carregarPokemons() throws Exception {

        //System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = "listaPokemon";//ler.nextLine();

        //System.out.printf("\nConteúdo do arquivo texto:\n");
//                try {
        FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto

        while (linha != null) {

            String array[] = new String[4];
            array = linha.split("-");

            int idPk = Integer.parseInt(array[0].trim());
            String nomePk = array[1].trim();
            String tipoPK = array[2].trim();
            int ataquePK = Integer.parseInt(array[3].trim());
            int evolucaoPK = Integer.parseInt(array[4].trim());

            CarD aux = new CarD(idPk, nomePk, tipoPK, ataquePK, evolucaoPK);

            this.retorno.add(aux);

            linha = lerArq.readLine(); // lê da segunda até a última linha
        }

        arq.close();

        return retorno;

    }
    
    public ArrayList<Brinquedo> carregarPokemonsBrinquedo() throws Exception {

        //System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = "listaPokemon";//ler.nextLine();

        //System.out.printf("\nConteúdo do arquivo texto:\n");
//                try {
        FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto

        while (linha != null) {

            String array[] = new String[4];
            array = linha.split("-");

            int idPk = Integer.parseInt(array[0].trim());
            String nomePk = array[1].trim();
            String tipoPK = array[2].trim();
            int ataquePK = Integer.parseInt(array[3].trim());
            int evolucaoPK = Integer.parseInt(array[4].trim());

           Brinquedo aux = new Brinquedo(idPk, nome, ataquePK, evolucaoPK,0);

            this.retorno.add(aux);

            linha = lerArq.readLine(); // lê da segunda até a última linha
        }

        arq.close();

        return retorno;

    }
    
     public void escrever (String res)
    {
        System.out.println (res);
        String result = res;
        //String endereco = JOptionPane.showInputDialog ("Digite o endereco do arquivos");
        //arquivo para ser lido
        String nome= "";
        compra++;
        nome.concat("RegistroCompra"+Integer.toString(compra)+".txt");
        //arquivo para escrita
        File arquivo2 = new File (nome);//definindo o nome do locar do arquivo
        try
        {
            arquivo2.createNewFile ();//arquivo criado
            
           
           /*ESCREVER*/
            FileWriter fileW = new FileWriter (arquivo2);//arquivo para escrita
            BufferedWriter buffW = new BufferedWriter (fileW);
            //enquanto tiver leitura
  
                System.out.println (result);
               // {
                    buffW.write (result);//Leia um arquivo e Escreva no outro
                    buffW.newLine ();//pula uma linha no arquivoescrever (result);
                
            
            buffW.close ();
        } catch (IOException io)
        {
        }
    }

}
