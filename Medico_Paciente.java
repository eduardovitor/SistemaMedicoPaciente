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
public class Medico_Paciente {

    private Medico medico;
    private Paciente paciente;
    private String horario_visita;
    private String Doenca;
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getHorario_visita() {
        return horario_visita;
    }

    public void setHorario_visita(String horario_visita) {
        this.horario_visita = horario_visita;
    }

    public String getDoenca() {
        return Doenca;
    }

    public void setDoenca(String Doenca) {
        this.Doenca = Doenca;
    }
    
}
