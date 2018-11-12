
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ice
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame janela = new JFrame("Janela1");
        JPanel painel = new JPanel();
        JLabel resposta = new JLabel("Digite seu nome");
        JButton botao1 = new JButton("Botao1");
        JButton botao2 = new JButton("Botao2");
        JButton botao3 = new JButton("Botao3");
        JButton botao4 = new JButton("Botao4");
        JButton botao5 = new JButton("Botao5");
         painel.setLayout(new BorderLayout());
        
        
        painel.add(botao1,BorderLayout.NORTH);
        painel.add(botao2,BorderLayout.SOUTH);
        painel.add(botao3,BorderLayout.WEST);
        painel.add(botao4,BorderLayout.EAST);
        painel.add(botao5,BorderLayout.CENTER);
        
       
        janela.getContentPane().add(painel);

        janela.pack();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
}
