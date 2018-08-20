/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoadvinhacaooo;

import java.util.Scanner;

/**
 *
 * @author HomeNot
 */
public class ProgramaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int finalizarAplicacao = -1;
        String nomeJog;

        Jogo x3 = new Jogo("Advinhacao");
        

        
        Scanner ler = new Scanner(System.in);
        

            System.out.printf("Informe o nome do jogador: ");
             nomeJog= ler.next();
            Jogador a1 = new Jogador(nomeJog);
            
            ler.nextLine();
            
            System.out.printf("Informe o nome do jogador: ");
            nomeJog= ler.next();
            Jogador a2 = new Jogador(nomeJog);
            
            ler.nextLine();
            
            System.out.printf("Informe o nome do jogador: ");
            nomeJog= ler.next();
            Jogador a3 = new Jogador(nomeJog);
            
            ler.nextLine();
            
            
        while (finalizarAplicacao != 0)
        {
            
            x3.Sortear();
            a1.Sortear();
            a2.Sortear();
            a3.Sortear();
            finalizarAplicacao = x3.jogar(a1, a2, a3);
            if(finalizarAplicacao == 0)
            {   
                System.out.println("Nenhum jogador venceu!");
                System.out.println("Deseja continuar?");
                System.out.println("1 - SIM");
                System.out.println("0 - NAO");
                finalizarAplicacao = ler.nextInt();
                
            }
            
        }
        if(finalizarAplicacao >= 1)
        {
           System.out.println("O vencedor foi o jogador "+ x3.getVencedor().getNomeJogador());
        }
        
        System.out.println("Jogo finalizado! ");
    }
    
}
