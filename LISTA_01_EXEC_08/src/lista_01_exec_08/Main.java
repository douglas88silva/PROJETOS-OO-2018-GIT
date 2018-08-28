/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_01_exec_08;

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
        
// Instanciar um objeto da classe Funcionario utilizando o construtor sem parâmetros.
    
    Funcionarios a1 = new Funcionarios();

// Imprimir os valores dos atributos do objeto.
    a1.imprimirInformacoes();

// Instanciar um outro objeto da classe Funcionario utilizando o método construtor com os
//parâmetros nome e idade.
    Funcionarios a2 = new Funcionarios("Roberto",20);
// Imprimir os valores dos atributos do segundo objeto.
    a2.imprimirInformacoes();
// Instanciar um outro objeto da classe Funcionario utilizando o método construtor com os
//parâmetros matricula, nome e salario.
    Funcionarios a3 = new Funcionarios("201535028","Douglas",1500);
// Imprimir os valores dos atributos do terceiro objeto.
    a3.imprimirInformacoes();
        
        
    }
    
}
