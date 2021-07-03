/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

/**
 *
 * @author Aluno
 */
public class Medico {
    private String CRM;
    private String nome;
    private double salario;
    private String data_de_admissao;
    public String getCRM() {
        return CRM;
    }
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getData_de_admissao() {
        return data_de_admissao;
    }

    public void setData_de_admissao(String data_de_admissao) {
        this.data_de_admissao = data_de_admissao;
    }
}
