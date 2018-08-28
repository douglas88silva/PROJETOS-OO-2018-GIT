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
public class Funcionarios {
    
public static int numeroFuncionarios=0;
private String matricula;
private String nome;
private int idade;
private String cargo;
private int salario;

    public Funcionarios() {
        this.salario = 1500;
        numeroFuncionarios++;
    }

    public Funcionarios(String nome, int idade) {
        this.nome=nome;
        this.idade=idade;
        numeroFuncionarios++;
    }
    
    
    public Funcionarios(String matricula, String nome, int salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
        numeroFuncionarios++;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    

    public void imprimirInformacoes()
    {
        System.out.println("######################################################");
        System.out.println("Matricula: "+this.matricula);
        System.out.println("Nome:" +this.nome);
        System.out.println("Idade: "+this.idade);
        System.out.println("Cargo: "+this.cargo);
        System.out.println("Salario: R$"+this.salario);
        System.out.println("Total de funcionarios: "+numeroFuncionarios);
        System.out.println("");
        System.out.println("");        
    
    }


}
