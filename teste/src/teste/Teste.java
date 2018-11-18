/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jessi
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    static Thread T = new Thread();
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
//        
//           for (int c = 20; c >= 0; c--) {
//            T.sleep(1000);                                  
//           System.out.println(c);
//      
//    }

        Random r = new Random();
        
        System.out.println(r.nextInt(2));
        System.out.println(r.nextInt(2));
        System.out.println(r.nextInt(2));
        System.out.println(r.nextInt(2));
//        List a = new ArrayList();
//        
//        a.add("1");
//        a.add("2");
//        a.add("3");
//        a.add("4");
//        
//        String b = (String) a.get(0);
//        
//        System.out.println(b);

//            Scanner ler = new Scanner(System.in);
//
//                System.out.printf("Informe o nome de arquivo texto:\n");
//                String nome = ler.nextLine();
//
//                System.out.printf("\nConteúdo do arquivo texto:\n");
//                try {
//                     FileReader arq = new FileReader(nome);
//                     BufferedReader lerArq = new BufferedReader(arq);
//
//                    String linha = lerArq.readLine(); // lê a primeira linha
//                    // a variável "linha" recebe o valor "null" quando o processo
//                    // de repetição atingir o final do arquivo texto
//                  
//                    while (linha != null) {
//                    System.out.printf("%s\n", linha);
//
//                    linha = lerArq.readLine(); // lê da segunda até a última linha
//                  }
//
//                  arq.close();
//                } 
//                catch (IOException e)
//                {
//                    System.err.printf("Erro na abertura do arquivo: %s.\n",
//                      e.getMessage());
//                }
//
//                System.out.println();
//
//
//
                }
    
}
