/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class DAOMedicoPaciente {
    Connection connection=null;
    PreparedStatement pstatement=null;
    ResultSet rs=null;
    DAOMedico daomedico=new DAOMedico();
    DAOPaciente daopaciente=new DAOPaciente();
public int setMedicoPaciente(Medico_Paciente medicopaciente){
   
    int linhasafetadas=0;
    try{
     if(daomedico.VerficaSeoMedicoEstaNoBanco(medicopaciente.getMedico()) & daopaciente.VerficaSeoPacienteEstaNoBanco(medicopaciente.getPaciente())){
        connection=MyConnection.getConnection();
        pstatement=connection.prepareStatement("insert into paciente_medico(CRM, codigopaciente,horavisita,doenca) values(?,?,?,?)");
        pstatement.setString(1, medicopaciente.getMedico().getCRM());
        pstatement.setInt(2, medicopaciente.getPaciente().getCodigo());
        pstatement.setString(3,medicopaciente.getHorario_visita());
        pstatement.setString(4, medicopaciente.getDoenca());
        linhasafetadas=pstatement.executeUpdate();
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
    }
    return linhasafetadas;
}
public int removerMedicoPacienteByCRM(String CRM){
    int linhasafetadas=0;
    try{
        connection=MyConnection.getConnection();
        pstatement=connection.prepareStatement("DELETE from paciente_medico where CRM=?");
        pstatement.setString(1, CRM);
        linhasafetadas=pstatement.executeUpdate();
        }
    catch(SQLException e){
        e.printStackTrace();
    }
    return linhasafetadas;
}
public ArrayList<Medico_Paciente> getAll(){
    ArrayList<Medico_Paciente> medicospacientes=new ArrayList<>();
    try{
        connection=MyConnection.getConnection();
        pstatement=connection.prepareStatement("select *from paciente_medico");
        rs=pstatement.executeQuery();
        while(rs.next()){
            Medico_Paciente medicopaciente=new Medico_Paciente();
            medicopaciente.setPaciente(daopaciente.retornarPacienteByCodigo(rs.getInt("codigopaciente")));
            medicopaciente.setMedico(daomedico.retornarMedicoByCRM(rs.getString("CRM")));
            medicopaciente.setDoenca(rs.getString("doenca"));
            medicopaciente.setHorario_visita(rs.getString("horavisita"));
            medicospacientes.add(medicopaciente);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
        rs=null;
    }
    return medicospacientes;
}
public Medico_Paciente retornarMedicoPacienteByCRM(String CRM){
    Medico_Paciente medicopaciente=new Medico_Paciente();
    try{
        connection=MyConnection.getConnection();
        pstatement=connection.prepareStatement("Select *from paciente_medico where CRM=?");
        pstatement.setString(1, CRM);
        rs=pstatement.executeQuery();
        if(rs.next()){
         medicopaciente.setPaciente(daopaciente.retornarPacienteByCodigo(rs.getInt("codigopaciente")));
         medicopaciente.setMedico(daomedico.retornarMedicoByCRM(rs.getString("CRM")));
         medicopaciente.setHorario_visita(rs.getString("horavisita"));
         medicopaciente.setDoenca(rs.getString("doenca"));
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
        rs=null;
    }
    return medicopaciente;
}
}
