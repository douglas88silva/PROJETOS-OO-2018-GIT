/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoadvinhacaooo;

/**
 *
 * @author HomeNot
 */
public class Jogo {
    
    private String NomeJogo;
    private Jogador Vencedor;
    private int numeroSorteado;

    public Jogo(){}
    
    public Jogo(String NomeJogo) {
        this.NomeJogo = NomeJogo;
        Sortear();
    }
    
    int jogar(Jogador a1,Jogador a2,Jogador a3)
    {
      if(a1.getNumero() == this.numeroSorteado)
      {   
          this.Vencedor = a1;
          return 1;
      }
      
      if(a2.getNumero() == this.numeroSorteado)
      {   
          this.Vencedor = a2;
          return 2;
      }
      
      if(a3.getNumero() == this.numeroSorteado)
      {   
          this.Vencedor = a3;
          return 3;
      }
      
      
     return 0;
    }
    
    void Sortear(){
    int a = (int) (Math.random() * 10);
    this.numeroSorteado = a;
    }

    public Jogador getVencedor() {
        return Vencedor;
    }
    
    
    
    
    
}
