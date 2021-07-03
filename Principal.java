/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Medico medicos[]=new Medico[2];
       Paciente pacientes[]=new Paciente[2];
       DAOPaciente daopaciente=new DAOPaciente();
       DAOMedico daomedico=new DAOMedico();
       DAOMedicoPaciente daomedicopaciente=new DAOMedicoPaciente();
       for(int i=0;i<2;i++){
           medicos[i]=new Medico();
           pacientes[i]=new Paciente();
       }
       Medico_Paciente medicopaciente=new Medico_Paciente();
       medicos[0].setNome("Juliao");
       medicos[0].setCRM("12345");
       medicos[0].setSalario(1230);
       medicos[0].setData_de_admissao("13/07/2008");
       medicos[1].setNome("Márcio");
       medicos[1].setCRM("456");
       medicos[1].setData_de_admissao("12/09/2003");
       medicos[1].setSalario(3219);
       pacientes[0].setNome("Gustavo");
       pacientes[0].setCPF("78621497845678790");
       pacientes[0].setRG("67556852041829748985");
       pacientes[0].setEndereco("Rua XY, Bairro YZ, Cidade ZY");
       pacientes[0].setTelefone_para_contato("8299962322");
       pacientes[0].setCodigo(1);
       pacientes[1].setNome("Julia");
       pacientes[1].setCPF("12345678790");
       pacientes[1].setRG("675568585");
       pacientes[1].setEndereco("Rua X, Bairro Y, Cidade Z");
       pacientes[1].setTelefone_para_contato("8299762311");
       pacientes[1].setCodigo(2);
       medicopaciente.setMedico(medicos[0]);
       medicopaciente.setPaciente(pacientes[0]);
       medicopaciente.setHorario_visita("14:30");
       medicopaciente.setDoenca("Gripe Suína");
      // daopaciente.setPaciente(pacientes[0]);
      // daopaciente.setPaciente(pacientes[1]);
    //   daomedico.setMedico(medicos[0]);
    //   daomedico.setMedico(medicos[1]);
  //     daomedicopaciente.setMedicoPaciente(medicopaciente);
       ArrayList<Medico_Paciente> medicospacientes=new ArrayList<>();
       medicospacientes=daomedicopaciente.getAll();
       for(Medico_Paciente medicopaciente1:medicospacientes){
       System.out.println(""+medicopaciente1.getMedico().getNome());
       System.out.println(""+medicopaciente1.getPaciente().getNome());
       System.out.println(""+medicopaciente1.getHorario_visita());
       System.out.println(""+medicopaciente1.getDoenca());
    }
}
}
